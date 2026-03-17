package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 会话提示词Async请求体。
 *
 * @param messageID 目标消息 ID。
 * @param model 模型配置。
 * @param agent 代理名称或代理配置。
 * @param noReply 是否不等待助手回复。
 * @param tools 工具开关配置。
 * @param format 输出格式配置。
 * @param system 系统提示词。
 * @param variant 变体名称。
 * @param parts 片段列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionPromptAsyncBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("model") SessionPromptAsyncBodyModel model,
    @JsonProperty("agent") String agent,
    @JsonProperty("noReply") Boolean noReply,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("format") OutputFormat format,
    @JsonProperty("system") String system,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionPromptAsyncBodyPartsItem> parts) {}
