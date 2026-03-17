package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模型限制数据模型。
 *
 * @param context 上下文。
 * @param input 输入。
 * @param output 输出。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelLimit(
    @JsonProperty("context") Double context,
    @JsonProperty("input") Double input,
    @JsonProperty("output") Double output) {}
