package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话初始化请求体。
 *
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionInitBody(
    @JsonProperty("modelID") String modelID,
    @JsonProperty("providerID") String providerID,
    @JsonProperty("messageID") String messageID) {}
