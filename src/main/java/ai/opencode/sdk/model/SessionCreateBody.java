package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话创建请求体。
 *
 * @param parentID 父级消息 ID。
 * @param title 标题。
 * @param permission 权限配置。
 * @param workspaceID 工作区 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCreateBody(
    @JsonProperty("parentID") String parentID,
    @JsonProperty("title") String title,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("workspaceID") String workspaceID) {}
