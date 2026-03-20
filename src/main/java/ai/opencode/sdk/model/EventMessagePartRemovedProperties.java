package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息片段已移除事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMessagePartRemovedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("partID")
  private final String partID;

  /** 使用字段创建事件消息片段已移除属性。 */
  @JsonCreator
  public EventMessagePartRemovedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("partID") String partID
  ) {
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.partID = partID;
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMessagePartRemovedProperties)) return false;
    EventMessagePartRemovedProperties that = (EventMessagePartRemovedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(partID, that.partID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, messageID, partID);
  }

  @Override
  public String toString() {
    return "EventMessagePartRemovedProperties{" +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "partID=" + partID +
        "}";
  }
}
