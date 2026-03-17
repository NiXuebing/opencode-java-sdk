package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 助手消息时间数据模型。
 *
 * @param created 已创建。
 * @param completed 已完成。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessageTime(
    @JsonProperty("created") Double created, @JsonProperty("completed") Double completed) {}
