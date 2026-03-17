package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话总结请求体。
 *
 * @param providerID 目标提供商 ID。
 * @param modelID 模型 ID。
 * @param auto auto标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionSummarizeBody(
    @JsonProperty("providerID") String providerID,
    @JsonProperty("modelID") String modelID,
    @JsonProperty("auto") Boolean auto) {}
