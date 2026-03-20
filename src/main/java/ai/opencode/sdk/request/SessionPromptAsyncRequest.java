package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionPromptAsyncBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 异步发送提示接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 异步发送提示的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionPromptAsyncRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final SessionPromptAsyncBody body;

  /** 创建会话提示词异步请求。 */
  @JsonCreator
  public SessionPromptAsyncRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("body") SessionPromptAsyncBody body
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
  public SessionPromptAsyncBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionPromptAsyncRequest)) return false;
    SessionPromptAsyncRequest that = (SessionPromptAsyncRequest) other;
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
    return "SessionPromptAsyncRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
