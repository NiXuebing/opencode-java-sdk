package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 提供商列表响应AllItem模型值数据模型。
 *
 * @param id 唯一标识。
 * @param name 名称。
 * @param family family。
 * @param releaseDate releasedate。
 * @param attachment attachment标记。
 * @param reasoning reasoning标记。
 * @param temperature temperature标记。
 * @param toolCall 工具call标记。
 * @param interleaved interleaved。
 * @param cost 成本。
 * @param limit 返回结果数量上限。
 * @param modalities modalities。
 * @param experimental 实验性标记。
 * @param status 当前状态。
 * @param options options映射。
 * @param headers 自定义请求头集合。
 * @param provider 提供商标识。
 * @param variants variants映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValue(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("family") String family,
    @JsonProperty("release_date") String releaseDate,
    @JsonProperty("attachment") Boolean attachment,
    @JsonProperty("reasoning") Boolean reasoning,
    @JsonProperty("temperature") Boolean temperature,
    @JsonProperty("tool_call") Boolean toolCall,
    @JsonProperty("interleaved") JsonNode interleaved,
    @JsonProperty("cost") ProviderListResponseAllItemModelsValueCost cost,
    @JsonProperty("limit") ProviderListResponseAllItemModelsValueLimit limit,
    @JsonProperty("modalities") ProviderListResponseAllItemModelsValueModalities modalities,
    @JsonProperty("experimental") Boolean experimental,
    @JsonProperty("status") String status,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("provider") ProviderListResponseAllItemModelsValueProvider provider,
    @JsonProperty("variants") Map<String, Map<String, JsonNode>> variants) {}
