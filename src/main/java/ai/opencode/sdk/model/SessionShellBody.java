package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话Shell请求体。
 *
 * @param agent 代理名称或代理配置。
 * @param model 模型配置。
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionShellBody(
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SessionShellBodyModel model,
    @JsonProperty("command") String command) {}
