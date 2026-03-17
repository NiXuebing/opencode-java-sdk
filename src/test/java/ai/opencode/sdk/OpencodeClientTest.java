package ai.opencode.sdk;

import static org.junit.jupiter.api.Assertions.*;

import ai.opencode.sdk.api.AppApi;
import ai.opencode.sdk.api.AuthApi;
import ai.opencode.sdk.api.GlobalApi;
import ai.opencode.sdk.api.McpApi;
import ai.opencode.sdk.core.OpencodeClientConfig;
import ai.opencode.sdk.model.EventInstallationUpdated;
import ai.opencode.sdk.model.SessionPromptBody;
import ai.opencode.sdk.model.UserMessage;
import ai.opencode.sdk.request.FileListRequest;
import ai.opencode.sdk.request.SessionMessageRequest;
import ai.opencode.sdk.request.SessionPromptRequest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class OpencodeClientTest {
  @Test
  void healthCallUsesConfiguredDirectoryHeader() throws Exception {
    var header = new AtomicReference<String>();

    try (var server =
        server(
            Map.of(
                "/global/health",
                (HttpHandler)
                    (exchange) -> {
                      header.set(exchange.getRequestHeaders().getFirst("x-opencode-directory"));
                      assertEquals("/global/health", exchange.getRequestURI().getPath());
                      json(
                          exchange,
                          """
               {"healthy":true,"version":"1.2.3"}
               """);
                    }))) {
      var client =
          new OpencodeClient(
              OpencodeClientConfig.builder()
                  .baseUrl(server.baseUrl())
                  .directory("/tmp/项目")
                  .build());

      var health = client.global().health();

      assertTrue(health.healthy());
      assertEquals("1.2.3", health.version());
      assertEquals("%2Ftmp%2F%E9%A1%B9%E7%9B%AE", header.get());
    }
  }

  @Test
  void eventStreamParsesUnionEventPayload() throws Exception {
    try (var server =
        server(
            Map.of(
                "/event",
                (HttpHandler)
                    (exchange) -> {
                      assertEquals("/event", exchange.getRequestURI().getPath());
                      exchange.getResponseHeaders().add("Content-Type", "text/event-stream");
                      exchange.sendResponseHeaders(200, 0);
                      try (var out = exchange.getResponseBody()) {
                        out.write(
                            """
                 event: message
                 id: 1
                 data: {"type":"installation.updated","properties":{"version":"1.2.3"}}

                 """
                                .getBytes(StandardCharsets.UTF_8));
                        out.flush();
                      }
                    }))) {
      var client =
          new OpencodeClient(OpencodeClientConfig.builder().baseUrl(server.baseUrl()).build());

      try (var stream = client.event().subscribe()) {
        var iterator = stream.iterator();
        assertTrue(iterator.hasNext());

        var item = iterator.next();

        assertEquals("message", item.event());
        assertEquals("1", item.id());
        assertTrue(item.data() instanceof EventInstallationUpdated);
        assertEquals("1.2.3", ((EventInstallationUpdated) item.data()).properties().version());
        assertFalse(iterator.hasNext());
      }
    }
  }

  @Test
  void promptSupportsUserMessageResponseWhenNoReplyIsTrue() throws Exception {
    try (var server =
        server(
            Map.of(
                "/session/ses_123/message",
                (HttpHandler)
                    (exchange) -> {
                      assertEquals("/session/ses_123/message", exchange.getRequestURI().getPath());
                      json(
                          exchange,
                          """
               {
                 "info": {
                   "id": "msg_1",
                   "sessionID": "ses_123",
                   "role": "user"
                 },
                 "parts": []
               }
               """);
                    }))) {
      var client =
          new OpencodeClient(OpencodeClientConfig.builder().baseUrl(server.baseUrl()).build());

      var response =
          client
              .session()
              .prompt(
                  new SessionPromptRequest(
                      "ses_123",
                      null,
                      new SessionPromptBody(
                          null, null, null, true, null, null, null, null, java.util.List.of())));

      var message = assertInstanceOf(UserMessage.class, response.info());
      assertEquals("user", message.role());
      assertTrue(response.parts().isEmpty());
    }
  }

  @Test
  void requiredFieldsFailFastBeforeSendingHttpRequests() {
    var client = new OpencodeClient();

    assertThrows(
        NullPointerException.class, () -> client.file().list(new FileListRequest(null, null)));
    assertThrows(
        NullPointerException.class,
        () -> client.session().message(new SessionMessageRequest("ses_123", null, null)));
  }

  @Test
  void publicSurfaceMatchesDocumentedApis() {
    var clientMethods = declaredMethodNames(OpencodeClient.class);
    assertFalse(clientMethods.contains("mirror"));
    assertFalse(clientMethods.contains("pty"));
    assertFalse(clientMethods.contains("worktree"));
    assertFalse(clientMethods.contains("experimental"));
    assertFalse(clientMethods.contains("question"));

    assertFalse(declaredMethodNames(GlobalApi.class).contains("config"));
    assertFalse(declaredMethodNames(GlobalApi.class).contains("dispose"));
    assertFalse(declaredMethodNames(AppApi.class).contains("skills"));
    assertFalse(declaredMethodNames(AuthApi.class).contains("remove"));
    assertFalse(declaredMethodNames(McpApi.class).contains("auth"));
    assertFalse(declaredMethodNames(McpApi.class).contains("connect"));
    assertFalse(declaredMethodNames(McpApi.class).contains("disconnect"));
  }

  private TestServer server(Map<String, HttpHandler> handlers) throws IOException {
    var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    for (var entry : handlers.entrySet()) {
      server.createContext(entry.getKey(), entry.getValue());
    }
    server.start();
    return new TestServer(server);
  }

  private void json(HttpExchange exchange, String body) throws IOException {
    var data = body.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().add("Content-Type", "application/json");
    exchange.sendResponseHeaders(200, data.length);
    try (var out = exchange.getResponseBody()) {
      out.write(data);
    }
  }

  private record TestServer(HttpServer server) implements AutoCloseable {
    private String baseUrl() {
      return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    @Override
    public void close() {
      server.stop(0);
    }
  }

  private Set<String> declaredMethodNames(Class<?> type) {
    return Arrays.stream(type.getDeclaredMethods())
        .filter((method) -> java.lang.reflect.Modifier.isPublic(method.getModifiers()))
        .map(Method::getName)
        .collect(java.util.stream.Collectors.toSet());
  }
}
