package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionRevertBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 撤回消息接口的请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 撤回消息对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionRevertRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionRevertBody body) {}
