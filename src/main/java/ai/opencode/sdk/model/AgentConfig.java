package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 代理配置。
 *
 * @param model 模型 ID 或名称。
 * @param variant 变体名称。
 * @param temperature 采样温度。
 * @param topP Top P 采样参数。
 * @param prompt 提示词。
 * @param tools 工具开关配置。
 * @param disable 是否禁用。
 * @param description 描述信息。
 * @param mode 运行模式。
 * @param hidden 是否隐藏。
 * @param options 扩展选项映射。
 * @param color 颜色标识。
 * @param steps 步骤数上限。
 * @param maxSteps 最大步骤数。
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
