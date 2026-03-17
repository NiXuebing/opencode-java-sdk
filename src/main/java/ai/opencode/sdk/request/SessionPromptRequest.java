package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionPromptBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 发送会话提示接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 发送会话提示的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionPromptBody body) {}
