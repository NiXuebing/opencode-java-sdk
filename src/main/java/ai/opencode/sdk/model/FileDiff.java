package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件差异数据模型。
 *
 * @param file 文件信息。
 * @param before 变更前内容。
 * @param after 变更后内容。
 * @param additions 新增行数。
 * @param deletions 删除行数。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileDiff(
    @JsonProperty("file") String file,
    @JsonProperty("before") String before,
    @JsonProperty("after") String after,
    @JsonProperty("additions") Double additions,
    @JsonProperty("deletions") Double deletions,
    @JsonProperty("status") String status) {}
