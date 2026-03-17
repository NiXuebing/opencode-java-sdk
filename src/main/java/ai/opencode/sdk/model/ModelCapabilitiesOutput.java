package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模型Capabilities输出数据模型。
 *
 * @param text 文本内容。
 * @param audio audio标记。
 * @param image image标记。
 * @param video video标记。
 * @param pdf pdf标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilitiesOutput(
    @JsonProperty("text") Boolean text,
    @JsonProperty("audio") Boolean audio,
    @JsonProperty("image") Boolean image,
    @JsonProperty("video") Boolean video,
    @JsonProperty("pdf") Boolean pdf) {}
