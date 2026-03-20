package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 问题请求工具数据模型。
 *
 * @param messageID 目标消息 ID。
 * @param callID 调用 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionRequestTool {
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("callID")
  private final String callID;

  /** 使用字段创建问题请求工具。 */
  @JsonCreator
  public QuestionRequestTool(
      @JsonProperty("messageID") String messageID,
      @JsonProperty("callID") String callID
  ) {
    this.messageID = messageID;
    this.callID = callID;
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
   * 获取调用ID。
   *
   * @return 调用 ID。
   */
  public String callID() {
    return callID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionRequestTool)) return false;
    QuestionRequestTool that = (QuestionRequestTool) other;
    return Objects.equals(messageID, that.messageID)
        && Objects.equals(callID, that.callID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID, callID);
  }

  @Override
  public String toString() {
    return "QuestionRequestTool{" +
        "messageID=" + messageID + "," +
        "callID=" + callID +
        "}";
  }
}
