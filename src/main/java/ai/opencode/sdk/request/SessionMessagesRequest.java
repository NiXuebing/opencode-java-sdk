package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 列出会话消息接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param limit 返回结果数量上限。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionMessagesRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("limit")
  private final Long limit;

  /** 创建会话消息请求。 */
  @JsonCreator
  public SessionMessagesRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("limit") Long limit
  ) {
    this.sessionID = sessionID;
    this.directory = directory;
    this.limit = limit;
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
   * 获取限制。
   *
   * @return 返回结果数量上限。
   */
  public Long limit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionMessagesRequest)) return false;
    SessionMessagesRequest that = (SessionMessagesRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(limit, that.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, directory, limit);
  }

  @Override
  public String toString() {
    return "SessionMessagesRequest{" +
        "sessionID=" + sessionID + "," +
        "directory=" + directory + "," +
        "limit=" + limit +
        "}";
  }
}
