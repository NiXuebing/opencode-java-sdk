package ai.opencode.sdk.request;

import ai.opencode.sdk.model.PermissionRespondBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 响应权限请求接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param permissionID 待响应的权限请求 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 响应权限请求的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionRespondRequest {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("permissionID")
  private final String permissionID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final PermissionRespondBody body;

  /** 创建权限响应请求。 */
  @JsonCreator
  public PermissionRespondRequest(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("permissionID") String permissionID,
      @JsonProperty("directory") String directory,
      @JsonProperty("body") PermissionRespondBody body
  ) {
    this.sessionID = sessionID;
    this.permissionID = permissionID;
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
   * 获取权限ID。
   *
   * @return 待响应的权限请求 ID。
   */
  public String permissionID() {
    return permissionID;
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
  public PermissionRespondBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionRespondRequest)) return false;
    PermissionRespondRequest that = (PermissionRespondRequest) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(permissionID, that.permissionID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, permissionID, directory, body);
  }

  @Override
  public String toString() {
    return "PermissionRespondRequest{" +
        "sessionID=" + sessionID + "," +
        "permissionID=" + permissionID + "," +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
