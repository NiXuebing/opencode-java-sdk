package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 取消分享会话接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionUnshareRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;

  /** 创建会话取消分享请求。 */
  @JsonCreator
  public SessionUnshareRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory
  ) {
    this.sessionID = sessionID;
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
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionUnshareRequest)) return false;
    SessionUnshareRequest that = (SessionUnshareRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, directory);
  }

  @Override
  public String toString() {
    return "SessionUnshareRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory +
        "}";
  }
}
