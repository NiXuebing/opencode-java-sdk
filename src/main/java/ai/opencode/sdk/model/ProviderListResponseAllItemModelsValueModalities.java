package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 提供商列表响应所有项模型值模态数据模型。
 *
 * @param input 输入列表。
 * @param output 输出列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderListResponseAllItemModelsValueModalities(
    @JsonProperty("input") List<String> input, @JsonProperty("output") List<String> output) {}
