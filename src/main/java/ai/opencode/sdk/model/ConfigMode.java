package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置模式数据模型。
 *
 * @param build 构建。
 * @param plan 规划。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigMode {
  @JsonProperty("build")
  private final AgentConfig build;
  @JsonProperty("plan")
  private final AgentConfig plan;

  /** 使用字段创建配置模式。 */
  @JsonCreator
  public ConfigMode(
      @JsonProperty("build") AgentConfig build,
      @JsonProperty("plan") AgentConfig plan
  ) {
    this.build = build;
    this.plan = plan;
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
   * 获取规划。
   *
   * @return 规划。
   */
  public AgentConfig plan() {
    return plan;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigMode)) return false;
    ConfigMode that = (ConfigMode) other;
    return Objects.equals(build, that.build)
        && Objects.equals(plan, that.plan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(build, plan);
  }

  @Override
  public String toString() {
    return "ConfigMode{" +
        "build=" + build + "," +
        "plan=" + plan +
        "}";
  }
}
