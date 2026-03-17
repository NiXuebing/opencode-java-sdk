package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 子任务片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param prompt 提示词。
 * @param description 描述信息。
 * @param agent 代理名称或代理配置。
 * @param model 模型配置。
 * @param command 命令内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubtaskPartInput(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") SubtaskPartInputModel model,
    @JsonProperty("command") String command)
    implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {}
