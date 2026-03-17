package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionSummarizeBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 总结会话接口的请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 总结会话对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionSummarizeRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") SessionSummarizeBody body) {}
