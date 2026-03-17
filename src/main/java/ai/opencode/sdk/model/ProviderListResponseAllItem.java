package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 提供商列表响应所有项数据模型。
 *
 * @param api API。
 * @param name 名称。
 * @param env 环境变量列表。
 * @param id 唯一标识。
 * @param npm npm 包名。
 * @param models 模型映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItem(
    @JsonProperty("api") String api,
    @JsonProperty("name") String name,
    @JsonProperty("env") List<String> env,
    @JsonProperty("id") String id,
    @JsonProperty("npm") String npm,
    @JsonProperty("models") Map<String, ProviderListResponseAllItemModelsValue> models) {}
