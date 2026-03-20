package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商配置模型值变体值数据模型。
 *
 * @param disabled 已禁用标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueVariantsValue {
  @JsonProperty("disabled")
  private final Boolean disabled;

  /** 使用字段创建提供商配置模型值变体值。 */
  @JsonCreator
  public ProviderConfigModelsValueVariantsValue(
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
    if (!(other instanceof ProviderConfigModelsValueVariantsValue)) return false;
    ProviderConfigModelsValueVariantsValue that = (ProviderConfigModelsValueVariantsValue) other;
    return Objects.equals(disabled, that.disabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disabled);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueVariantsValue{" +
        "disabled=" + disabled +
        "}";
  }
}
