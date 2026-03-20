package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * API错误详情。
 *
 * @param message 消息内容。
 * @param statusCode 状态代码。
 * @param isRetryable 是否可重试。
 * @param responseHeaders 服务端返回的响应头。
 * @param responseBody 服务端返回的原始响应体。
 * @param metadata 元数据映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class APIErrorData {
  @JsonProperty("message")
  private final String message;
  @JsonProperty("statusCode")
  private final Double statusCode;
  @JsonProperty("isRetryable")
  private final Boolean isRetryable;
  @JsonProperty("responseHeaders")
  private final Map<String, String> responseHeaders;
  @JsonProperty("responseBody")
  private final String responseBody;
  @JsonProperty("metadata")
  private final Map<String, String> metadata;

  /** 使用字段创建API错误数据。 */
  @JsonCreator
  public APIErrorData(
      @JsonProperty("message") String message,
      @JsonProperty("statusCode") Double statusCode,
      @JsonProperty("isRetryable") Boolean isRetryable,
      @JsonProperty("responseHeaders") Map<String, String> responseHeaders,
      @JsonProperty("responseBody") String responseBody,
      @JsonProperty("metadata") Map<String, String> metadata
  ) {
    this.message = message;
    this.statusCode = statusCode;
    this.isRetryable = isRetryable;
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
    this.metadata = metadata;
  }

  /**
   * 获取消息。
   *
   * @return 消息内容。
   */
  public String message() {
    return message;
  }

  /**
   * 获取状态代码。
   *
   * @return 状态代码。
   */
  public Double statusCode() {
    return statusCode;
  }

  /**
   * 获取is可重试。
   *
   * @return 是否可重试。
   */
  public Boolean isRetryable() {
    return isRetryable;
  }

  /**
   * 获取响应Headers。
   *
   * @return 服务端返回的响应头。
   */
  public Map<String, String> responseHeaders() {
    return responseHeaders;
  }

  /**
   * 获取响应请求体。
   *
   * @return 服务端返回的原始响应体。
   */
  public String responseBody() {
    return responseBody;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, String> metadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof APIErrorData)) return false;
    APIErrorData that = (APIErrorData) other;
    return Objects.equals(message, that.message)
        && Objects.equals(statusCode, that.statusCode)
        && Objects.equals(isRetryable, that.isRetryable)
        && Objects.equals(responseHeaders, that.responseHeaders)
        && Objects.equals(responseBody, that.responseBody)
        && Objects.equals(metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, statusCode, isRetryable, responseHeaders, responseBody, metadata);
  }

  @Override
  public String toString() {
    return "APIErrorData{" +
        "message=" + message + "," +
        "statusCode=" + statusCode + "," +
        "isRetryable=" + isRetryable + "," +
        "responseHeaders=" + responseHeaders + "," +
        "responseBody=" + responseBody + "," +
        "metadata=" + metadata +
        "}";
  }
}
