package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * MCP Add请求体。
 *
 * @param name 名称。
 * @param config 配置内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class McpAddBody {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("config")
  private final McpAddBodyConfig config;

  /** 使用字段创建MCP Add请求体。 */
  @JsonCreator
  public McpAddBody(
      @JsonProperty("name") String name,
      @JsonProperty("config") McpAddBodyConfig config
  ) {
    this.name = name;
    this.config = config;
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
   * 获取配置。
   *
   * @return 配置内容。
   */
  public McpAddBodyConfig config() {
    return config;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof McpAddBody)) return false;
    McpAddBody that = (McpAddBody) other;
    return Objects.equals(name, that.name)
        && Objects.equals(config, that.config);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, config);
  }

  @Override
  public String toString() {
    return "McpAddBody{" +
        "name=" + name + "," +
        "config=" + config +
        "}";
  }
}
