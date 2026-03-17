package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话状态事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventSessionStatusProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("status") SessionStatus status) {}
