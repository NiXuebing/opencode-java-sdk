package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 事件会话错误属性。
 *
 * @param sessionID 目标会话 ID。
 * @param error 错误信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventSessionErrorProperties(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("error") EventSessionErrorPropertiesError error) {}
