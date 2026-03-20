package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话状态重试数据模型。
 *
 * @param type 类型标识。
 * @param attempt 尝试次数。
 * @param message 消息内容。
 * @param next 下一项。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionStatusRetry implements SessionStatus {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("attempt")
  private final Double attempt;
  @JsonProperty("message")
  private final String message;
  @JsonProperty("next")
  private final Double next;

  /** 使用字段创建会话状态重试。 */
  @JsonCreator
  public SessionStatusRetry(
      @JsonProperty("type") String type,
      @JsonProperty("attempt") Double attempt,
      @JsonProperty("message") String message,
      @JsonProperty("next") Double next
  ) {
    this.type = type;
    this.attempt = attempt;
    this.message = message;
    this.next = next;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取attempt。
   *
   * @return 尝试次数。
   */
  public Double attempt() {
    return attempt;
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
   * 获取下一项。
   *
   * @return 下一项。
   */
  public Double next() {
    return next;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionStatusRetry)) return false;
    SessionStatusRetry that = (SessionStatusRetry) other;
    return Objects.equals(type, that.type)
        && Objects.equals(attempt, that.attempt)
        && Objects.equals(message, that.message)
        && Objects.equals(next, that.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, attempt, message, next);
  }

  @Override
  public String toString() {
    return "SessionStatusRetry{" +
        "type=" + type + "," +
        "attempt=" + attempt + "," +
        "message=" + message + "," +
        "next=" + next +
        "}";
  }
}
