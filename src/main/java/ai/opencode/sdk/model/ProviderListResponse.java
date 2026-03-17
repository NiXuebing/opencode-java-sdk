package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 提供商列表响应数据。
 *
 * @param all all列表。
 * @param defaultValue 默认映射。
 * @param connected 已连接列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponse(
    @JsonProperty("all") List<ProviderListResponseAllItem> all,
    @JsonProperty("default") Map<String, String> defaultValue,
    @JsonProperty("connected") List<String> connected) {}
