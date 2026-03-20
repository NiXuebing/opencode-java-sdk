package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.request.PermissionRespondRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 权限接口的 HTTP 客户端封装。 */
public final class PermissionApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建权限接口封装。
   *
   * @param transport 底层传输器。
   */
  public PermissionApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 响应权限请求。
   *
   * @param request 响应权限请求所需的请求参数，其中 sessionID、permissionID、body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean respond(PermissionRespondRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.permissionID(), "request.permissionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("permissionID", request.permissionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/permissions/{permissionID}", path, query, headers, body, Boolean.class);
  }

}
