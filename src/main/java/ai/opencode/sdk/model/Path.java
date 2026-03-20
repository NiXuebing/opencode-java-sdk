package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 路径数据模型。
 *
 * @param home 主目录路径。
 * @param state 状态。
 * @param config 配置内容。
 * @param worktree 工作树。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Path {
  @JsonProperty("home")
  private final String home;
  @JsonProperty("state")
  private final String state;
  @JsonProperty("config")
  private final String config;
  @JsonProperty("worktree")
  private final String worktree;
  @JsonProperty("directory")
  private final String directory;

  /** 使用字段创建路径。 */
  @JsonCreator
  public Path(
      @JsonProperty("home") String home,
      @JsonProperty("state") String state,
      @JsonProperty("config") String config,
      @JsonProperty("worktree") String worktree,
      @JsonProperty("directory") String directory
  ) {
    this.home = home;
    this.state = state;
    this.config = config;
    this.worktree = worktree;
    this.directory = directory;
  }

  /**
   * 获取主目录。
   *
   * @return 主目录路径。
   */
  public String home() {
    return home;
  }

  /**
   * 获取状态。
   *
   * @return 状态。
   */
  public String state() {
    return state;
  }

  /**
   * 获取配置。
   *
   * @return 配置内容。
   */
  public String config() {
    return config;
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
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Path)) return false;
    Path that = (Path) other;
    return Objects.equals(home, that.home)
        && Objects.equals(state, that.state)
        && Objects.equals(config, that.config)
        && Objects.equals(worktree, that.worktree)
        && Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(home, state, config, worktree, directory);
  }

  @Override
  public String toString() {
    return "Path{" +
        "home=" + home + "," +
        "state=" + state + "," +
        "config=" + config + "," +
        "worktree=" + worktree + "," +
        "directory=" + directory +
        "}";
  }
}
