package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.request.AuthSetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 认证接口的 HTTP 客户端封装。 */
public final class AuthApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建认证接口封装。
   *
   * @param transport 底层传输器。
   */
  public AuthApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 设置提供商认证。
   *
   * @param request 设置提供商认证所需的请求参数，其中 providerID、body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean set(AuthSetRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.providerID(), "request.providerID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "PUT", "/auth/{providerID}", path, query, headers, body, Boolean.class);
  }
}
