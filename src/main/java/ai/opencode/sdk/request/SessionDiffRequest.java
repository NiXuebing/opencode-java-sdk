package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取会话差异接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param messageID 目标消息 ID。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionDiffRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("messageID") String messageID) {}
