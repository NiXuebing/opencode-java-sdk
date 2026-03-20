package ai.opencode.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.core.ReactiveOpencodeClientConfig;
import ai.opencode.sdk.model.EventInstallationUpdated;
import ai.opencode.sdk.model.QuestionAnswer;
import ai.opencode.sdk.model.QuestionReplyBody;
import ai.opencode.sdk.request.QuestionRejectRequest;
import ai.opencode.sdk.request.QuestionReplyRequest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class ReactiveOpencodeClientTest {
  @Test
  void reactiveClientSupportsSessionQuestionAndEventApis() throws Exception {
    var replyBody = new AtomicReference<String>();
    var rejectPath = new AtomicReference<String>();

    try (var server =
        server(
            Map.of(
                "/session",
                (HttpHandler)
                    exchange -> json(exchange, "[{\"id\":\"ses_123\",\"title\":\"demo\"}]"),
                "/question",
                (HttpHandler)
                    exchange ->
                        json(
                            exchange,
                            "[{\"id\":\"que_123\",\"sessionID\":\"ses_123\",\"questions\":[]}]"),
                "/question/que_123/reply",
                (HttpHandler)
                    exchange -> {
                      replyBody.set(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
                      json(exchange, "true");
                    },
                "/question/que_123/reject",
                (HttpHandler)
                    exchange -> {
                      rejectPath.set(exchange.getRequestURI().getPath());
                      json(exchange, "true");
                    },
                "/event",
                (HttpHandler)
                    exchange -> {
                      exchange.getResponseHeaders().add("Content-Type", "text/event-stream");
                      exchange.sendResponseHeaders(200, 0);
                      try (var out = exchange.getResponseBody()) {
                        out.write(
                            ("event: message\n"
                                    + "id: evt_1\n"
                                    + "data: {\"type\":\"installation.updated\",\"properties\":{\"version\":\"1.2.3\"}}\n\n")
                                .getBytes(StandardCharsets.UTF_8));
                        out.flush();
                      }
                    }))) {
      var client =
          new ReactiveOpencodeClient(
              ReactiveOpencodeClientConfig.builder()
                  .baseUrl(server.baseUrl())
                  .timeout(Duration.ofSeconds(5))
                  .directory("/workspace/sample")
                  .build());

      var sessions = client.session().list().block(Duration.ofSeconds(5));
      assertEquals(1, sessions.size());
      assertEquals("ses_123", sessions.get(0).id());

      var questions = client.question().list().block(Duration.ofSeconds(5));
      assertEquals(1, questions.size());
      assertEquals("que_123", questions.get(0).id());

      var replied =
          client
              .question()
              .reply(
                  new QuestionReplyRequest(
                      "que_123",
                      null,
                      new QuestionReplyBody(List.of(new QuestionAnswer(List.of("yes"))))))
              .block(Duration.ofSeconds(5));
      assertTrue(Boolean.TRUE.equals(replied));
      assertTrue(replyBody.get().contains("\"answers\""));

      var rejected =
          client
              .question()
              .reject(new QuestionRejectRequest("que_123", null))
              .block(Duration.ofSeconds(5));
      assertTrue(Boolean.TRUE.equals(rejected));
      assertEquals("/question/que_123/reject", rejectPath.get());

      var event = client.event().subscribe().next().block(Duration.ofSeconds(5));
      assertEquals("message", event.event());
      assertEquals("evt_1", event.id());
      assertTrue(event.data() instanceof EventInstallationUpdated);
      assertEquals("1.2.3", ((EventInstallationUpdated) event.data()).properties().version());
    }
  }

  @Test
  void syncQuestionApiUsesExpectedRoutes() throws Exception {
    var replyBody = new AtomicReference<String>();

    try (var server =
        server(
            Map.of(
                "/question",
                (HttpHandler)
                    exchange ->
                        json(
                            exchange,
                            "[{\"id\":\"que_456\",\"sessionID\":\"ses_456\",\"questions\":[]}]"),
                "/question/que_456/reply",
                (HttpHandler)
                    exchange -> {
                      replyBody.set(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
                      json(exchange, "true");
                    },
                "/question/que_456/reject",
                (HttpHandler) exchange -> json(exchange, "true")))) {
      var client = new OpencodeClient(ai.opencode.sdk.core.OpencodeClientConfig.builder().baseUrl(server.baseUrl()).build());

      var questions = client.question().list();
      assertEquals(1, questions.size());
      assertEquals("que_456", questions.get(0).id());

      assertTrue(
          Boolean.TRUE.equals(
              client
                  .question()
                  .reply(
                      new QuestionReplyRequest(
                          "que_456",
                          null,
                          new QuestionReplyBody(List.of(new QuestionAnswer(List.of("ok"))))))));
      assertFalse(replyBody.get().isBlank());

      assertTrue(Boolean.TRUE.equals(client.question().reject(new QuestionRejectRequest("que_456", null))));
    }
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

  private static final class TestServer implements AutoCloseable {
    private final HttpServer server;

    private TestServer(HttpServer server) {
      this.server = server;
    }

    private String baseUrl() {
      return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    @Override
    public void close() {
      server.stop(0);
    }
  }
}
