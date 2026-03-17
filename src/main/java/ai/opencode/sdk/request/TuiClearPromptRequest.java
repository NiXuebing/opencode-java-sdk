package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 清空 TUI 输入接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiClearPromptRequest(@JsonProperty("directory") String directory) {}
