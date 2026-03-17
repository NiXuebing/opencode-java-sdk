package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 文件内容补丁HunksItem数据模型。
 *
 * @param oldStart oldStart。
 * @param oldLines old行。
 * @param newStart newStart。
 * @param newLines new行。
 * @param lines 行列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContentPatchHunksItem(
    @JsonProperty("oldStart") Double oldStart,
    @JsonProperty("oldLines") Double oldLines,
    @JsonProperty("newStart") Double newStart,
    @JsonProperty("newLines") Double newLines,
    @JsonProperty("lines") List<String> lines) {}
