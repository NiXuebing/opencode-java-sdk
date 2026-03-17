package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

/**
 * 配置LSP值数据模型。
 *
 * @param command 命令内容。
 * @param extensions extensions列表。
 * @param disabled 已禁用标记。
 * @param env env映射。
 * @param initialization initialization映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigLsp2Value2(
    @JsonProperty("command") List<String> command,
    @JsonProperty("extensions") List<String> extensions,
    @JsonProperty("disabled") Boolean disabled,
    @JsonProperty("env") Map<String, String> env,
    @JsonProperty("initialization") Map<String, JsonNode> initialization) {}
