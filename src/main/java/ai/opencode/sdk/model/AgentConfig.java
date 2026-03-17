package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 代理配置。
 *
 * @param model 模型配置。
 * @param variant 变体名称。
 * @param temperature temperature。
 * @param topP topp。
 * @param prompt 提示词。
 * @param tools 工具开关配置。
 * @param disable disable标记。
 * @param description 描述信息。
 * @param mode mode。
 * @param hidden hidden标记。
 * @param options options映射。
 * @param color color。
 * @param steps steps。
 * @param maxSteps maxSteps。
 * @param permission 权限配置。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AgentConfig(
    @JsonProperty("model") String model,
    @JsonProperty("variant") String variant,
    @JsonProperty("temperature") Double temperature,
    @JsonProperty("top_p") Double topP,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("disable") Boolean disable,
    @JsonProperty("description") String description,
    @JsonProperty("mode") String mode,
    @JsonProperty("hidden") Boolean hidden,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("color") String color,
    @JsonProperty("steps") Long steps,
    @JsonProperty("maxSteps") Long maxSteps,
    @JsonProperty("permission") PermissionConfig permission) {}
