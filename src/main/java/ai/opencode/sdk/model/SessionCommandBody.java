package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 会话命令请求体。
 *
 * @param messageID 目标消息 ID。
 * @param agent 代理名称或代理配置。
 * @param model 模型配置。
 * @param arguments arguments。
 * @param command 命令内容。
 * @param variant 变体名称。
 * @param parts 片段列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCommandBody(
    @JsonProperty("messageID") String messageID,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("arguments") String arguments,
    @JsonProperty("command") String command,
    @JsonProperty("variant") String variant,
    @JsonProperty("parts") List<SessionCommandBodyPartsItem> parts) {}
