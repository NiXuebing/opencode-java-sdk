package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商配置模型值成本数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cacheRead 缓存读取量。
 * @param cacheWrite 缓存写入量。
 * @param contextOver200k 超长上下文成本。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderConfigModelsValueCost(
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("cache_read") Double cacheRead,
    @JsonProperty("cache_write") Double cacheWrite,
    @JsonProperty("context_over_200k")
        ProviderConfigModelsValueCostContextOver200k contextOver200k) {}
