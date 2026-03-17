package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 提供商配置模型值Modalities数据模型。
 *
 * @param input 输入列表。
 * @param output 输出列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderConfigModelsValueModalities(
    @JsonProperty("input") List<String> input, @JsonProperty("output") List<String> output) {}
