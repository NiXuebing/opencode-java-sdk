package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

/**
 * 提供商配置选项数据模型。
 *
 * @param apiKey API 密钥。
 * @param baseURL 服务端基础地址。
 * @param enterpriseUrl 企业版地址。
 * @param setCacheKey 是否设置缓存键。
 * @param timeout 请求超时时间。
 * @param chunkTimeout 分块超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigOptions {
  @JsonProperty("apiKey")
  private final String apiKey;
  @JsonProperty("baseURL")
  private final String baseURL;
  @JsonProperty("enterpriseUrl")
  private final String enterpriseUrl;
  @JsonProperty("setCacheKey")
  private final Boolean setCacheKey;
  @JsonProperty("timeout")
  private final JsonNode timeout;
  @JsonProperty("chunkTimeout")
  private final Long chunkTimeout;

  /** 使用字段创建提供商配置选项。 */
  @JsonCreator
  public ProviderConfigOptions(
      @JsonProperty("apiKey") String apiKey,
      @JsonProperty("baseURL") String baseURL,
      @JsonProperty("enterpriseUrl") String enterpriseUrl,
      @JsonProperty("setCacheKey") Boolean setCacheKey,
      @JsonProperty("timeout") JsonNode timeout,
      @JsonProperty("chunkTimeout") Long chunkTimeout
  ) {
    this.apiKey = apiKey;
    this.baseURL = baseURL;
    this.enterpriseUrl = enterpriseUrl;
    this.setCacheKey = setCacheKey;
    this.timeout = timeout;
    this.chunkTimeout = chunkTimeout;
  }

  /**
   * 获取API Key。
   *
   * @return API 密钥。
   */
  public String apiKey() {
    return apiKey;
  }

  /**
   * 获取base地址。
   *
   * @return 服务端基础地址。
   */
  public String baseURL() {
    return baseURL;
  }

  /**
   * 获取企业版地址。
   *
   * @return 企业版地址。
   */
  public String enterpriseUrl() {
    return enterpriseUrl;
  }

  /**
   * 获取设置缓存Key。
   *
   * @return 是否设置缓存键。
   */
  public Boolean setCacheKey() {
    return setCacheKey;
  }

  /**
   * 获取timeout。
   *
   * @return 请求超时时间。
   */
  public JsonNode timeout() {
    return timeout;
  }

  /**
   * 获取chunk Timeout。
   *
   * @return 分块超时时间。
   */
  public Long chunkTimeout() {
    return chunkTimeout;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigOptions)) return false;
    ProviderConfigOptions that = (ProviderConfigOptions) other;
    return Objects.equals(apiKey, that.apiKey)
        && Objects.equals(baseURL, that.baseURL)
        && Objects.equals(enterpriseUrl, that.enterpriseUrl)
        && Objects.equals(setCacheKey, that.setCacheKey)
        && Objects.equals(timeout, that.timeout)
        && Objects.equals(chunkTimeout, that.chunkTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey, baseURL, enterpriseUrl, setCacheKey, timeout, chunkTimeout);
  }

  @Override
  public String toString() {
    return "ProviderConfigOptions{" +
        "apiKey=" + apiKey + "," +
        "baseURL=" + baseURL + "," +
        "enterpriseUrl=" + enterpriseUrl + "," +
        "setCacheKey=" + setCacheKey + "," +
        "timeout=" + timeout + "," +
        "chunkTimeout=" + chunkTimeout +
        "}";
  }
}
