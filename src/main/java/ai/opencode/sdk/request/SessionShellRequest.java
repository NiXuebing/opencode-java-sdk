package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionShellBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 执行会话 Shell 命令接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 执行会话 Shell 命令的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionShellRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final SessionShellBody body;

  /** 创建会话Shell请求。 */
  @JsonCreator
  public SessionShellRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("body") SessionShellBody body
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
  public SessionShellBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionShellRequest)) return false;
    SessionShellRequest that = (SessionShellRequest) other;
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
    return "SessionShellRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
