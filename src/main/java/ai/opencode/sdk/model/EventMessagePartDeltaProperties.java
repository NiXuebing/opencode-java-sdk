package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息片段增量事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 * @param field 字段。
 * @param delta 增量。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMessagePartDeltaProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("partID")
  private final String partID;
  @JsonProperty("field")
  private final String field;
  @JsonProperty("delta")
  private final String delta;

  /** 使用字段创建事件消息片段增量属性。 */
  @JsonCreator
  public EventMessagePartDeltaProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("partID") String partID,
      @JsonProperty("field") String field,
      @JsonProperty("delta") String delta
  ) {
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.partID = partID;
    this.field = field;
    this.delta = delta;
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
   * 获取片段ID。
   *
   * @return 片段 ID。
   */
  public String partID() {
    return partID;
  }

  /**
   * 获取字段。
   *
   * @return 字段。
   */
  public String field() {
    return field;
  }

  /**
   * 获取增量。
   *
   * @return 增量。
   */
  public String delta() {
    return delta;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMessagePartDeltaProperties)) return false;
    EventMessagePartDeltaProperties that = (EventMessagePartDeltaProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(partID, that.partID)
        && Objects.equals(field, that.field)
        && Objects.equals(delta, that.delta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, messageID, partID, field, delta);
  }

  @Override
  public String toString() {
    return "EventMessagePartDeltaProperties{" +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "partID=" + partID + "," +
        "field=" + field + "," +
        "delta=" + delta +
        "}";
  }
}
