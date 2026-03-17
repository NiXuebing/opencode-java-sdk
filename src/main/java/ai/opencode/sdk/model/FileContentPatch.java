package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 文件内容补丁数据模型。
 *
 * @param oldFileName 旧文件Name。
 * @param newFileName new文件Name。
 * @param oldHeader 旧标题头。
 * @param newHeader new标题头。
 * @param hunks 代码块列表。
 * @param index 索引。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContentPatch(
    @JsonProperty("oldFileName") String oldFileName,
    @JsonProperty("newFileName") String newFileName,
    @JsonProperty("oldHeader") String oldHeader,
    @JsonProperty("newHeader") String newHeader,
    @JsonProperty("hunks") List<FileContentPatchHunksItem> hunks,
    @JsonProperty("index") String index) {}
