package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 符号来源数据模型。
 *
 * @param text 文本内容。
 * @param type 类型标识。
 * @param path 目标文件或目录路径。
 * @param range range。
 * @param name 名称。
 * @param kind kind。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SymbolSource(
    @JsonProperty("text") FilePartSourceText text,
    @JsonProperty("type") String type,
    @JsonProperty("path") String path,
    @JsonProperty("range") Range range,
    @JsonProperty("name") String name,
    @JsonProperty("kind") Long kind)
    implements FilePartSource {}
