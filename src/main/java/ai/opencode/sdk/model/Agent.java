package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * 代理数据模型。
 *
 * @param name 名称。
 * @param description 描述信息。
 * @param mode 运行模式。
 * @param nativeValue 是否使用原生能力。
 * @param hidden 是否隐藏。
 * @param topP Top P 采样参数。
 * @param temperature 采样温度。
 * @param color 颜色标识。
 * @param permission 权限配置。
 * @param model 模型配置。
 * @param variant 变体名称。
 * @param prompt 提示词。
 * @param options 扩展选项映射。
 * @param steps 步骤数上限。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Agent(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("mode") String mode,
    @JsonProperty("native") Boolean nativeValue,
    @JsonProperty("hidden") Boolean hidden,
    @JsonProperty("topP") Double topP,
    @JsonProperty("temperature") Double temperature,
    @JsonProperty("color") String color,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("model") AgentModel model,
    @JsonProperty("variant") String variant,
    @JsonProperty("prompt") String prompt,
    @JsonProperty("options") Map<String, JsonNode> options,
    @JsonProperty("steps") Long steps) {}
