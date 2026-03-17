package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 检索文本响应Item子匹配Item数据模型。
 *
 * @param match 匹配。
 * @param start 分页起始位置或游标。
 * @param end end。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindTextResponseItemSubmatchesItem(
    @JsonProperty("match") FindTextResponseItemSubmatchesItemMatch match,
    @JsonProperty("start") Double start,
    @JsonProperty("end") Double end) {}
