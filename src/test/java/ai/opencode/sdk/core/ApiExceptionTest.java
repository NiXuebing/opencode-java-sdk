package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.testutil.TestHttpSupport;
import ai.opencode.sdk.testutil.TestHttpSupport.StubHttpResponse;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiExceptionTest {
  @Test
  void causeConstructorKeepsCauseAndEmptyResponseMetadata() {
    var cause = new IllegalStateException("boom");
    var error = new ApiException("Request failed", cause);

    assertEquals("Request failed", error.getMessage());
    assertSame(cause, error.getCause());
    assertNull(error.statusCode());
    assertNull(error.responseBody());
    assertTrue(error.responseHeaders().isEmpty());
    assertNull(error.responseJson());
  }

  @Test
  void responseJsonParsesValidJsonAndRejectsInvalidJson() {
    var parsed =
        new ApiException(
            400,
            "{\"error\":\"bad\"}",
            TestHttpSupport.headers(Map.of("content-type", List.of("application/json"))));

    assertNotNull(parsed.responseJson());
    assertEquals("bad", parsed.responseJson().get("error").asText());

    var invalid =
        new ApiException(
            500,
            "not-json",
            TestHttpSupport.headers(Map.of("content-type", List.of("text/plain"))));
    assertNull(invalid.responseJson());

    var blank =
        new ApiException(
            500, "   ", TestHttpSupport.headers(Map.of("content-type", List.of("text/plain"))));
    assertNull(blank.responseJson());
  }

  @Test
  void fromCopiesResponseMetadata() {
    var request = HttpRequest.newBuilder(URI.create("http://localhost/test")).build();
    var response =
        new StubHttpResponse<>(
            403, "denied", TestHttpSupport.headers(Map.of("x-test", List.of("value"))), request);

    var error = ApiException.from(response);

    assertEquals(403, error.statusCode());
    assertEquals("denied", error.responseBody());
    assertEquals(List.of("value"), error.responseHeaders().get("x-test"));
  }
}
