package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 配置提供商响应数据。
 *
 * @param providers 提供商列表。
 * @param defaultValue 默认映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigProvidersResponse {
  @JsonProperty("providers")
  private final List<Provider> providers;
  @JsonProperty("default")
  private final Map<String, String> defaultValue;

  /** 使用字段创建配置提供商响应。 */
  @JsonCreator
  public ConfigProvidersResponse(
      @JsonProperty("providers") List<Provider> providers,
      @JsonProperty("default") Map<String, String> defaultValue
  ) {
    this.providers = providers;
    this.defaultValue = defaultValue;
  }

  /**
   * 获取提供商。
   *
   * @return 提供商列表。
   */
  public List<Provider> providers() {
    return providers;
  }

  /**
   * 获取默认。
   *
   * @return 默认映射。
   */
  public Map<String, String> defaultValue() {
    return defaultValue;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigProvidersResponse)) return false;
    ConfigProvidersResponse that = (ConfigProvidersResponse) other;
    return Objects.equals(providers, that.providers)
        && Objects.equals(defaultValue, that.defaultValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(providers, defaultValue);
  }

  @Override
  public String toString() {
    return "ConfigProvidersResponse{" +
        "providers=" + providers + "," +
        "defaultValue=" + defaultValue +
        "}";
  }
}
