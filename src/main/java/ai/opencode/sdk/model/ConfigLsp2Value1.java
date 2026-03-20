package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置LSP值数据模型。
 *
 * @param disabled 已禁用标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigLsp2Value1 {
  @JsonProperty("disabled")
  private final Boolean disabled;

  /** 使用字段创建配置LSP值。 */
  @JsonCreator
  public ConfigLsp2Value1(
      @JsonProperty("disabled") Boolean disabled
  ) {
    this.disabled = disabled;
  }

  /**
   * 获取已禁用。
   *
   * @return 已禁用标记。
   */
  public Boolean disabled() {
    return disabled;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigLsp2Value1)) return false;
    ConfigLsp2Value1 that = (ConfigLsp2Value1) other;
    return Objects.equals(disabled, that.disabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabled);
  }

  @Override
  public String toString() {
    return "ConfigLsp2Value1{" +
        "disabled=" + disabled +
        "}";
  }
}
