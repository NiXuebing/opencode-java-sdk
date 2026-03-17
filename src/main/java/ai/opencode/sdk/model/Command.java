package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 命令数据模型。
 *
 * @param name 名称。
 * @param description 描述信息。
 * @param agent 代理名称。
 * @param model 模型 ID 或名称。
 * @param source 来源。
 * @param template 模板内容。
 * @param subtask 子任务标记。
 * @param hints 提示列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Command(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("agent") String agent,
    @JsonProperty("model") String model,
    @JsonProperty("source") String source,
    @JsonProperty("template") String template,
    @JsonProperty("subtask") Boolean subtask,
    @JsonProperty("hints") List<String> hints) {}
