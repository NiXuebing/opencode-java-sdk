package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 事件消息片段增量属性。
 *
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 * @param field field。
 * @param delta 增量。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventMessagePartDeltaProperties(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("partID") String partID,
    @JsonProperty("field") String field,
    @JsonProperty("delta") String delta) {}
