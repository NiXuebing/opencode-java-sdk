package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * 用户消息数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param role 消息角色。
 * @param time 时间。
 * @param format 输出格式配置。
 * @param summary 摘要内容。
 * @param agent 代理名称。
 * @param model 模型配置。
 * @param system 系统提示词。
 * @param tools 工具开关配置。
 * @param variant 变体名称。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserMessage(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("role") String role,
    @JsonProperty("time") UserMessageTime time,
    @JsonProperty("format") OutputFormat format,
    @JsonProperty("summary") UserMessageSummary summary,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") UserMessageModel model,
    @JsonProperty("system") String system,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("variant") String variant)
    implements Message {}
