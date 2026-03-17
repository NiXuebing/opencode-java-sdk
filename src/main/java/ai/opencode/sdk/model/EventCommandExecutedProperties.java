package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 命令已执行事件属性。
 *
 * @param name 名称。
 * @param sessionID 目标会话 ID。
 * @param arguments 参数内容。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventCommandExecutedProperties(
    @JsonProperty("name") String name,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("arguments") String arguments,
    @JsonProperty("messageID") String messageID) {}
