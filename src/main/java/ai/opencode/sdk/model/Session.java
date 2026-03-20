package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话数据模型。
 *
 * @param id 唯一标识。
 * @param slug 短标识。
 * @param projectID 项目 ID。
 * @param workspaceID 工作区 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param parentID 父级消息 ID。
 * @param summary 摘要内容。
 * @param share 分享。
 * @param title 标题。
 * @param version 版本号。
 * @param time 时间。
 * @param permission 权限配置。
 * @param revert 撤回。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Session {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("slug")
  private final String slug;
  @JsonProperty("projectID")
  private final String projectID;
  @JsonProperty("workspaceID")
  private final String workspaceID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("parentID")
  private final String parentID;
  @JsonProperty("summary")
  private final SessionSummary summary;
  @JsonProperty("share")
  private final SessionShare share;
  @JsonProperty("title")
  private final String title;
  @JsonProperty("version")
  private final String version;
  @JsonProperty("time")
  private final SessionTime time;
  @JsonProperty("permission")
  private final PermissionRuleset permission;
  @JsonProperty("revert")
  private final SessionRevert revert;

  /** 使用字段创建会话。 */
  @JsonCreator
  public Session(
      @JsonProperty("id") String id,
      @JsonProperty("slug") String slug,
      @JsonProperty("projectID") String projectID,
      @JsonProperty("workspaceID") String workspaceID,
      @JsonProperty("directory") String directory,
      @JsonProperty("parentID") String parentID,
      @JsonProperty("summary") SessionSummary summary,
      @JsonProperty("share") SessionShare share,
      @JsonProperty("title") String title,
      @JsonProperty("version") String version,
      @JsonProperty("time") SessionTime time,
      @JsonProperty("permission") PermissionRuleset permission,
      @JsonProperty("revert") SessionRevert revert
  ) {
    this.id = id;
    this.slug = slug;
    this.projectID = projectID;
    this.workspaceID = workspaceID;
    this.directory = directory;
    this.parentID = parentID;
    this.summary = summary;
    this.share = share;
    this.title = title;
    this.version = version;
    this.time = time;
    this.permission = permission;
    this.revert = revert;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取slug。
   *
   * @return 短标识。
   */
  public String slug() {
    return slug;
  }

  /**
   * 获取项目ID。
   *
   * @return 项目 ID。
   */
  public String projectID() {
    return projectID;
  }

  /**
   * 获取工作区ID。
   *
   * @return 工作区 ID。
   */
  public String workspaceID() {
    return workspaceID;
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
   * 获取parent ID。
   *
   * @return 父级消息 ID。
   */
  public String parentID() {
    return parentID;
  }

  /**
   * 获取摘要。
   *
   * @return 摘要内容。
   */
  public SessionSummary summary() {
    return summary;
  }

  /**
   * 获取分享。
   *
   * @return 分享。
   */
  public SessionShare share() {
    return share;
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
   * 获取版本。
   *
   * @return 版本号。
   */
  public String version() {
    return version;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public SessionTime time() {
    return time;
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
   * 获取撤回。
   *
   * @return 撤回。
   */
  public SessionRevert revert() {
    return revert;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Session)) return false;
    Session that = (Session) other;
    return Objects.equals(id, that.id)
        && Objects.equals(slug, that.slug)
        && Objects.equals(projectID, that.projectID)
        && Objects.equals(workspaceID, that.workspaceID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(parentID, that.parentID)
        && Objects.equals(summary, that.summary)
        && Objects.equals(share, that.share)
        && Objects.equals(title, that.title)
        && Objects.equals(version, that.version)
        && Objects.equals(time, that.time)
        && Objects.equals(permission, that.permission)
        && Objects.equals(revert, that.revert);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, slug, projectID, workspaceID, directory, parentID, summary, share, title, version, time, permission, revert);
  }

  @Override
  public String toString() {
    return "Session{" +
        "id=" + id + "," +
        "slug=" + slug + "," +
        "projectID=" + projectID + "," +
        "workspaceID=" + workspaceID + "," +
        "directory=" + directory + "," +
        "parentID=" + parentID + "," +
        "summary=" + summary + "," +
        "share=" + share + "," +
        "title=" + title + "," +
        "version=" + version + "," +
        "time=" + time + "," +
        "permission=" + permission + "," +
        "revert=" + revert +
        "}";
  }
}
