package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.ProviderAuthAuthorization;
import ai.opencode.sdk.request.ProviderOauthAuthorizeRequest;
import ai.opencode.sdk.request.ProviderOauthCallbackRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class ProviderOauthApi {
  private final ApiTransport transport;

  public ProviderOauthApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 发起提供商 OAuth 授权。 可传入请求参数。 */
  public ProviderAuthAuthorization authorize(ProviderOauthAuthorizeRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.providerID(), "request.providerID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST",
        "/provider/{providerID}/oauth/authorize",
        path,
        query,
        headers,
        body,
        ProviderAuthAuthorization.class);
  }

  /** 处理提供商 OAuth 回调。 可传入请求参数。 */
  public Boolean callback(ProviderOauthCallbackRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.providerID(), "request.providerID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/provider/{providerID}/oauth/callback", path, query, headers, body, Boolean.class);
  }
}
