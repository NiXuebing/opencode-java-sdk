package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 命令已执行事件属性。
 *
 * @param name 名称。
 * @param sessionID 目标会话 ID。
 * @param arguments 参数内容。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventCommandExecutedProperties {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("arguments")
  private final String arguments;
  @JsonProperty("messageID")
  private final String messageID;

  /** 使用字段创建事件命令已执行属性。 */
  @JsonCreator
  public EventCommandExecutedProperties(
      @JsonProperty("name") String name,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("arguments") String arguments,
      @JsonProperty("messageID") String messageID
  ) {
    this.name = name;
    this.sessionID = sessionID;
    this.arguments = arguments;
    this.messageID = messageID;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
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
   * 获取arguments。
   *
   * @return 参数内容。
   */
  public String arguments() {
    return arguments;
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
    if (!(other instanceof EventCommandExecutedProperties)) return false;
    EventCommandExecutedProperties that = (EventCommandExecutedProperties) other;
    return Objects.equals(name, that.name)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(arguments, that.arguments)
        && Objects.equals(messageID, that.messageID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sessionID, arguments, messageID);
  }

  @Override
  public String toString() {
    return "EventCommandExecutedProperties{" +
        "name=" + name + "," +
        "sessionID=" + sessionID + "," +
        "arguments=" + arguments + "," +
        "messageID=" + messageID +
        "}";
  }
}
