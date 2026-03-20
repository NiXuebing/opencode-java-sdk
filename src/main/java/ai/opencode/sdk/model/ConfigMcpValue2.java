package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置MCP值数据模型。
 *
 * @param enabled 是否启用。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigMcpValue2 {
  @JsonProperty("enabled")
  private final Boolean enabled;

  /** 使用字段创建配置MCP值。 */
  @JsonCreator
  public ConfigMcpValue2(
      @JsonProperty("enabled") Boolean enabled
  ) {
    this.enabled = enabled;
  }

  /**
   * 获取启用。
   *
   * @return 是否启用。
   */
  public Boolean enabled() {
    return enabled;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigMcpValue2)) return false;
    ConfigMcpValue2 that = (ConfigMcpValue2) other;
    return Objects.equals(enabled, that.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled);
  }

  @Override
  public String toString() {
    return "ConfigMcpValue2{" +
        "enabled=" + enabled +
        "}";
  }
}
