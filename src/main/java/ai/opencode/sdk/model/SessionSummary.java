package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 会话摘要数据模型。
 *
 * @param additions 新增行数。
 * @param deletions 删除行数。
 * @param files 文件数量。
 * @param diffs 差异列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionSummary(
    @JsonProperty("additions") Double additions,
    @JsonProperty("deletions") Double deletions,
    @JsonProperty("files") Double files,
    @JsonProperty("diffs") List<FileDiff> diffs) {}
