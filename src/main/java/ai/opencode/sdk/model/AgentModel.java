package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 代理模型数据模型。
 *
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentModel(
    @JsonProperty("modelID") String modelID, @JsonProperty("providerID") String providerID) {}
