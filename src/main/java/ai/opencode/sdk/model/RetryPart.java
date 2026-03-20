package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 重试片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param attempt 尝试次数。
 * @param error 错误信息。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class RetryPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("attempt")
  private final Double attempt;
  @JsonProperty("error")
  private final APIError error;
  @JsonProperty("time")
  private final RetryPartTime time;

  /** 使用字段创建重试片段。 */
  @JsonCreator
  public RetryPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("attempt") Double attempt,
      @JsonProperty("error") APIError error,
      @JsonProperty("time") RetryPartTime time
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.attempt = attempt;
    this.error = error;
    this.time = time;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取会话ID。
   *
   * @return 目标会话 ID。
   */
  public String sessionID() {
    return sessionID;
  }

  /**
   * 获取消息ID。
   *
   * @return 目标消息 ID。
   */
  public String messageID() {
    return messageID;
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
   * 获取错误。
   *
   * @return 错误信息。
   */
  public APIError error() {
    return error;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public RetryPartTime time() {
    return time;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof RetryPart)) return false;
    RetryPart that = (RetryPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(attempt, that.attempt)
        && Objects.equals(error, that.error)
        && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, attempt, error, time);
  }

  @Override
  public String toString() {
    return "RetryPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "attempt=" + attempt + "," +
        "error=" + error + "," +
        "time=" + time +
        "}";
  }
}
