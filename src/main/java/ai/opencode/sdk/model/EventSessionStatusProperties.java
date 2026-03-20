package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话状态事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventSessionStatusProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("status")
  private final SessionStatus status;

  /** 使用字段创建事件会话状态属性。 */
  @JsonCreator
  public EventSessionStatusProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("status") SessionStatus status
  ) {
    this.sessionID = sessionID;
    this.status = status;
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
   * 获取状态。
   *
   * @return 当前状态。
   */
  public SessionStatus status() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventSessionStatusProperties)) return false;
    EventSessionStatusProperties that = (EventSessionStatusProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, status);
  }

  @Override
  public String toString() {
    return "EventSessionStatusProperties{" +
        "sessionID=" + sessionID + "," +
        "status=" + status +
        "}";
  }
}
