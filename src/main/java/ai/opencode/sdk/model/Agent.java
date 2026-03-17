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
 * @param mode mode。
 * @param nativeValue native标记。
 * @param hidden hidden标记。
 * @param topP topP。
 * @param temperature temperature。
 * @param color color。
 * @param permission 权限配置。
 * @param model 模型配置。
 * @param variant 变体名称。
 * @param prompt 提示词。
 * @param options options映射。
 * @param steps steps。
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
