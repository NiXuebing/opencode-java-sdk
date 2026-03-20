package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 项目数据模型。
 *
 * @param id 唯一标识。
 * @param worktree 工作树。
 * @param vcs 版本控制。
 * @param name 名称。
 * @param icon 图标配置。
 * @param commands 命令。
 * @param time 时间。
 * @param sandboxes 沙箱列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Project {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("worktree")
  private final String worktree;
  @JsonProperty("vcs")
  private final String vcs;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("icon")
  private final ProjectIcon icon;
  @JsonProperty("commands")
  private final ProjectCommands commands;
  @JsonProperty("time")
  private final ProjectTime time;
  @JsonProperty("sandboxes")
  private final List<String> sandboxes;

  /** 使用字段创建项目。 */
  @JsonCreator
  public Project(
      @JsonProperty("id") String id,
      @JsonProperty("worktree") String worktree,
      @JsonProperty("vcs") String vcs,
      @JsonProperty("name") String name,
      @JsonProperty("icon") ProjectIcon icon,
      @JsonProperty("commands") ProjectCommands commands,
      @JsonProperty("time") ProjectTime time,
      @JsonProperty("sandboxes") List<String> sandboxes
  ) {
    this.id = id;
    this.worktree = worktree;
    this.vcs = vcs;
    this.name = name;
    this.icon = icon;
    this.commands = commands;
    this.time = time;
    this.sandboxes = sandboxes;
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
   * 获取工作树。
   *
   * @return 工作树。
   */
  public String worktree() {
    return worktree;
  }

  /**
   * 获取版本控制。
   *
   * @return 版本控制。
   */
  public String vcs() {
    return vcs;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  /**
   * 获取icon。
   *
   * @return 图标配置。
   */
  public ProjectIcon icon() {
    return icon;
  }

  /**
   * 获取命令。
   *
   * @return 命令。
   */
  public ProjectCommands commands() {
    return commands;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public ProjectTime time() {
    return time;
  }

  /**
   * 获取沙箱。
   *
   * @return 沙箱列表。
   */
  public List<String> sandboxes() {
    return sandboxes;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Project)) return false;
    Project that = (Project) other;
    return Objects.equals(id, that.id)
        && Objects.equals(worktree, that.worktree)
        && Objects.equals(vcs, that.vcs)
        && Objects.equals(name, that.name)
        && Objects.equals(icon, that.icon)
        && Objects.equals(commands, that.commands)
        && Objects.equals(time, that.time)
        && Objects.equals(sandboxes, that.sandboxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, worktree, vcs, name, icon, commands, time, sandboxes);
  }

  @Override
  public String toString() {
    return "Project{" +
        "id=" + id + "," +
        "worktree=" + worktree + "," +
        "vcs=" + vcs + "," +
        "name=" + name + "," +
        "icon=" + icon + "," +
        "commands=" + commands + "," +
        "time=" + time + "," +
        "sandboxes=" + sandboxes +
        "}";
  }
}
