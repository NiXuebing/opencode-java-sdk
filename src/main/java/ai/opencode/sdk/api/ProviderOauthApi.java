package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.ProviderAuthAuthorization;
import ai.opencode.sdk.request.ProviderOauthAuthorizeRequest;
import ai.opencode.sdk.request.ProviderOauthCallbackRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 封装提供商 OAuth 子接口相关的 HTTP 调用。 */
public final class ProviderOauthApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建提供商 OAuth 子接口封装。
   *
   * @param transport 底层传输器。
   */
  public ProviderOauthApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 发起提供商 OAuth 授权。
   *
   * @param request 发起提供商 OAuth 授权所需的请求参数，其中 providerID、body 为必填项。
   * @return 提供商 OAuth 授权结果。
   */
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

  /**
   * 处理提供商 OAuth 回调。
   *
   * @param request 处理提供商 OAuth 回调所需的请求参数，其中 providerID、body 为必填项。
   * @return 操作是否成功。
   */
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
