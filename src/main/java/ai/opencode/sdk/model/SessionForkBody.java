package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话派生请求体。
 *
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionForkBody {
  @JsonProperty("messageID")
  private final String messageID;

  /** 使用字段创建会话派生请求体。 */
  @JsonCreator
  public SessionForkBody(
      @JsonProperty("messageID") String messageID
  ) {
    this.messageID = messageID;
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
    if (!(other instanceof SessionForkBody)) return false;
    SessionForkBody that = (SessionForkBody) other;
    return Objects.equals(messageID, that.messageID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageID);
  }

  @Override
  public String toString() {
    return "SessionForkBody{" +
        "messageID=" + messageID +
        "}";
  }
}
