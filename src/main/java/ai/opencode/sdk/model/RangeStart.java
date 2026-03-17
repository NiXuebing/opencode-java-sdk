package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 范围Start数据模型。
 *
 * @param line 行。
 * @param character 字符位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RangeStart(
    @JsonProperty("line") Double line, @JsonProperty("character") Double character) {}
