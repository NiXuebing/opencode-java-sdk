package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 列出命令接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommandListRequest(@JsonProperty("directory") String directory) {}
