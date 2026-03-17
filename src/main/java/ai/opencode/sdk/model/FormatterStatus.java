package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 格式化器状态。
 *
 * @param name 名称。
 * @param extensions 扩展名列表。
 * @param enabled 是否启用。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FormatterStatus(
    @JsonProperty("name") String name,
    @JsonProperty("extensions") List<String> extensions,
    @JsonProperty("enabled") Boolean enabled) {}
