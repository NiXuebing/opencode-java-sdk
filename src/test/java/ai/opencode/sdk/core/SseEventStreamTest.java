package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.testutil.TestHttpSupport;
import ai.opencode.sdk.testutil.TestHttpSupport.StubHttpClient;
import ai.opencode.sdk.testutil.TestHttpSupport.StubHttpResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

class SseEventStreamTest {
  private final ObjectMapper mapper = new ObjectMapper();
  private final HttpRequest request =
      HttpRequest.newBuilder(URI.create("http://localhost/event")).build();

  @Test
  void iteratorParsesEventsAndFlushesFinalEventAtEndOfStream() throws Exception {
    var body =
        "event: message\n"
            + "id: 1\n"
            + "retry: 500\n"
            + "data: {\"value\":\"first\"}\n"
            + "\n"
            + "data: {\"value\":\"second\"}\n";

    try (var stream = stream(new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)))) {
      var iterator = stream.iterator();

      assertTrue(iterator.hasNext());
      var first = iterator.next();
      assertEquals("message", first.event());
      assertEquals("1", first.id());
      assertEquals(500, first.retry());
      assertEquals("first", first.data().value());

      assertTrue(iterator.hasNext());
      assertEquals("second", iterator.next().data().value());
      assertFalse(iterator.hasNext());
      assertThrows(NoSuchElementException.class, iterator::next);
    }
  }

  @Test
  void iteratorReturnsNullDataWhenEventContainsOnlyMetadata() throws Exception {
    var body =
        "event: ping\n\n";

    try (var stream = stream(new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)))) {
      var event = stream.iterator().next();
      assertNull(event.data());
      assertEquals("ping", event.event());
    }
  }

  @Test
  void constructorRejectsNonSuccessResponses() {
    var error =
        assertThrows(
            ApiException.class,
            () ->
                new SseEventStream<>(
                    new StubHttpClient(
                        (sentRequest, handler) ->
                            new StubHttpResponse<>(
                                500,
                                new ByteArrayInputStream("failed".getBytes(StandardCharsets.UTF_8)),
                                TestHttpSupport.headers(Map.of("x-test", List.of("1"))),
                                sentRequest)),
                    mapper,
                    request,
                    mapper.constructType(Payload.class)));

    assertEquals(500, error.statusCode());
    assertEquals("failed", error.responseBody());
  }

  @Test
  void constructorWrapsIoException() {
    var cause = new IOException("boom");
    var error =
        assertThrows(
            ApiException.class,
            () ->
                new SseEventStream<>(
                    new StubHttpClient(
                        (sentRequest, handler) -> {
                          throw cause;
                        }),
                    mapper,
                    request,
                    mapper.constructType(Payload.class)));

    assertEquals("Failed to open SSE stream", error.getMessage());
    assertSame(cause, error.getCause());
  }

  @Test
  void constructorWrapsInterruptedExceptionAndRestoresInterruptFlag() {
    var cause = new InterruptedException("stop");
    var error =
        assertThrows(
            ApiException.class,
            () ->
                new SseEventStream<>(
                    new StubHttpClient(
                        (sentRequest, handler) -> {
                          throw cause;
                        }),
                    mapper,
                    request,
                    mapper.constructType(Payload.class)));

    assertEquals("Failed to open SSE stream", error.getMessage());
    assertSame(cause, error.getCause());
    assertTrue(Thread.currentThread().isInterrupted());
    assertTrue(Thread.interrupted());
  }

  @Test
  void iteratorWrapsReadFailures() throws Exception {
    try (var stream = stream(new FailingInputStream())) {
      var iterator = stream.iterator();
      var error = assertThrows(ApiException.class, iterator::hasNext);
      assertEquals("Failed to read SSE stream", error.getMessage());
      assertTrue(error.getCause() instanceof IOException);
    }
  }

  @Test
  void closeClosesUnderlyingResponseBody() throws Exception {
    var closed = new AtomicBoolean(false);
    try (var stream = stream(new CloseTrackingInputStream(closed))) {
      stream.close();
    }
    assertTrue(closed.get());
  }

  private SseEventStream<Payload> stream(InputStream body) {
    return new SseEventStream<>(
        new StubHttpClient(
            (sentRequest, handler) ->
                new StubHttpResponse<>(
                    200,
                    body,
                    TestHttpSupport.headers(Map.of("content-type", List.of("text/event-stream"))),
                    sentRequest)),
        mapper,
        request,
        mapper.constructType(Payload.class));
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

  private static final class FailingInputStream extends InputStream {
    @Override
    public int read() throws IOException {
      throw new IOException("read failed");
    }
  }

  private static final class CloseTrackingInputStream extends InputStream {
    private final AtomicBoolean closed;

    private CloseTrackingInputStream(AtomicBoolean closed) {
      this.closed = closed;
    }

    @Override
    public int read() {
      return -1;
    }

    @Override
    public void close() throws IOException {
      closed.set(true);
      super.close();
    }
  }
}
