package ai.opencode.sdk.request;

import ai.opencode.sdk.model.McpAddBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 添加 MCP 服务接口的请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 添加 MCP 服务对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpAddRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") McpAddBody body) {}
