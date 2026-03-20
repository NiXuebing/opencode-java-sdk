package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 结构化输出错误详情。
 *
 * @param message 消息内容。
 * @param retries 重试。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StructuredOutputErrorData {
  @JsonProperty("message")
  private final String message;
  @JsonProperty("retries")
  private final Double retries;

  /** 使用字段创建结构化输出错误数据。 */
  @JsonCreator
  public StructuredOutputErrorData(
      @JsonProperty("message") String message,
      @JsonProperty("retries") Double retries
  ) {
    this.message = message;
    this.retries = retries;
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
   * 获取重试。
   *
   * @return 重试。
   */
  public Double retries() {
    return retries;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StructuredOutputErrorData)) return false;
    StructuredOutputErrorData that = (StructuredOutputErrorData) other;
    return Objects.equals(message, that.message)
        && Objects.equals(retries, that.retries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, retries);
  }

  @Override
  public String toString() {
    return "StructuredOutputErrorData{" +
        "message=" + message + "," +
        "retries=" + retries +
        "}";
  }
}
