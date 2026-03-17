package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息已移除事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventMessageRemovedProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("messageID") String messageID) {}
