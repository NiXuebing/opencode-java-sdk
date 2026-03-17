package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 模型数据模型。
 *
 * @param id 唯一标识。
 * @param providerID 目标提供商 ID。
 * @param api API。
 * @param name 名称。
 * @param family family。
 * @param capabilities capabilities。
 * @param cost 成本。
 * @param limit 返回结果数量上限。
 * @param status 当前状态。
 * @param options options映射。
 * @param headers 自定义请求头集合。
 * @param releaseDate releasedate。
 * @param variants variants映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Model(
    @JsonProperty("id") String id,
    @JsonProperty("providerID") String providerID,
    @JsonProperty("api") ModelApi api,
    @JsonProperty("name") String name,
    @JsonProperty("family") String family,
    @JsonProperty("capabilities") ModelCapabilities capabilities,
    @JsonProperty("cost") ModelCost cost,
    @JsonProperty("limit") ModelLimit limit,
    @JsonProperty("status") String status,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("release_date") String releaseDate,
    @JsonProperty("variants") Map<String, Map<String, JsonNode>> variants) {}
