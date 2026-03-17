package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 检索文本响应Item数据模型。
 *
 * @param path 目标文件或目录路径。
 * @param lines 行。
 * @param lineNumber 行number。
 * @param absoluteOffset absoluteoffset。
 * @param submatches 子匹配列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindTextResponseItem(
    @JsonProperty("path") FindTextResponseItemPath path,
    @JsonProperty("lines") FindTextResponseItemLines lines,
    @JsonProperty("line_number") Double lineNumber,
    @JsonProperty("absolute_offset") Double absoluteOffset,
    @JsonProperty("submatches") List<FindTextResponseItemSubmatchesItem> submatches) {}
