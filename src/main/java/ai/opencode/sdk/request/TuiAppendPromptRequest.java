package ai.opencode.sdk.request;

import ai.opencode.sdk.model.TuiAppendPromptBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 追加 TUI 输入接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 追加 TUI 输入的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TuiAppendPromptRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") TuiAppendPromptBody body) {}
