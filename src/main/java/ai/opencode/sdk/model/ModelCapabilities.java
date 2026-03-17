package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 模型能力数据模型。
 *
 * @param temperature 采样温度。
 * @param reasoning 是否支持推理。
 * @param attachment 是否支持附件。
 * @param toolcall 是否支持工具调用。
 * @param input 输入。
 * @param output 输出。
 * @param interleaved 交错。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilities(
    @JsonProperty("temperature") Boolean temperature,
    @JsonProperty("reasoning") Boolean reasoning,
    @JsonProperty("attachment") Boolean attachment,
    @JsonProperty("toolcall") Boolean toolcall,
    @JsonProperty("input") ModelCapabilitiesInput input,
    @JsonProperty("output") ModelCapabilitiesOutput output,
    @JsonProperty("interleaved") JsonNode interleaved) {}
