package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

/**
 * 权限请求数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param permission 权限配置。
 * @param patterns patterns列表。
 * @param metadata 元数据映射。
 * @param always always列表。
 * @param tool 工具。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRequest(
    @JsonProperty("id") String id,
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("permission") String permission,
    @JsonProperty("patterns") List<String> patterns,
    @JsonProperty("metadata") Map<String, JsonNode> metadata,
    @JsonProperty("always") List<String> always,
    @JsonProperty("tool") PermissionRequestTool tool) {}
