package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模型能力输出数据模型。
 *
 * @param text 文本内容。
 * @param audio 是否支持音频。
 * @param image 是否支持图像。
 * @param video 是否支持视频。
 * @param pdf 是否支持 PDF。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilitiesOutput(
    @JsonProperty("text") Boolean text,
    @JsonProperty("audio") Boolean audio,
    @JsonProperty("image") Boolean image,
    @JsonProperty("video") Boolean video,
    @JsonProperty("pdf") Boolean pdf) {}
