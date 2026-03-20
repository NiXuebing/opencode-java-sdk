package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 获取会话差异接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param messageID 目标消息 ID。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionDiffRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("messageID")
  private final String messageID;

  /** 创建会话差异请求。 */
  @JsonCreator
  public SessionDiffRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("messageID") String messageID
  ) {
    this.sessionID = sessionID;
    this.directory = directory;
    this.messageID = messageID;
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
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
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
    if (!(other instanceof SessionDiffRequest)) return false;
    SessionDiffRequest that = (SessionDiffRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(messageID, that.messageID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, directory, messageID);
  }

  @Override
  public String toString() {
    return "SessionDiffRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory + "," +
        "messageID=" + messageID +
        "}";
  }
}
