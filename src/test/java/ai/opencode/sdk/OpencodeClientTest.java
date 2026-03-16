package ai.opencode.sdk;

import ai.opencode.sdk.core.OpencodeClientConfig;
import ai.opencode.sdk.model.EventInstallationUpdated;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpencodeClientTest {
  @Test
  void healthCallUsesConfiguredDirectoryHeader() throws Exception {
    var header = new AtomicReference<String>();

    try (var server = server((exchange) -> {
      header.set(exchange.getRequestHeaders().getFirst("x-opencode-directory"));
      assertEquals("/global/health", exchange.getRequestURI().getPath());
      json(exchange, """
          {"healthy":true,"version":"1.2.3"}
          """);
    })) {
      var client = new OpencodeClient(
          OpencodeClientConfig.builder()
              .baseUrl(server.baseUrl())
              .directory("/tmp/项目")
              .build()
      );

      var health = client.global().health();

      assertTrue(health.healthy());
      assertEquals("1.2.3", health.version());
      assertEquals("%2Ftmp%2F%E9%A1%B9%E7%9B%AE", header.get());
    }
  }

  @Test
  void eventStreamParsesUnionEventPayload() throws Exception {
    try (var server = server((exchange) -> {
      assertEquals("/event", exchange.getRequestURI().getPath());
      exchange.getResponseHeaders().add("Content-Type", "text/event-stream");
      exchange.sendResponseHeaders(200, 0);
      try (var out = exchange.getResponseBody()) {
        out.write("""
            event: message
            id: 1
            data: {"type":"installation.updated","properties":{"version":"1.2.3"}}

            """.getBytes(StandardCharsets.UTF_8));
        out.flush();
      }
    })) {
      var client = new OpencodeClient(
          OpencodeClientConfig.builder()
              .baseUrl(server.baseUrl())
              .build()
      );

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

  private TestServer server(HttpHandler handler) throws IOException {
    var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.createContext("/global/health", handler);
    server.createContext("/event", handler);
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
}
