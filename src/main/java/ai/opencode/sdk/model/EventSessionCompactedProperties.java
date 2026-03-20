package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话已压缩事件属性。
 *
 * @param sessionID 目标会话 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventSessionCompactedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;

  /** 使用字段创建事件会话已压缩属性。 */
  @JsonCreator
  public EventSessionCompactedProperties(
      @JsonProperty("sessionID") String sessionID
  ) {
    this.sessionID = sessionID;
  }

  /**
   * 获取会话ID。
   *
   * @return 目标会话 ID。
   */
  public String sessionID() {
    return sessionID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventSessionCompactedProperties)) return false;
    EventSessionCompactedProperties that = (EventSessionCompactedProperties) other;
    return Objects.equals(sessionID, that.sessionID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID);
  }

  @Override
  public String toString() {
    return "EventSessionCompactedProperties{" +
        "sessionID=" + sessionID +
        "}";
  }
}
