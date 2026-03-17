package ai.opencode.sdk.request;

import ai.opencode.sdk.model.PermissionRespondBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应权限请求接口的请求参数。
 *
 * @param sessionID 目标会话 ID。
 * @param permissionID 待响应的权限请求 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 响应权限请求对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRespondRequest(
    @JsonProperty("sessionID") String sessionID,
    @JsonProperty("permissionID") String permissionID,
    @JsonProperty("directory") String directory,
    @JsonProperty("body") PermissionRespondBody body) {}
