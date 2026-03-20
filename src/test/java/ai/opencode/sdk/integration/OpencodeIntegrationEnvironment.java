package ai.opencode.sdk.integration;

import ai.opencode.sdk.OpencodeClient;
import ai.opencode.sdk.core.OpencodeClientConfig;
import ai.opencode.sdk.model.Session;
import ai.opencode.sdk.model.SessionCreateBody;
import ai.opencode.sdk.request.SessionCreateRequest;
import ai.opencode.sdk.request.SessionDeleteRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/** 负责拉起隔离版 opencode serve 的集成测试环境。 */
final class OpencodeIntegrationEnvironment implements AutoCloseable {
  private static final Duration COMMAND_TIMEOUT = Duration.ofSeconds(20);
  private static final Duration STARTUP_TIMEOUT = Duration.ofSeconds(60);
  private static final Duration HTTP_TIMEOUT = Duration.ofSeconds(15);

  private static final Object LOCK = new Object();

  private static OpencodeIntegrationEnvironment shared;

  private final Path rootDir;
  private final Path homeDir;
  private final Path workspaceDir;
  private final Path logFile;
  private final String baseUrl;
  private final boolean keepTempFiles;
  private final HttpClient httpClient;
  private final ObjectMapper objectMapper;
  private final Process serverProcess;
  private final OpencodeClient client;

  private JsonNode openApiDocument;
  private boolean closed;

  /** 获取当前 JVM 共享的集成测试环境。 */
  static OpencodeIntegrationEnvironment shared() {
    synchronized (LOCK) {
      if (shared == null) {
        shared = new OpencodeIntegrationEnvironment();
      }
      return shared;
    }
  }

  private OpencodeIntegrationEnvironment() {
    Path createdRoot = null;
    Path createdHome = null;
    Path createdWorkspace = null;
    Path createdLogFile = null;
    Process createdProcess = null;
    boolean keepTmp =
        Boolean.parseBoolean(System.getenv().getOrDefault("OPENCODE_IT_KEEP_TMP", "false"));

    try {
      createdRoot = createRootDirectory();
      createdHome = Files.createDirectories(createdRoot.resolve("home")).toRealPath();
      createdWorkspace = Files.createDirectories(createdRoot.resolve("workspace")).toRealPath();
      createdLogFile = createdRoot.resolve("opencode-serve.log");
      Files.createDirectories(createdHome.resolve(".config/opencode"));
      Files.createDirectories(createdHome.resolve(".local/share"));
      Files.writeString(
          createdHome.resolve(".config/opencode/opencode.json"),
          "{\n  \"plugin\": []\n}\n",
          StandardCharsets.UTF_8);

      initializeWorkspace(createdWorkspace);

      var port = findFreePort();
      var resolvedBaseUrl = "http://127.0.0.1:" + port;
      var resolvedHttpClient = HttpClient.newBuilder().connectTimeout(HTTP_TIMEOUT).build();
      var resolvedObjectMapper = new ObjectMapper();

      createdProcess =
          startServer(createdWorkspace, createdHome, createdLogFile, Integer.toString(port));
      waitUntilHealthy(resolvedHttpClient, resolvedBaseUrl, createdProcess, createdLogFile);

      this.rootDir = createdRoot;
      this.homeDir = createdHome;
      this.workspaceDir = createdWorkspace;
      this.logFile = createdLogFile;
      this.baseUrl = resolvedBaseUrl;
      this.keepTempFiles = keepTmp;
      this.httpClient = resolvedHttpClient;
      this.objectMapper = resolvedObjectMapper;
      this.serverProcess = createdProcess;
      this.client =
          new OpencodeClient(
              OpencodeClientConfig.builder()
                  .baseUrl(resolvedBaseUrl)
                  .directory(createdWorkspace.toString())
                  .timeout(Duration.ofSeconds(90))
                  .build());

      Runtime.getRuntime()
          .addShutdownHook(
              new Thread(
                  () -> {
                    try {
                      close();
                    } catch (Exception ignored) {
                    }
                  },
                  "opencode-java-sdk-it-shutdown"));
    } catch (Exception error) {
      stopProcess(createdProcess);
      if (!keepTmp) {
        deleteRecursively(createdRoot);
      }
      throw new IllegalStateException(
          "Failed to prepare opencode integration test environment", error);
    }
  }

  /** 返回真实 serve 对应的 SDK 客户端。 */
  OpencodeClient client() {
    return client;
  }

  /** 返回隔离测试工作区目录。 */
  Path workspaceDir() {
    return workspaceDir;
  }

  /** 返回隔离测试 HOME 目录。 */
  Path homeDir() {
    return homeDir;
  }

  /** 返回真实 serve 的基础 URL。 */
  String baseUrl() {
    return baseUrl;
  }

  /** 返回服务端日志文件路径。 */
  Path logFile() {
    return logFile;
  }

  /** 读取实时 `/doc` 文档并缓存。 */
  JsonNode openApiDocument() {
    if (openApiDocument == null) {
      try {
        var request =
            HttpRequest.newBuilder(URI.create(baseUrl + "/doc"))
                .timeout(HTTP_TIMEOUT)
                .GET()
                .build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
          throw new IllegalStateException(
              "Failed to fetch /doc from opencode serve, status="
                  + response.statusCode()
                  + ", body="
                  + response.body());
        }
        openApiDocument = objectMapper.readTree(response.body());
      } catch (IOException | InterruptedException error) {
        if (error instanceof InterruptedException) {
          Thread.currentThread().interrupt();
        }
        throw new IllegalStateException("Failed to fetch /doc from opencode serve", error);
      }
    }
    return openApiDocument;
  }

  /** 在测试工作区中追加 README 内容，便于验证文件状态接口。 */
  void appendReadmeLine(String line) {
    try {
      Files.writeString(
          workspaceDir.resolve("README.md"),
          System.lineSeparator() + line,
          StandardCharsets.UTF_8,
          StandardOpenOption.APPEND);
    } catch (IOException error) {
      throw new IllegalStateException("Failed to mutate README.md in integration workspace", error);
    }
  }

  /** 创建一个最小会话，用于验证会话生命周期与事件流。 */
  Session createSession(String title) {
    return client
        .session()
        .create(new SessionCreateRequest(null, new SessionCreateBody(null, title, null, null)));
  }

  /** 尽最大努力删除指定会话，避免测试残留。 */
  void deleteSessionQuietly(String sessionId) {
    try {
      client.session().delete(new SessionDeleteRequest(sessionId, null));
    } catch (RuntimeException ignored) {
    }
  }

  /** 读取当前服务日志，便于失败排查。 */
  String readServerLogs() {
    try {
      if (!Files.exists(logFile)) {
        return "";
      }
      return Files.readString(logFile, StandardCharsets.UTF_8);
    } catch (IOException error) {
      return "<failed to read log file: " + error.getMessage() + ">";
    }
  }

  @Override
  public void close() {
    synchronized (LOCK) {
      if (closed) {
        return;
      }
      closed = true;
    }

    stopProcess(serverProcess);
    if (!keepTempFiles) {
      deleteRecursively(rootDir);
    }
  }

  private int findFreePort() throws IOException {
    try (var socket = new ServerSocket(0)) {
      return socket.getLocalPort();
    }
  }

  private Path createRootDirectory() throws IOException {
    var preferred = Path.of("/tmp");
    if (Files.isDirectory(preferred) && Files.isWritable(preferred)) {
      return Files.createTempDirectory(preferred, "opencode-java-sdk-it-").toRealPath();
    }
    return Files.createTempDirectory("opencode-java-sdk-it-").toRealPath();
  }

  private void initializeWorkspace(Path workspace) throws IOException, InterruptedException {
    Files.createDirectories(workspace.resolve("src/main/java"));
    Files.createDirectories(workspace.resolve("demo"));
    Files.writeString(
        workspace.resolve("README.md"),
        "# Integration Fixture\nhello opencode\n",
        StandardCharsets.UTF_8);
    Files.writeString(
        workspace.resolve("src/main/java/App.java"),
        "public class App {\n"
            + "  String value() {\n"
            + "    return \"alpha-beta\";\n"
            + "  }\n"
            + "}\n",
        StandardCharsets.UTF_8);
    Files.writeString(
        workspace.resolve("demo/info.txt"), "integration fixture file\n", StandardCharsets.UTF_8);

    runCommand(workspace, "git", "init", "-b", "main");
    runCommand(workspace, "git", "config", "user.name", "Codex");
    runCommand(workspace, "git", "config", "user.email", "codex@example.com");
    runCommand(workspace, "git", "add", ".");
    runCommand(workspace, "git", "commit", "-m", "integration-fixture");
  }

  private void runCommand(Path workdir, String... command)
      throws IOException, InterruptedException {
    var builder = new ProcessBuilder(command);
    builder.directory(workdir.toFile());
    builder.redirectErrorStream(true);
    var process = builder.start();
    var output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    if (!process.waitFor(COMMAND_TIMEOUT.toSeconds(), TimeUnit.SECONDS)) {
      process.destroyForcibly();
      throw new IllegalStateException("Command timed out: " + String.join(" ", command));
    }
    if (process.exitValue() != 0) {
      throw new IllegalStateException(
          "Command failed: " + String.join(" ", command) + System.lineSeparator() + output);
    }
  }

  private Process startServer(Path workspace, Path home, Path serverLog, String port)
      throws IOException {
    var binary = resolveOpencodeBinary();
    var builder =
        new ProcessBuilder(
            binary, "serve", "--hostname", "127.0.0.1", "--port", port, "--print-logs");
    builder.directory(workspace.toFile());
    builder.redirectErrorStream(true);
    builder.redirectOutput(ProcessBuilder.Redirect.appendTo(serverLog.toFile()));

    var env = builder.environment();
    env.put("HOME", home.toString());
    env.put("XDG_CONFIG_HOME", home.resolve(".config").toString());
    env.put("XDG_DATA_HOME", home.resolve(".local/share").toString());

    return builder.start();
  }

  private String resolveOpencodeBinary() {
    var configured = System.getenv("OPENCODE_BIN");
    if (configured != null && !configured.isBlank()) {
      return configured;
    }
    return "opencode";
  }

  private void waitUntilHealthy(
      HttpClient client, String serverBaseUrl, Process process, Path serverLog)
      throws IOException, InterruptedException {
    var deadline = Instant.now().plus(STARTUP_TIMEOUT);
    var request =
        HttpRequest.newBuilder(URI.create(serverBaseUrl + "/global/health"))
            .timeout(HTTP_TIMEOUT)
            .GET()
            .build();

    while (Instant.now().isBefore(deadline)) {
      if (!process.isAlive()) {
        throw new IllegalStateException(
            "opencode serve exited before health check passed."
                + System.lineSeparator()
                + readFile(serverLog));
      }

      try {
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
          return;
        }
      } catch (IOException ignored) {
      }

      Thread.sleep(250);
    }

    throw new IllegalStateException(
        "Timed out waiting for opencode serve to become healthy."
            + System.lineSeparator()
            + readFile(serverLog));
  }

  private String readFile(Path path) {
    try {
      if (path == null || !Files.exists(path)) {
        return "";
      }
      return Files.readString(path, StandardCharsets.UTF_8);
    } catch (IOException error) {
      return "<failed to read file: " + error.getMessage() + ">";
    }
  }

  private void stopProcess(Process process) {
    if (process == null) {
      return;
    }
    if (!process.isAlive()) {
      return;
    }

    process.destroy();
    try {
      if (!process.waitFor(10, TimeUnit.SECONDS)) {
        process.destroyForcibly();
        process.waitFor(10, TimeUnit.SECONDS);
      }
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      process.destroyForcibly();
    }
  }

  private void deleteRecursively(Path root) {
    if (root == null || !Files.exists(root)) {
      return;
    }

    try (var stream = Files.walk(root)) {
      stream.sorted(Comparator.reverseOrder()).forEach(this::deletePathQuietly);
    } catch (IOException ignored) {
    }
  }

  private void deletePathQuietly(Path path) {
    try {
      Files.deleteIfExists(path);
    } catch (IOException ignored) {
    }
  }
}
