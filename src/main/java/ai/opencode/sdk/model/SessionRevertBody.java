package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话撤回请求体。
 *
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionRevertBody {
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("partID")
  private final String partID;

  /** 使用字段创建会话撤回请求体。 */
  @JsonCreator
  public SessionRevertBody(
      @JsonProperty("messageID") String messageID,
      @JsonProperty("partID") String partID
  ) {
    this.messageID = messageID;
    this.partID = partID;
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
    if (!(other instanceof SessionRevertBody)) return false;
    SessionRevertBody that = (SessionRevertBody) other;
    return Objects.equals(messageID, that.messageID)
        && Objects.equals(partID, that.partID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID, partID);
  }

  @Override
  public String toString() {
    return "SessionRevertBody{" +
        "messageID=" + messageID + "," +
        "partID=" + partID +
        "}";
  }
}
