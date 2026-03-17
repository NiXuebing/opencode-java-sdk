package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 权限Rule数据模型。
 *
 * @param permission 权限配置。
 * @param pattern 匹配模式。
 * @param action action。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRule(
    @JsonProperty("permission") String permission,
    @JsonProperty("pattern") String pattern,
    @JsonProperty("action") PermissionAction action) {}
