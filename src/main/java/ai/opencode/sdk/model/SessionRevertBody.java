package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话撤回请求体。
 *
 * @param messageID 目标消息 ID。
 * @param partID 片段 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionRevertBody(
    @JsonProperty("messageID") String messageID, @JsonProperty("partID") String partID) {}
