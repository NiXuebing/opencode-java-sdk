package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 代理数据模型。
 *
 * @param name 名称。
 * @param description 描述信息。
 * @param mode 运行模式。
 * @param nativeValue 是否使用原生能力。
 * @param hidden 是否隐藏。
 * @param topP Top P 采样参数。
 * @param temperature 采样温度。
 * @param color 颜色标识。
 * @param permission 权限配置。
 * @param model 模型配置。
 * @param variant 变体名称。
 * @param prompt 提示词。
 * @param options 扩展选项映射。
 * @param steps 步骤数上限。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Agent {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("mode")
  private final String mode;
  @JsonProperty("native")
  private final Boolean nativeValue;
  @JsonProperty("hidden")
  private final Boolean hidden;
  @JsonProperty("topP")
  private final Double topP;
  @JsonProperty("temperature")
  private final Double temperature;
  @JsonProperty("color")
  private final String color;
  @JsonProperty("permission")
  private final PermissionRuleset permission;
  @JsonProperty("model")
  private final AgentModel model;
  @JsonProperty("variant")
  private final String variant;
  @JsonProperty("prompt")
  private final String prompt;
  @JsonProperty("options")
  private final Map<String, JsonNode> options;
  @JsonProperty("steps")
  private final Long steps;

  /** 使用字段创建代理。 */
  @JsonCreator
  public Agent(
      @JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("mode") String mode,
      @JsonProperty("native") Boolean nativeValue,
      @JsonProperty("hidden") Boolean hidden,
      @JsonProperty("topP") Double topP,
      @JsonProperty("temperature") Double temperature,
      @JsonProperty("color") String color,
      @JsonProperty("permission") PermissionRuleset permission,
      @JsonProperty("model") AgentModel model,
      @JsonProperty("variant") String variant,
      @JsonProperty("prompt") String prompt,
      @JsonProperty("options") Map<String, JsonNode> options,
      @JsonProperty("steps") Long steps
  ) {
    this.name = name;
    this.description = description;
    this.mode = mode;
    this.nativeValue = nativeValue;
    this.hidden = hidden;
    this.topP = topP;
    this.temperature = temperature;
    this.color = color;
    this.permission = permission;
    this.model = model;
    this.variant = variant;
    this.prompt = prompt;
    this.options = options;
    this.steps = steps;
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
   * 获取模式。
   *
   * @return 运行模式。
   */
  public String mode() {
    return mode;
  }

  /**
   * 获取原生。
   *
   * @return 是否使用原生能力。
   */
  public Boolean nativeValue() {
    return nativeValue;
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
   * 获取Top P。
   *
   * @return Top P 采样参数。
   */
  public Double topP() {
    return topP;
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
   * 获取color。
   *
   * @return 颜色标识。
   */
  public String color() {
    return color;
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
   * 获取模型。
   *
   * @return 模型配置。
   */
  public AgentModel model() {
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
   * 获取提示词。
   *
   * @return 提示词。
   */
  public String prompt() {
    return prompt;
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
   * 获取steps。
   *
   * @return 步骤数上限。
   */
  public Long steps() {
    return steps;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Agent)) return false;
    Agent that = (Agent) other;
    return Objects.equals(name, that.name)
        && Objects.equals(description, that.description)
        && Objects.equals(mode, that.mode)
        && Objects.equals(nativeValue, that.nativeValue)
        && Objects.equals(hidden, that.hidden)
        && Objects.equals(topP, that.topP)
        && Objects.equals(temperature, that.temperature)
        && Objects.equals(color, that.color)
        && Objects.equals(permission, that.permission)
        && Objects.equals(model, that.model)
        && Objects.equals(variant, that.variant)
        && Objects.equals(prompt, that.prompt)
        && Objects.equals(options, that.options)
        && Objects.equals(steps, that.steps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, mode, nativeValue, hidden, topP, temperature, color, permission, model, variant, prompt, options, steps);
  }

  @Override
  public String toString() {
    return "Agent{" +
        "name=" + name + "," +
        "description=" + description + "," +
        "mode=" + mode + "," +
        "nativeValue=" + nativeValue + "," +
        "hidden=" + hidden + "," +
        "topP=" + topP + "," +
        "temperature=" + temperature + "," +
        "color=" + color + "," +
        "permission=" + permission + "," +
        "model=" + model + "," +
        "variant=" + variant + "," +
        "prompt=" + prompt + "," +
        "options=" + options + "," +
        "steps=" + steps +
        "}";
  }
}
