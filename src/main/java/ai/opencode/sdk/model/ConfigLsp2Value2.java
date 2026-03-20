package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 配置LSP值数据模型。
 *
 * @param command 命令内容。
 * @param extensions 扩展名列表。
 * @param disabled 已禁用标记。
 * @param env 环境变量映射。
 * @param initialization 初始化参数映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigLsp2Value2 {
  @JsonProperty("command")
  private final List<String> command;
  @JsonProperty("extensions")
  private final List<String> extensions;
  @JsonProperty("disabled")
  private final Boolean disabled;
  @JsonProperty("env")
  private final Map<String, String> env;
  @JsonProperty("initialization")
  private final Map<String, JsonNode> initialization;

  /** 使用字段创建配置LSP值。 */
  @JsonCreator
  public ConfigLsp2Value2(
      @JsonProperty("command") List<String> command,
      @JsonProperty("extensions") List<String> extensions,
      @JsonProperty("disabled") Boolean disabled,
      @JsonProperty("env") Map<String, String> env,
      @JsonProperty("initialization") Map<String, JsonNode> initialization
  ) {
    this.command = command;
    this.extensions = extensions;
    this.disabled = disabled;
    this.env = env;
    this.initialization = initialization;
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
   * 获取扩展名。
   *
   * @return 扩展名列表。
   */
  public List<String> extensions() {
    return extensions;
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
   * 获取环境变量。
   *
   * @return 环境变量映射。
   */
  public Map<String, String> env() {
    return env;
  }

  /**
   * 获取初始化。
   *
   * @return 初始化参数映射。
   */
  public Map<String, JsonNode> initialization() {
    return initialization;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigLsp2Value2)) return false;
    ConfigLsp2Value2 that = (ConfigLsp2Value2) other;
    return Objects.equals(command, that.command)
        && Objects.equals(extensions, that.extensions)
        && Objects.equals(disabled, that.disabled)
        && Objects.equals(env, that.env)
        && Objects.equals(initialization, that.initialization);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, extensions, disabled, env, initialization);
  }

  @Override
  public String toString() {
    return "ConfigLsp2Value2{" +
        "command=" + command + "," +
        "extensions=" + extensions + "," +
        "disabled=" + disabled + "," +
        "env=" + env + "," +
        "initialization=" + initialization +
        "}";
  }
}
