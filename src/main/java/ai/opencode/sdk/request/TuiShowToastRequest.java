package ai.opencode.sdk.request;

import ai.opencode.sdk.model.TuiShowToastBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 显示 TUI 提示接口的请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 显示 TUI 提示对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiShowToastRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") TuiShowToastBody body) {}
