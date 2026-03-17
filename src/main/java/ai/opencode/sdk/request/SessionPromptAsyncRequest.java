package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionPromptAsyncBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 异步发送提示接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 异步发送提示的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptAsyncRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionPromptAsyncBody body) {}
