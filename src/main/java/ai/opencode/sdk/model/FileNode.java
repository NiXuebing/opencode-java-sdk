package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 文件Node数据模型。
 *
 * @param name 名称。
 * @param path 目标文件或目录路径。
 * @param absolute absolute。
 * @param type 类型标识。
 * @param ignored ignored标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileNode(
    @JsonProperty("name") String name,
    @JsonProperty("path") String path,
    @JsonProperty("absolute") String absolute,
    @JsonProperty("type") String type,
    @JsonProperty("ignored") Boolean ignored) {}
