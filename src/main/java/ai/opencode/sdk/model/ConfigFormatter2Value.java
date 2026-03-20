package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 配置格式化器值数据模型。
 *
 * @param disabled 已禁用标记。
 * @param command 命令内容。
 * @param environment 环境变量映射。
 * @param extensions 扩展名列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigFormatter2Value {
  @JsonProperty("disabled")
  private final Boolean disabled;
  @JsonProperty("command")
  private final List<String> command;
  @JsonProperty("environment")
  private final Map<String, String> environment;
  @JsonProperty("extensions")
  private final List<String> extensions;

  /** 使用字段创建配置格式化器值。 */
  @JsonCreator
  public ConfigFormatter2Value(
      @JsonProperty("disabled") Boolean disabled,
      @JsonProperty("command") List<String> command,
      @JsonProperty("environment") Map<String, String> environment,
      @JsonProperty("extensions") List<String> extensions
  ) {
    this.disabled = disabled;
    this.command = command;
    this.environment = environment;
    this.extensions = extensions;
  }

  /**
   * 获取已禁用。
   *
   * @return 已禁用标记。
   */
  public Boolean disabled() {
    return disabled;
  }

  /**
   * 获取命令。
   *
   * @return 命令内容。
   */
  public List<String> command() {
    return command;
  }

  /**
   * 获取环境变量。
   *
   * @return 环境变量映射。
   */
  public Map<String, String> environment() {
    return environment;
  }

  /**
   * 获取扩展名。
   *
   * @return 扩展名列表。
   */
  public List<String> extensions() {
    return extensions;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigFormatter2Value)) return false;
    ConfigFormatter2Value that = (ConfigFormatter2Value) other;
    return Objects.equals(disabled, that.disabled)
        && Objects.equals(command, that.command)
        && Objects.equals(environment, that.environment)
        && Objects.equals(extensions, that.extensions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabled, command, environment, extensions);
  }

  @Override
  public String toString() {
    return "ConfigFormatter2Value{" +
        "disabled=" + disabled + "," +
        "command=" + command + "," +
        "environment=" + environment + "," +
        "extensions=" + extensions +
        "}";
  }
}
