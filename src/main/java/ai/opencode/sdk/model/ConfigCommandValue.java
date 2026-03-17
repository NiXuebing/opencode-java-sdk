package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 配置命令值数据模型。
 *
 * @param template 模板内容。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型 ID 或名称。
 * @param subtask 子任务标记。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigCommandValue(
    @JsonProperty("template") String template,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("subtask") Boolean subtask) {}
