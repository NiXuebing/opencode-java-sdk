package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话错误事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param error 错误信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventSessionErrorProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("error")
  private final EventSessionErrorPropertiesError error;

  /** 使用字段创建事件会话错误属性。 */
  @JsonCreator
  public EventSessionErrorProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("error") EventSessionErrorPropertiesError error
  ) {
    this.sessionID = sessionID;
    this.error = error;
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
   * 获取错误。
   *
   * @return 错误信息。
   */
  public EventSessionErrorPropertiesError error() {
    return error;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventSessionErrorProperties)) return false;
    EventSessionErrorProperties that = (EventSessionErrorProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(error, that.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, error);
  }

  @Override
  public String toString() {
    return "EventSessionErrorProperties{" +
        "sessionID=" + sessionID + "," +
        "error=" + error +
        "}";
  }
}
