package ai.opencode.sdk.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serial;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/** 表示 OpenCode HTTP 调用过程中抛出的运行时异常。 */
public class ApiException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;
  private static final ObjectMapper RESPONSE_MAPPER = new ObjectMapper();

  private final Integer statusCode;
  private final String responseBody;
  private final Map<String, List<String>> responseHeaders;

  /**
   * 使用普通异常信息和根因创建异常。
   *
   * @param message 异常消息。
   * @param cause 根因异常。
   */
  public ApiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = null;
    this.responseBody = null;
    this.responseHeaders = Map.of();
  }

  /**
   * 使用 HTTP 响应信息创建异常。
   *
   * @param statusCode HTTP 状态码。
   * @param responseBody 原始响应体。
   * @param headers 原始响应头。
   */
  public ApiException(Integer statusCode, String responseBody, HttpHeaders headers) {
    super("API request failed with status " + statusCode);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
    this.responseHeaders = headers.map();
  }

  /**
   * 获取 HTTP 状态码。
   *
   * @return HTTP 状态码；若异常并非由 HTTP 响应产生则返回 null。
   */
  public Integer statusCode() {
    return statusCode;
  }

  /**
   * 获取原始响应体。
   *
   * @return 原始响应体；若不存在则返回 null。
   */
  public String responseBody() {
    return responseBody;
  }

  /**
   * 获取原始响应头。
   *
   * @return 原始响应头映射。
   */
  public Map<String, List<String>> responseHeaders() {
    return responseHeaders;
  }

  /**
   * 将原始响应体解析为 JSON。
   *
   * @return 解析后的 JSON 节点；若响应体为空或不是合法 JSON 则返回 null。
   */
  public JsonNode responseJson() {
    if (responseBody == null || responseBody.isBlank()) return null;
    try {
      return RESPONSE_MAPPER.readTree(responseBody);
    } catch (IOException error) {
      return null;
    }
  }

  /**
   * 根据字符串响应对象创建异常。
   *
   * @param response HTTP 响应对象。
   * @return 包含状态码、响应体和响应头的异常对象。
   */
  public static ApiException from(HttpResponse<String> response) {
    return new ApiException(response.statusCode(), response.body(), response.headers());
  }
}
