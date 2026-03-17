package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

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
public record ProviderConfigOptions(
    @JsonProperty("apiKey") String apiKey,
    @JsonProperty("baseURL") String baseURL,
    @JsonProperty("enterpriseUrl") String enterpriseUrl,
    @JsonProperty("setCacheKey") Boolean setCacheKey,
    @JsonProperty("timeout") JsonNode timeout,
    @JsonProperty("chunkTimeout") Long chunkTimeout) {}
