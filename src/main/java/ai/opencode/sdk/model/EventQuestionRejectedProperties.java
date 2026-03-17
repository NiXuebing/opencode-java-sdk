package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 问题已拒绝事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param requestID 请求 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventQuestionRejectedProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("requestID") String requestID) {}
