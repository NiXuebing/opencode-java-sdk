package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 配置Mode数据模型。
 *
 * @param build build。
 * @param plan plan。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigMode(
    @JsonProperty("build") AgentConfig build, @JsonProperty("plan") AgentConfig plan) {}
