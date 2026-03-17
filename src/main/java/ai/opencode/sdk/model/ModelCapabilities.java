package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 模型Capabilities数据模型。
 *
 * @param temperature temperature标记。
 * @param reasoning reasoning标记。
 * @param attachment attachment标记。
 * @param toolcall toolcall标记。
 * @param input 输入。
 * @param output 输出。
 * @param interleaved interleaved。
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
