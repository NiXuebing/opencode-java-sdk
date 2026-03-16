package ai.opencode.sdk.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ApiException extends RuntimeException {
  private final Integer statusCode;
  private final String responseBody;
  private final Map<String, List<String>> responseHeaders;

  public ApiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = null;
    this.responseBody = null;
    this.responseHeaders = Map.of();
  }

  public ApiException(Integer statusCode, String responseBody, HttpHeaders headers) {
    super("API request failed with status " + statusCode);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
    this.responseHeaders = headers.map();
  }

  public Integer statusCode() {
    return statusCode;
  }

  public String responseBody() {
    return responseBody;
  }

  public Map<String, List<String>> responseHeaders() {
    return responseHeaders;
  }

  public JsonNode responseJson() {
    if (responseBody == null || responseBody.isBlank()) return null;
    try {
      return new ObjectMapper().readTree(responseBody);
    } catch (IOException error) {
      return null;
    }
  }

  public static ApiException from(HttpResponse<String> response) {
    return new ApiException(response.statusCode(), response.body(), response.headers());
  }
}
