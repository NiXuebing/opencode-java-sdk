package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话创建请求体。
 *
 * @param parentID 父级消息 ID。
 * @param title 标题。
 * @param permission 权限配置。
 * @param workspaceID 工作区 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionCreateBody {
  @JsonProperty("parentID")
  private final String parentID;
  @JsonProperty("title")
  private final String title;
  @JsonProperty("permission")
  private final PermissionRuleset permission;
  @JsonProperty("workspaceID")
  private final String workspaceID;

  /** 使用字段创建会话创建请求体。 */
  @JsonCreator
  public SessionCreateBody(
      @JsonProperty("parentID") String parentID,
      @JsonProperty("title") String title,
      @JsonProperty("permission") PermissionRuleset permission,
      @JsonProperty("workspaceID") String workspaceID
  ) {
    this.parentID = parentID;
    this.title = title;
    this.permission = permission;
    this.workspaceID = workspaceID;
  }

  /**
   * 获取parent ID。
   *
   * @return 父级消息 ID。
   */
  public String parentID() {
    return parentID;
  }

  /**
   * 获取title。
   *
   * @return 标题。
   */
  public String title() {
    return title;
  }

  /**
   * 获取权限。
   *
   * @return 权限配置。
   */
  public PermissionRuleset permission() {
    return permission;
  }

  /**
   * 获取工作区ID。
   *
   * @return 工作区 ID。
   */
  public String workspaceID() {
    return workspaceID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionCreateBody)) return false;
    SessionCreateBody that = (SessionCreateBody) other;
    return Objects.equals(parentID, that.parentID)
        && Objects.equals(title, that.title)
        && Objects.equals(permission, that.permission)
        && Objects.equals(workspaceID, that.workspaceID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parentID, title, permission, workspaceID);
  }

  @Override
  public String toString() {
    return "SessionCreateBody{" +
        "parentID=" + parentID + "," +
        "title=" + title + "," +
        "permission=" + permission + "," +
        "workspaceID=" + workspaceID +
        "}";
  }
}
