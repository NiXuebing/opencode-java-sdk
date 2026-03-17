package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 工具状态已完成时间数据模型。
 *
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 * @param compacted 压缩完成时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolStateCompletedTime(
    @JsonProperty("start") Double start,
    @JsonProperty("end") Double end,
    @JsonProperty("compacted") Double compacted) {}
