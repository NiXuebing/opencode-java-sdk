package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 读取文件内容接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param path 目标文件或目录路径。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileReadRequest(
    @JsonProperty("directory") String directory, @JsonProperty("path") String path) {}
