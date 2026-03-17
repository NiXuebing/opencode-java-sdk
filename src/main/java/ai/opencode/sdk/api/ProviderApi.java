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

/** 提供商接口的 HTTP 客户端封装。 */
public final class ProviderApi {
  private final ApiTransport transport;
  private final ProviderOauthApi oauth;

  /**
   * 使用底层传输器创建提供商接口封装。
   *
   * @param transport 底层传输器。
   */
  public ProviderApi(ApiTransport transport) {
    this.transport = transport;
    this.oauth = new ProviderOauthApi(transport);
  }

  /**
   * 获取提供商 OAuth 子接口。
   *
   * @return 提供商 OAuth 子接口实例。
   */
  public ProviderOauthApi oauth() {
    return oauth;
  }

  /**
   * 列出提供商。
   *
   * @return 提供商列表。
   */
  public ProviderListResponse list() {
    return list(new ProviderListRequest(null));
  }

  /**
   * 列出提供商。
   *
   * @param request 列出提供商所需的请求参数。
   * @return 提供商列表。
   */
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

  /**
   * 获取提供商认证信息。
   *
   * @return 提供商认证信息。
   */
  public Map<String, List<ProviderAuthMethod>> auth() {
    return auth(new ProviderAuthRequest(null));
  }

  /**
   * 获取提供商认证信息。
   *
   * @param request 获取提供商认证信息所需的请求参数。
   * @return 提供商认证信息。
   */
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
