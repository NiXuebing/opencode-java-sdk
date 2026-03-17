package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 问题请求工具数据模型。
 *
 * @param messageID 目标消息 ID。
 * @param callID 调用 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionRequestTool(
    @JsonProperty("messageID") String messageID, @JsonProperty("callID") String callID) {}
