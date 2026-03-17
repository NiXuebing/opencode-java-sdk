package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 助手消息数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param role 消息角色。
 * @param time 时间。
 * @param error 错误信息。
 * @param parentID 父级消息 ID。
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 * @param mode 运行模式。
 * @param agent 代理名称。
 * @param path 目标文件或目录路径。
 * @param summary 是否为摘要内容。
 * @param cost 成本。
 * @param tokens 令牌。
 * @param structured 结构化输出内容。
 * @param variant 变体名称。
 * @param finish 结束原因。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AssistantMessage(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("role") String role,
    @JsonProperty("time") AssistantMessageTime time,
    @JsonProperty("error") AssistantMessageError error,
    @JsonProperty("parentID") String parentID,
    @JsonProperty("modelID") String modelID,
    @JsonProperty("providerID") String providerID,
    @JsonProperty("mode") String mode,
    @JsonProperty("agent") String agent,
    @JsonProperty("path") AssistantMessagePath path,
    @JsonProperty("summary") Boolean summary,
    @JsonProperty("cost") Double cost,
    @JsonProperty("tokens") AssistantMessageTokens tokens,
    @JsonProperty("structured") JsonNode structured,
    @JsonProperty("variant") String variant,
    @JsonProperty("finish") String finish)
    implements Message {}
