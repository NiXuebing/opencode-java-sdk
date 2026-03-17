package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取 LSP 状态接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record LspStatusRequest(@JsonProperty("directory") String directory) {}
