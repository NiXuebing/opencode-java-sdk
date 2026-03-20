package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * MCP本地配置。
 *
 * @param type 类型标识。
 * @param command 命令内容。
 * @param environment 环境变量映射。
 * @param enabled 是否启用。
 * @param timeout 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class McpLocalConfig implements McpAddBodyConfig {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("command")
  private final List<String> command;
  @JsonProperty("environment")
  private final Map<String, String> environment;
  @JsonProperty("enabled")
  private final Boolean enabled;
  @JsonProperty("timeout")
  private final Long timeout;

  /** 使用字段创建MCP本地配置。 */
  @JsonCreator
  public McpLocalConfig(
      @JsonProperty("type") String type,
      @JsonProperty("command") List<String> command,
      @JsonProperty("environment") Map<String, String> environment,
      @JsonProperty("enabled") Boolean enabled,
      @JsonProperty("timeout") Long timeout
  ) {
    this.type = type;
    this.command = command;
    this.environment = environment;
    this.enabled = enabled;
    this.timeout = timeout;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
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
   * 获取启用。
   *
   * @return 是否启用。
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * 获取timeout。
   *
   * @return 请求超时时间。
   */
  public Long timeout() {
    return timeout;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof McpLocalConfig)) return false;
    McpLocalConfig that = (McpLocalConfig) other;
    return Objects.equals(type, that.type)
        && Objects.equals(command, that.command)
        && Objects.equals(environment, that.environment)
        && Objects.equals(enabled, that.enabled)
        && Objects.equals(timeout, that.timeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, command, environment, enabled, timeout);
  }

  @Override
  public String toString() {
    return "McpLocalConfig{" +
        "type=" + type + "," +
        "command=" + command + "," +
        "environment=" + environment + "," +
        "enabled=" + enabled + "," +
        "timeout=" + timeout +
        "}";
  }
}
