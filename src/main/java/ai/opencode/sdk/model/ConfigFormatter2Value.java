package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 配置格式化器值数据模型。
 *
 * @param disabled 已禁用标记。
 * @param command 命令内容。
 * @param environment environment映射。
 * @param extensions extensions列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigFormatter2Value(
    @JsonProperty("disabled") Boolean disabled,
    @JsonProperty("command") List<String> command,
    @JsonProperty("environment") Map<String, String> environment,
    @JsonProperty("extensions") List<String> extensions) {}
