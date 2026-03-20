package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置代理数据模型。
 *
 * @param plan 规划。
 * @param build 构建。
 * @param general 通用。
 * @param explore 探索模式配置。
 * @param title 标题。
 * @param summary 摘要相关配置。
 * @param compaction 压缩。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigAgent {
  @JsonProperty("plan")
  private final AgentConfig plan;
  @JsonProperty("build")
  private final AgentConfig build;
  @JsonProperty("general")
  private final AgentConfig general;
  @JsonProperty("explore")
  private final AgentConfig explore;
  @JsonProperty("title")
  private final AgentConfig title;
  @JsonProperty("summary")
  private final AgentConfig summary;
  @JsonProperty("compaction")
  private final AgentConfig compaction;

  /** 使用字段创建配置代理。 */
  @JsonCreator
  public ConfigAgent(
      @JsonProperty("plan") AgentConfig plan,
      @JsonProperty("build") AgentConfig build,
      @JsonProperty("general") AgentConfig general,
      @JsonProperty("explore") AgentConfig explore,
      @JsonProperty("title") AgentConfig title,
      @JsonProperty("summary") AgentConfig summary,
      @JsonProperty("compaction") AgentConfig compaction
  ) {
    this.plan = plan;
    this.build = build;
    this.general = general;
    this.explore = explore;
    this.title = title;
    this.summary = summary;
    this.compaction = compaction;
  }

  /**
   * 获取规划。
   *
   * @return 规划。
   */
  public AgentConfig plan() {
    return plan;
  }

  /**
   * 获取构建。
   *
   * @return 构建。
   */
  public AgentConfig build() {
    return build;
  }

  /**
   * 获取通用。
   *
   * @return 通用。
   */
  public AgentConfig general() {
    return general;
  }

  /**
   * 获取explore。
   *
   * @return 探索模式配置。
   */
  public AgentConfig explore() {
    return explore;
  }

  /**
   * 获取title。
   *
   * @return 标题。
   */
  public AgentConfig title() {
    return title;
  }

  /**
   * 获取摘要。
   *
   * @return 摘要相关配置。
   */
  public AgentConfig summary() {
    return summary;
  }

  /**
   * 获取压缩。
   *
   * @return 压缩。
   */
  public AgentConfig compaction() {
    return compaction;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigAgent)) return false;
    ConfigAgent that = (ConfigAgent) other;
    return Objects.equals(plan, that.plan)
        && Objects.equals(build, that.build)
        && Objects.equals(general, that.general)
        && Objects.equals(explore, that.explore)
        && Objects.equals(title, that.title)
        && Objects.equals(summary, that.summary)
        && Objects.equals(compaction, that.compaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plan, build, general, explore, title, summary, compaction);
  }

  @Override
  public String toString() {
    return "ConfigAgent{" +
        "plan=" + plan + "," +
        "build=" + build + "," +
        "general=" + general + "," +
        "explore=" + explore + "," +
        "title=" + title + "," +
        "summary=" + summary + "," +
        "compaction=" + compaction +
        "}";
  }
}
