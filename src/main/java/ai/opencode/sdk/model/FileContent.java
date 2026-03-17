package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件内容数据模型。
 *
 * @param type 类型标识。
 * @param content 正文内容。
 * @param diff 差异。
 * @param patch 补丁。
 * @param encoding encoding。
 * @param mimeType mime类型。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileContent(
    @JsonProperty("type") String type,
    @JsonProperty("content") String content,
    @JsonProperty("diff") String diff,
    @JsonProperty("patch") FileContentPatch patch,
    @JsonProperty("encoding") String encoding,
    @JsonProperty("mimeType") String mimeType) {}
