package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.testutil.TestHttpSupport;
import ai.opencode.sdk.testutil.TestHttpSupport.StubHttpClient;
import ai.opencode.sdk.testutil.TestHttpSupport.StubHttpResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class ApiTransportTest {
  @Test
  void executeBuildsJsonRequestAndParsesClassResponse() {
    var requestRef = new AtomicReference<HttpRequest>();
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096/api/")
                .header("x-config", "config")
                .directory("/tmp/项目")
                .timeout(Duration.ofSeconds(3))
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          requestRef.set(request);
                          return new StubHttpResponse<>(
                              200,
                              "{\"value\":\"ok\"}",
                              TestHttpSupport.headers(
                                  Map.of("content-type", List.of("application/json"))),
                              request);
                        }))
                .build());

    var result =
        transport.execute(
            "POST",
            "/test/{id}",
            Map.of("id", "a b"),
            orderedQuery(),
            Map.of("x-call", "call"),
            Map.of("name", "sample"),
            Payload.class);

    assertEquals("ok", result.value());

    var request = requestRef.get();
    assertEquals("POST", request.method());
    assertEquals(
        URI.create(
            "http://localhost:4096/api/test/a%20b?single=hello%20world&list=one&list=two&array=x&array=y"),
        request.uri());
    assertEquals("application/json", request.headers().firstValue("Accept").orElseThrow());
    assertEquals("application/json", request.headers().firstValue("Content-Type").orElseThrow());
    assertEquals("config", request.headers().firstValue("x-config").orElseThrow());
    assertEquals("call", request.headers().firstValue("x-call").orElseThrow());
    assertEquals(
        "%2Ftmp%2F%E9%A1%B9%E7%9B%AE",
        request.headers().firstValue("x-opencode-directory").orElseThrow());
    assertEquals("{\"name\":\"sample\"}", TestHttpSupport.readBody(request));
    assertEquals(Duration.ofSeconds(3), request.timeout().orElseThrow());
  }

  @Test
  void executeHandlesBlankBodiesVoidResponsesAndTypeReferences() {
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096")
                .directory("/tmp/ascii")
                .httpClient(
                    new StubHttpClient(
                        (request, handler) ->
                            new StubHttpResponse<>(
                                200,
                                "   ",
                                TestHttpSupport.headers(
                                    Map.of("content-type", List.of("application/json"))),
                                request)))
                .build());

    assertNull(
        transport.execute(
            "GET",
            "/items",
            Map.of(),
            Map.of(),
            Map.of(),
            null,
            new TypeReference<List<Payload>>() {}));
    assertNull(
        transport.execute("POST", "/void", Map.of(), Map.of(), Map.of(), Map.of(), Void.class));
  }

  @Test
  void executeTypeReferenceParsesSuccessResponse() {
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096")
                .httpClient(
                    new StubHttpClient(
                        (request, handler) ->
                            new StubHttpResponse<>(
                                200,
                                "[{\"value\":\"ok\"}]",
                                TestHttpSupport.headers(
                                    Map.of("content-type", List.of("application/json"))),
                                request)))
                .build());

    var result =
        transport.execute(
            "GET",
            "/items",
            Map.of(),
            Map.of(),
            Map.of(),
            null,
            new TypeReference<List<Payload>>() {});

    assertEquals(1, result.size());
    assertEquals("ok", result.get(0).value());
  }

  @Test
  void executeWrapsHttpFailuresIntoApiException() {
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096")
                .httpClient(
                    new StubHttpClient(
                        (request, handler) ->
                            new StubHttpResponse<>(
                                422,
                                "{\"message\":\"bad\"}",
                                TestHttpSupport.headers(Map.of("x-error", List.of("1"))),
                                request)))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET", "/broken", Map.of(), Map.of(), Map.of(), null, Payload.class));

    assertEquals(422, error.statusCode());
    assertEquals("{\"message\":\"bad\"}", error.responseBody());
    assertEquals("bad", error.responseJson().get("message").asText());
  }

  @Test
  void executeTypeReferenceWrapsHttpFailuresIntoApiException() {
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096")
                .httpClient(
                    new StubHttpClient(
                        (request, handler) ->
                            new StubHttpResponse<>(
                                422,
                                "{\"message\":\"bad\"}",
                                TestHttpSupport.headers(Map.of("x-error", List.of("1"))),
                                request)))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET",
                    "/broken",
                    Map.of(),
                    Map.of(),
                    Map.of(),
                    null,
                    new TypeReference<List<Payload>>() {}));

    assertEquals(422, error.statusCode());
    assertEquals("{\"message\":\"bad\"}", error.responseBody());
  }

  @Test
  void executeWrapsInterruptedExceptionAndRestoresInterruptFlag() {
    var cause = new InterruptedException("stop");
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          throw cause;
                        }))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET", "/broken", Map.of(), Map.of(), Map.of(), null, Payload.class));

    assertEquals("Request interrupted", error.getMessage());
    assertSame(cause, error.getCause());
    assertTrue(Thread.currentThread().isInterrupted());
    assertTrue(Thread.interrupted());
  }

  @Test
  void executeTypeReferenceWrapsInterruptedExceptionAndRestoresInterruptFlag() {
    var cause = new InterruptedException("stop");
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          throw cause;
                        }))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET",
                    "/broken",
                    Map.of(),
                    Map.of(),
                    Map.of(),
                    null,
                    new TypeReference<List<Payload>>() {}));

    assertEquals("Request interrupted", error.getMessage());
    assertSame(cause, error.getCause());
    assertTrue(Thread.currentThread().isInterrupted());
    assertTrue(Thread.interrupted());
  }

  @Test
  void executeWrapsIoException() {
    var cause = new IOException("boom");
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          throw cause;
                        }))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET", "/broken", Map.of(), Map.of(), Map.of(), null, Payload.class));

    assertEquals("Request failed", error.getMessage());
    assertSame(cause, error.getCause());
  }

  @Test
  void executeTypeReferenceWrapsIoException() {
    var cause = new IOException("boom");
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          throw cause;
                        }))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "GET",
                    "/broken",
                    Map.of(),
                    Map.of(),
                    Map.of(),
                    null,
                    new TypeReference<List<Payload>>() {}));

    assertEquals("Request failed", error.getMessage());
    assertSame(cause, error.getCause());
  }

  @Test
  void executeFailsFastWhenBodyCannotBeSerialized() {
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          throw new AssertionError("send should not be called");
                        }))
                .build());

    var error =
        assertThrows(
            ApiException.class,
            () ->
                transport.execute(
                    "POST",
                    "/serialize",
                    Map.of(),
                    Map.of(),
                    Map.of(),
                    new SelfReference(),
                    Payload.class));

    assertEquals("Failed to serialize request body", error.getMessage());
    assertInstanceOf(com.fasterxml.jackson.databind.JsonMappingException.class, error.getCause());
  }

  @Test
  void streamOverloadsUseEventStreamAcceptHeader() throws Exception {
    var requestRef = new AtomicReference<HttpRequest>();
    var callCount = new java.util.concurrent.atomic.AtomicInteger();
    var transport =
        new ApiTransport(
            OpencodeClientConfig.builder()
                .httpClient(
                    new StubHttpClient(
                        (request, handler) -> {
                          requestRef.set(request);
                          var body =
                              callCount.incrementAndGet() == 1
                                  ? "data: {\"value\":\"ok\"}\n\n"
                                  : "data: [{\"value\":\"ok\"}]\n\n";
                          return new StubHttpResponse<>(
                              200,
                              new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)),
                              TestHttpSupport.headers(
                                  Map.of("content-type", List.of("text/event-stream"))),
                              request);
                        }))
                .build());

    try (var classStream =
            transport.stream("GET", "/event", Map.of(), Map.of(), Map.of(), null, Payload.class);
        var typeStream =
            transport.stream(
                "GET",
                "/event",
                Map.of(),
                Map.of(),
                Map.of(),
                null,
                new TypeReference<List<Payload>>() {})) {
      var classEvent = classStream.iterator().next();
      assertEquals("ok", classEvent.data().value());

      var typeEvent = typeStream.iterator().next();
      assertEquals("ok", typeEvent.data().get(0).value());
    }

    assertEquals(
        "text/event-stream", requestRef.get().headers().firstValue("Accept").orElseThrow());
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

  private Map<String, Object> orderedQuery() {
    var query = new LinkedHashMap<String, Object>();
    query.put("single", "hello world");
    query.put("list", List.of("one", "two"));
    query.put("array", new String[] {"x", "y"});
    query.put("ignored", null);
    return query;
  }

  private static final class SelfReference {
    @SuppressWarnings("unused")
    public final SelfReference self = this;
  }
}
