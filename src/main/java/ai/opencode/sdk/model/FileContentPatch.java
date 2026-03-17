package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 文件内容补丁数据模型。
 *
 * @param oldFileName old文件Name。
 * @param newFileName new文件Name。
 * @param oldHeader oldHeader。
 * @param newHeader newHeader。
 * @param hunks hunks列表。
 * @param index index。
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
