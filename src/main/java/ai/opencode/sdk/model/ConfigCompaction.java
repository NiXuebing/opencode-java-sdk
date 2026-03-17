package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 配置压缩数据模型。
 *
 * @param auto auto标记。
 * @param prune prune标记。
 * @param reserved reserved。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigCompaction(
    @JsonProperty("auto") Boolean auto,
    @JsonProperty("prune") Boolean prune,
    @JsonProperty("reserved") Long reserved) {}
