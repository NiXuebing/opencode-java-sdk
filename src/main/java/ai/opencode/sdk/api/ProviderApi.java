package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.ProviderAuthMethod;
import ai.opencode.sdk.model.ProviderListResponse;
import ai.opencode.sdk.request.ProviderAuthRequest;
import ai.opencode.sdk.request.ProviderListRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class ProviderApi {
  private final ApiTransport transport;
  private final ProviderOauthApi oauth;

  public ProviderApi(ApiTransport transport) {
    this.transport = transport;
    this.oauth = new ProviderOauthApi(transport);
  }

  /** 访问提供商 OAuth 子接口。 */
  public ProviderOauthApi oauth() {
    return oauth;
  }

  /** 列出提供商。 */
  public ProviderListResponse list() {
    return list(new ProviderListRequest(null));
  }

  /** 列出提供商。 可传入请求参数。 */
  public ProviderListResponse list(ProviderListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/provider", path, query, headers, body, ProviderListResponse.class);
  }

  /** 获取提供商认证信息。 */
  public Map<String, List<ProviderAuthMethod>> auth() {
    return auth(new ProviderAuthRequest(null));
  }

  /** 获取提供商认证信息。 可传入请求参数。 */
  public Map<String, List<ProviderAuthMethod>> auth(ProviderAuthRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/provider/auth",
        path,
        query,
        headers,
        body,
        new TypeReference<Map<String, List<ProviderAuthMethod>>>() {});
  }
}
