package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 权限已响应事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param requestID 请求 ID。
 * @param reply 回复。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventPermissionRepliedProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("requestID")
  private final String requestID;
  @JsonProperty("reply")
  private final String reply;

  /** 使用字段创建事件权限已响应属性。 */
  @JsonCreator
  public EventPermissionRepliedProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("requestID") String requestID,
      @JsonProperty("reply") String reply
  ) {
    this.sessionID = sessionID;
    this.requestID = requestID;
    this.reply = reply;
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

  /**
   * 获取回复。
   *
   * @return 回复。
   */
  public String reply() {
    return reply;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventPermissionRepliedProperties)) return false;
    EventPermissionRepliedProperties that = (EventPermissionRepliedProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(requestID, that.requestID)
        && Objects.equals(reply, that.reply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, requestID, reply);
  }

  @Override
  public String toString() {
    return "EventPermissionRepliedProperties{" +
        "sessionID=" + sessionID + "," +
        "requestID=" + requestID + "," +
        "reply=" + reply +
        "}";
  }
}
