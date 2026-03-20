package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
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
import org.springframework.web.reactive.function.client.WebClient;

class ReactiveApiTransportTest {
  @Test
  void executeBuildsRequestAndParsesClassAndTypeResponses() throws Exception {
    var pathRef = new AtomicReference<String>();
    var queryRef = new AtomicReference<String>();
    var directoryRef = new AtomicReference<String>();
    var configHeaderRef = new AtomicReference<String>();
    var callHeaderRef = new AtomicReference<String>();
    var bodyRef = new AtomicReference<String>();

    try (var server =
        server(
            Map.of(
                "/items/a b",
                (HttpHandler)
                    exchange -> {
                      pathRef.set(exchange.getRequestURI().getPath());
                      queryRef.set(exchange.getRequestURI().getRawQuery());
                      directoryRef.set(exchange.getRequestHeaders().getFirst("x-opencode-directory"));
                      configHeaderRef.set(exchange.getRequestHeaders().getFirst("x-config"));
                      callHeaderRef.set(exchange.getRequestHeaders().getFirst("x-call"));
                      bodyRef.set(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
                      json(exchange, "{\"value\":\"ok\"}");
                    },
                "/typed",
                (HttpHandler) exchange -> json(exchange, "[{\"value\":\"typed\"}]"),
                "/empty-query",
                (HttpHandler) exchange -> json(exchange, "{\"value\":\"empty\"}")))) {
      var transport =
          new ReactiveApiTransport(
              ReactiveOpencodeClientConfig.builder()
                  .baseUrl(server.baseUrl())
                  .webClient(WebClient.builder().build())
                  .header("x-config", "config")
                  .directory("/tmp/项目")
                  .timeout(Duration.ofSeconds(5))
                  .build());

      var item =
          transport
              .execute(
                  "POST",
                  "/items/{id}",
                  Map.of("id", "a b"),
                  Map.of(
                      "single", "hello world",
                      "list", List.of("one", "two"),
                      "array", new String[] {"x", "y"}),
                  Map.of("x-call", "call"),
                  Map.of("value", "sample"),
                  Payload.class)
              .block(Duration.ofSeconds(5));
      assertEquals("ok", item.value());
      assertEquals("/items/a b", pathRef.get());
      assertTrue(queryRef.get().contains("single=hello%20world"));
      assertTrue(queryRef.get().contains("list=one"));
      assertTrue(queryRef.get().contains("list=two"));
      assertTrue(queryRef.get().contains("array=x"));
      assertTrue(queryRef.get().contains("array=y"));
      assertEquals("%2Ftmp%2F%E9%A1%B9%E7%9B%AE", directoryRef.get());
      assertEquals("config", configHeaderRef.get());
      assertEquals("call", callHeaderRef.get());
      assertEquals("{\"value\":\"sample\"}", bodyRef.get());

      var typed =
          transport
              .execute(
                  "GET",
                  "/typed",
                  Map.of(),
                  Map.of(),
                  Map.of(),
                  null,
                  new TypeReference<List<Payload>>() {})
              .block(Duration.ofSeconds(5));
      assertEquals(1, typed.size());
      assertEquals("typed", typed.get(0).value());

      var emptyQuery = new java.util.LinkedHashMap<String, Object>();
      emptyQuery.put("skip", null);
      var empty =
          transport
              .execute(
                  "GET", "/empty-query", Map.of(), emptyQuery, Map.of(), null, Payload.class)
              .block(Duration.ofSeconds(5));
      assertEquals("empty", empty.value());
    }
  }

  @Test
  void executeSupportsVoidBlankBodyAndErrorBranches() throws Exception {
    try (var server =
        server(
            Map.of(
                "/void", (HttpHandler) exchange -> json(exchange, ""),
                "/blank", (HttpHandler) exchange -> json(exchange, "   "),
                "/error", (HttpHandler) exchange -> send(exchange, 422, "{\"message\":\"bad\"}"),
                "/malformed", (HttpHandler) exchange -> json(exchange, "{")))) {
      var transport =
          new ReactiveApiTransport(
              ReactiveOpencodeClientConfig.builder().baseUrl(server.baseUrl()).build());

      assertNull(
          transport
              .execute("POST", "/void", Map.of(), Map.of(), Map.of(), Map.of("value", "x"), Void.class)
              .block(Duration.ofSeconds(5)));
      assertNull(
          transport
              .execute("GET", "/blank", Map.of(), Map.of(), Map.of(), null, Payload.class)
              .block(Duration.ofSeconds(5)));

      var error =
          assertThrows(
              ApiException.class,
              () ->
                  transport
                      .execute("GET", "/error", Map.of(), Map.of(), Map.of(), null, Payload.class)
                      .block(Duration.ofSeconds(5)));
      assertEquals(422, error.statusCode());
      assertEquals("{\"message\":\"bad\"}", error.responseBody());

      var parseError =
          assertThrows(
              ApiException.class,
              () ->
                  transport
                      .execute(
                          "GET", "/malformed", Map.of(), Map.of(), Map.of(), null, Payload.class)
                      .block(Duration.ofSeconds(5)));
      assertEquals("Failed to parse response body", parseError.getMessage());
    }
  }

  @Test
  void streamParsesClassAndTypeEventsAndHandlesFailures() throws Exception {
    try (var server =
        server(
            Map.of(
                "/event",
                (HttpHandler)
                    exchange ->
                        sse(
                            exchange,
                            "event: message\n"
                                + "id: evt_1\n"
                                + "retry: 500\n"
                                + "data: {\"value\":\"ok\"}\n\n"
                                + "event: ping\n"
                                + "id: evt_2\n\n"),
                "/typed",
                (HttpHandler)
                    exchange -> sse(exchange, "data: [{\"value\":\"typed\"}]\n\n"),
                "/stream-error",
                (HttpHandler) exchange -> send(exchange, 500, "failed"),
                "/stream-malformed",
                (HttpHandler) exchange -> sse(exchange, "data: {\n\n")))) {
      var transport =
          new ReactiveApiTransport(
              ReactiveOpencodeClientConfig.builder().baseUrl(server.baseUrl()).build());

      var classEvents =
          transport
              .stream("GET", "/event", Map.of(), Map.of(), Map.of(), null, Payload.class)
              .collectList()
              .block(Duration.ofSeconds(5));
      assertEquals(2, classEvents.size());
      assertEquals("ok", classEvents.get(0).data().value());
      assertEquals(Integer.valueOf(500), classEvents.get(0).retry());
      assertNull(classEvents.get(1).data());
      assertEquals("ping", classEvents.get(1).event());

      var typedEvents =
          transport
              .stream(
                  "GET",
                  "/typed",
                  Map.of(),
                  Map.of(),
                  Map.of(),
                  null,
                  new TypeReference<List<Payload>>() {})
              .collectList()
              .block(Duration.ofSeconds(5));
      assertEquals(1, typedEvents.size());
      assertEquals("typed", typedEvents.get(0).data().get(0).value());

      var error =
          assertThrows(
              ApiException.class,
              () ->
                  transport
                      .stream(
                          "GET", "/stream-error", Map.of(), Map.of(), Map.of(), null, Payload.class)
                      .collectList()
                      .block(Duration.ofSeconds(5)));
      assertEquals(500, error.statusCode());
      assertEquals("failed", error.responseBody());

      var parseError =
          assertThrows(
              ApiException.class,
              () ->
                  transport
                      .stream(
                          "GET",
                          "/stream-malformed",
                          Map.of(),
                          Map.of(),
                          Map.of(),
                          null,
                          Payload.class)
                      .collectList()
                      .block(Duration.ofSeconds(5)));
      assertEquals("Failed to parse SSE payload", parseError.getMessage());
    }
  }

  private TestServer server(Map<String, HttpHandler> handlers) throws IOException {
    var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    for (Map.Entry<String, HttpHandler> entry : handlers.entrySet()) {
      server.createContext(entry.getKey(), entry.getValue());
    }
    server.start();
    return new TestServer(server);
  }

  private void json(HttpExchange exchange, String body) throws IOException {
    send(exchange, 200, body, "application/json");
  }

  private void sse(HttpExchange exchange, String body) throws IOException {
    send(exchange, 200, body, "text/event-stream");
  }

  private void send(HttpExchange exchange, int status, String body) throws IOException {
    send(exchange, status, body, "application/json");
  }

  private void send(HttpExchange exchange, int status, String body, String contentType)
      throws IOException {
    byte[] data = body.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().add("Content-Type", contentType);
    exchange.sendResponseHeaders(status, data.length);
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

  private static final class Payload {
    private final String value;

    @JsonCreator
    private Payload(@JsonProperty("value") String value) {
      this.value = value;
    }

    private String value() {
      return value;
    }
  }
}
