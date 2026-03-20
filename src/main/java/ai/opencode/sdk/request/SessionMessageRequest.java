package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 获取消息详情接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionMessageRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("directory")
  private final String directory;

  /** 创建会话消息请求。 */
  @JsonCreator
  public SessionMessageRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("directory") String directory
  ) {
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.directory = directory;
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
   * 获取消息ID。
   *
   * @return 目标消息 ID。
   */
  public String messageID() {
    return messageID;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionMessageRequest)) return false;
    SessionMessageRequest that = (SessionMessageRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, messageID, directory);
  }

  @Override
  public String toString() {
    return "SessionMessageRequest{" +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "directory=" + directory +
        "}";
  }
}
