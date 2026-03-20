package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 上下文溢出错误详情。
 *
 * @param message 消息内容。
 * @param responseBody 服务端返回的原始响应体。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ContextOverflowErrorData {
  @JsonProperty("message")
  private final String message;
  @JsonProperty("responseBody")
  private final String responseBody;

  /** 使用字段创建上下文溢出错误数据。 */
  @JsonCreator
  public ContextOverflowErrorData(
      @JsonProperty("message") String message,
      @JsonProperty("responseBody") String responseBody
  ) {
    this.message = message;
    this.responseBody = responseBody;
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
   * 获取响应请求体。
   *
   * @return 服务端返回的原始响应体。
   */
  public String responseBody() {
    return responseBody;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ContextOverflowErrorData)) return false;
    ContextOverflowErrorData that = (ContextOverflowErrorData) other;
    return Objects.equals(message, that.message)
        && Objects.equals(responseBody, that.responseBody);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, responseBody);
  }

  @Override
  public String toString() {
    return "ContextOverflowErrorData{" +
        "message=" + message + "," +
        "responseBody=" + responseBody +
        "}";
  }
}
