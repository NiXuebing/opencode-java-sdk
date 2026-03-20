package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 消息已移除事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMessageRemovedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;

  /** 使用字段创建事件消息已移除属性。 */
  @JsonCreator
  public EventMessageRemovedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID
  ) {
    this.sessionID = sessionID;
    this.messageID = messageID;
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMessageRemovedProperties)) return false;
    EventMessageRemovedProperties that = (EventMessageRemovedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, messageID);
  }

  @Override
  public String toString() {
    return "EventMessageRemovedProperties{" +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID +
        "}";
  }
}
