package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件数据模型。
 *
 * @param path 目标文件或目录路径。
 * @param added added。
 * @param removed 已移除。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record File(
    @JsonProperty("path") String path,
    @JsonProperty("added") Long added,
    @JsonProperty("removed") Long removed,
    @JsonProperty("status") String status) {}
