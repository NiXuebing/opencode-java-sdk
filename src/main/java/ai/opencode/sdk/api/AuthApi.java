package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.request.AuthSetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class AuthApi {
  private final ApiTransport transport;

  public AuthApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 设置提供商认证。 可传入请求参数。 */
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
