package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商配置模型值提供商数据模型。
 *
 * @param npm npm 包名。
 * @param api API。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueProvider {
  @JsonProperty("npm")
  private final String npm;
  @JsonProperty("api")
  private final String api;

  /** 使用字段创建提供商配置模型值提供商。 */
  @JsonCreator
  public ProviderConfigModelsValueProvider(
      @JsonProperty("npm") String npm,
      @JsonProperty("api") String api
  ) {
    this.npm = npm;
    this.api = api;
  }

  /**
   * 获取npm。
   *
   * @return npm 包名。
   */
  public String npm() {
    return npm;
  }

  /**
   * 获取API。
   *
   * @return API。
   */
  public String api() {
    return api;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValueProvider)) return false;
    ProviderConfigModelsValueProvider that = (ProviderConfigModelsValueProvider) other;
    return Objects.equals(npm, that.npm)
        && Objects.equals(api, that.api);
  }

  @Override
  public int hashCode() {
    return Objects.hash(npm, api);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueProvider{" +
        "npm=" + npm + "," +
        "api=" + api +
        "}";
  }
}
