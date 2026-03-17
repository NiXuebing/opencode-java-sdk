package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MCP状态需要客户端注册数据模型。
 *
 * @param status 当前状态。
 * @param error 错误信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record MCPStatusNeedsClientRegistration(
    @JsonProperty("status") String status, @JsonProperty("error") String error)
    implements MCPStatus {}
