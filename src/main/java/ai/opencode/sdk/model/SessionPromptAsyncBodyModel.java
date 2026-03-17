package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话提示词异步请求体模型数据模型。
 *
 * @param providerID 目标提供商 ID。
 * @param modelID 模型 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptAsyncBodyModel(
    @JsonProperty("providerID") String providerID, @JsonProperty("modelID") String modelID) {}
