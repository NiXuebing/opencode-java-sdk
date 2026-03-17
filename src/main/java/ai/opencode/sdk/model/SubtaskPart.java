package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 子任务片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param prompt 提示词。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型配置。
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubtaskPart(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("messageID") String messageID,
    @JsonProperty("type") String type,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SubtaskPartModel model,
    @JsonProperty("command") String command)
    implements Part {}
