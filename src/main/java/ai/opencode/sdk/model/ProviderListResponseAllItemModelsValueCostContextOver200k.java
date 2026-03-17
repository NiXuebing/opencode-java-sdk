package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商列表响应所有项模型值成本超长上下文数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cacheRead 缓存读取量。
 * @param cacheWrite 缓存写入量。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueCostContextOver200k(
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output,
    @JsonProperty("cache_read") Double cacheRead,
    @JsonProperty("cache_write") Double cacheWrite) {}
