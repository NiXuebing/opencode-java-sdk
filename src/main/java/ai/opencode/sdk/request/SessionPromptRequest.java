package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionPromptBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 发送会话提示接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 发送会话提示的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionPromptRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final SessionPromptBody body;

  /** 创建会话提示词请求。 */
  @JsonCreator
  public SessionPromptRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("body") SessionPromptBody body
  ) {
    this.sessionID = sessionID;
    this.directory = directory;
    this.body = body;
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
   * 获取请求体。
   *
   * @return 请求体内容。
   */
  public SessionPromptBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionPromptRequest)) return false;
    SessionPromptRequest that = (SessionPromptRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, directory, body);
  }

  @Override
  public String toString() {
    return "SessionPromptRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
