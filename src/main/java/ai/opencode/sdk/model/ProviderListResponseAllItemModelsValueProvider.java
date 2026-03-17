package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 提供商列表响应所有项模型值提供商数据模型。
 *
 * @param npm npm 包名。
 * @param api API。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueProvider(
    @JsonProperty("npm") String npm, @JsonProperty("api") String api) {}
