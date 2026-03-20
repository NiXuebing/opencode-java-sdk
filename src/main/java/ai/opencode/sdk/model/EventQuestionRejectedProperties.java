package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 问题已拒绝事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param requestID 请求 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventQuestionRejectedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("requestID")
  private final String requestID;

  /** 使用字段创建事件问题已拒绝属性。 */
  @JsonCreator
  public EventQuestionRejectedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("requestID") String requestID
  ) {
    this.sessionID = sessionID;
    this.requestID = requestID;
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
   * 获取请求ID。
   *
   * @return 请求 ID。
   */
  public String requestID() {
    return requestID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventQuestionRejectedProperties)) return false;
    EventQuestionRejectedProperties that = (EventQuestionRejectedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(requestID, that.requestID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, requestID);
  }

  @Override
  public String toString() {
    return "EventQuestionRejectedProperties{" +
        "sessionID=" + sessionID + "," +
        "requestID=" + requestID +
        "}";
  }
}
