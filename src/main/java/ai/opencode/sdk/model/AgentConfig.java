package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 代理配置。
 *
 * @param model 模型 ID 或名称。
 * @param variant 变体名称。
 * @param temperature 采样温度。
 * @param topP Top P 采样参数。
 * @param prompt 提示词。
 * @param tools 工具开关配置。
 * @param disable 是否禁用。
 * @param description 描述信息。
 * @param mode 运行模式。
 * @param hidden 是否隐藏。
 * @param options 扩展选项映射。
 * @param color 颜色标识。
 * @param steps 步骤数上限。
 * @param maxSteps 最大步骤数。
 * @param permission 权限配置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AgentConfig {
  @JsonProperty("model")
  private final String model;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("temperature")
  private final Double temperature;
  @JsonProperty("top_p")
  private final Double topP;
  @JsonProperty("prompt")
  private final String prompt;
  @JsonProperty("tools")
  private final Map<String, Boolean> tools;
  @JsonProperty("disable")
  private final Boolean disable;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("mode")
  private final String mode;
  @JsonProperty("hidden")
  private final Boolean hidden;
  @JsonProperty("options")
  private final Map<String, JsonNode> options;
  @JsonProperty("color")
  private final String color;
  @JsonProperty("steps")
  private final Long steps;
  @JsonProperty("maxSteps")
  private final Long maxSteps;
  @JsonProperty("permission")
  private final PermissionConfig permission;

  /** 使用字段创建代理配置。 */
  @JsonCreator
  public AgentConfig(
      @JsonProperty("model") String model,
      @JsonProperty("variant") String variant,
      @JsonProperty("temperature") Double temperature,
      @JsonProperty("top_p") Double topP,
      @JsonProperty("prompt") String prompt,
      @JsonProperty("tools") Map<String, Boolean> tools,
      @JsonProperty("disable") Boolean disable,
      @JsonProperty("description") String description,
      @JsonProperty("mode") String mode,
      @JsonProperty("hidden") Boolean hidden,
      @JsonProperty("options") Map<String, JsonNode> options,
      @JsonProperty("color") String color,
      @JsonProperty("steps") Long steps,
      @JsonProperty("maxSteps") Long maxSteps,
      @JsonProperty("permission") PermissionConfig permission
  ) {
    this.model = model;
    this.variant = variant;
    this.temperature = temperature;
    this.topP = topP;
    this.prompt = prompt;
    this.tools = tools;
    this.disable = disable;
    this.description = description;
    this.mode = mode;
    this.hidden = hidden;
    this.options = options;
    this.color = color;
    this.steps = steps;
    this.maxSteps = maxSteps;
    this.permission = permission;
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
   * 获取变体。
   *
   * @return 变体名称。
   */
  public String variant() {
    return variant;
  }

  /**
   * 获取温度。
   *
   * @return 采样温度。
   */
  public Double temperature() {
    return temperature;
  }

  /**
   * 获取Top p。
   *
   * @return Top P 采样参数。
   */
  public Double topP() {
    return topP;
  }

  /**
   * 获取提示词。
   *
   * @return 提示词。
   */
  public String prompt() {
    return prompt;
  }

  /**
   * 获取工具。
   *
   * @return 工具开关配置。
   */
  public Map<String, Boolean> tools() {
    return tools;
  }

  /**
   * 获取disable。
   *
   * @return 是否禁用。
   */
  public Boolean disable() {
    return disable;
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
   * 获取模式。
   *
   * @return 运行模式。
   */
  public String mode() {
    return mode;
  }

  /**
   * 获取隐藏。
   *
   * @return 是否隐藏。
   */
  public Boolean hidden() {
    return hidden;
  }

  /**
   * 获取选项。
   *
   * @return 扩展选项映射。
   */
  public Map<String, JsonNode> options() {
    return options;
  }

  /**
   * 获取color。
   *
   * @return 颜色标识。
   */
  public String color() {
    return color;
  }

  /**
   * 获取steps。
   *
   * @return 步骤数上限。
   */
  public Long steps() {
    return steps;
  }

  /**
   * 获取最大Steps。
   *
   * @return 最大步骤数。
   */
  public Long maxSteps() {
    return maxSteps;
  }

  /**
   * 获取权限。
   *
   * @return 权限配置。
   */
  public PermissionConfig permission() {
    return permission;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AgentConfig)) return false;
    AgentConfig that = (AgentConfig) other;
    return Objects.equals(model, that.model)
        && Objects.equals(variant, that.variant)
        && Objects.equals(temperature, that.temperature)
        && Objects.equals(topP, that.topP)
        && Objects.equals(prompt, that.prompt)
        && Objects.equals(tools, that.tools)
        && Objects.equals(disable, that.disable)
        && Objects.equals(description, that.description)
        && Objects.equals(mode, that.mode)
        && Objects.equals(hidden, that.hidden)
        && Objects.equals(options, that.options)
        && Objects.equals(color, that.color)
        && Objects.equals(steps, that.steps)
        && Objects.equals(maxSteps, that.maxSteps)
        && Objects.equals(permission, that.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, variant, temperature, topP, prompt, tools, disable, description, mode, hidden, options, color, steps, maxSteps, permission);
  }

  @Override
  public String toString() {
    return "AgentConfig{" +
        "model=" + model + "," +
        "variant=" + variant + "," +
        "temperature=" + temperature + "," +
        "topP=" + topP + "," +
        "prompt=" + prompt + "," +
        "tools=" + tools + "," +
        "disable=" + disable + "," +
        "description=" + description + "," +
        "mode=" + mode + "," +
        "hidden=" + hidden + "," +
        "options=" + options + "," +
        "color=" + color + "," +
        "steps=" + steps + "," +
        "maxSteps=" + maxSteps + "," +
        "permission=" + permission +
        "}";
  }
}
