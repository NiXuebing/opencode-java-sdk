package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 工作区失败事件属性。
 *
 * @param message 消息内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventWorkspaceFailedProperties {
  @JsonProperty("message")
  private final String message;

  /** 使用字段创建事件工作区失败属性。 */
  @JsonCreator
  public EventWorkspaceFailedProperties(
      @JsonProperty("message") String message
  ) {
    this.message = message;
  }

  /**
   * 获取消息。
   *
   * @return 消息内容。
   */
  public String message() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventWorkspaceFailedProperties)) return false;
    EventWorkspaceFailedProperties that = (EventWorkspaceFailedProperties) other;
    return Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "EventWorkspaceFailedProperties{" +
        "message=" + message +
        "}";
  }
}
