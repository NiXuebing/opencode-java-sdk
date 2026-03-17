package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 代理片段来源数据模型。
 *
 * @param value 实际值。
 * @param start 分页起始位置或游标。
 * @param end 结束位置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentPartSource(
    @JsonProperty("value") String value,
    @JsonProperty("start") Long start,
    @JsonProperty("end") Long end) {}
