package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置命令值数据模型。
 *
 * @param template 模板内容。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型 ID 或名称。
 * @param subtask 子任务标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigCommandValue {
  @JsonProperty("template")
  private final String template;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final String model;
  @JsonProperty("subtask")
  private final Boolean subtask;

  /** 使用字段创建配置命令值。 */
  @JsonCreator
  public ConfigCommandValue(
      @JsonProperty("template") String template,
      @JsonProperty("description") String description,
      @JsonProperty("agent") String agent,
      @JsonProperty("model") String model,
      @JsonProperty("subtask") Boolean subtask
  ) {
    this.template = template;
    this.description = description;
    this.agent = agent;
    this.model = model;
    this.subtask = subtask;
  }

  /**
   * 获取template。
   *
   * @return 模板内容。
   */
  public String template() {
    return template;
  }

  /**
   * 获取description。
   *
   * @return 描述信息。
   */
  public String description() {
    return description;
  }

  /**
   * 获取代理。
   *
   * @return 代理名称。
   */
  public String agent() {
    return agent;
  }

  /**
   * 获取模型。
   *
   * @return 模型 ID 或名称。
   */
  public String model() {
    return model;
  }

  /**
   * 获取子任务。
   *
   * @return 子任务标记。
   */
  public Boolean subtask() {
    return subtask;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigCommandValue)) return false;
    ConfigCommandValue that = (ConfigCommandValue) other;
    return Objects.equals(template, that.template)
        && Objects.equals(description, that.description)
        && Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(subtask, that.subtask);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, description, agent, model, subtask);
  }

  @Override
  public String toString() {
    return "ConfigCommandValue{" +
        "template=" + template + "," +
        "description=" + description + "," +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "subtask=" + subtask +
        "}";
  }
}
