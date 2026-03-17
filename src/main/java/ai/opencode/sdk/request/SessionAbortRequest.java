package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 中止会话接口请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionAbortRequest(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("directory") String directory) {}
