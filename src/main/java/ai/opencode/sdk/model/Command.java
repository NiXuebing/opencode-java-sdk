package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 命令数据模型。
 *
 * @param name 名称。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型 ID 或名称。
 * @param source 来源。
 * @param template 模板内容。
 * @param subtask 子任务标记。
 * @param hints 提示列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Command {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("agent")
  private final String agent;
  @JsonProperty("model")
  private final String model;
  @JsonProperty("source")
  private final String source;
  @JsonProperty("template")
  private final String template;
  @JsonProperty("subtask")
  private final Boolean subtask;
  @JsonProperty("hints")
  private final List<String> hints;

  /** 使用字段创建命令。 */
  @JsonCreator
  public Command(
      @JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("agent") String agent,
      @JsonProperty("model") String model,
      @JsonProperty("source") String source,
      @JsonProperty("template") String template,
      @JsonProperty("subtask") Boolean subtask,
      @JsonProperty("hints") List<String> hints
  ) {
    this.name = name;
    this.description = description;
    this.agent = agent;
    this.model = model;
    this.source = source;
    this.template = template;
    this.subtask = subtask;
    this.hints = hints;
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
   * 获取来源。
   *
   * @return 来源。
   */
  public String source() {
    return source;
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
   * 获取子任务。
   *
   * @return 子任务标记。
   */
  public Boolean subtask() {
    return subtask;
  }

  /**
   * 获取提示。
   *
   * @return 提示列表。
   */
  public List<String> hints() {
    return hints;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Command)) return false;
    Command that = (Command) other;
    return Objects.equals(name, that.name)
        && Objects.equals(description, that.description)
        && Objects.equals(agent, that.agent)
        && Objects.equals(model, that.model)
        && Objects.equals(source, that.source)
        && Objects.equals(template, that.template)
        && Objects.equals(subtask, that.subtask)
        && Objects.equals(hints, that.hints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, agent, model, source, template, subtask, hints);
  }

  @Override
  public String toString() {
    return "Command{" +
        "name=" + name + "," +
        "description=" + description + "," +
        "agent=" + agent + "," +
        "model=" + model + "," +
        "source=" + source + "," +
        "template=" + template + "," +
        "subtask=" + subtask + "," +
        "hints=" + hints +
        "}";
  }
}
