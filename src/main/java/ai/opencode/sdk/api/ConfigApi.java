package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Config;
import ai.opencode.sdk.model.ConfigProvidersResponse;
import ai.opencode.sdk.request.ConfigGetRequest;
import ai.opencode.sdk.request.ConfigProvidersRequest;
import ai.opencode.sdk.request.ConfigUpdateRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 封装配置接口相关的 HTTP 调用。 */
public final class ConfigApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建配置接口封装。
   *
   * @param transport 底层传输器。
   */
  public ConfigApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取配置。
   *
   * @return 配置。
   */
  public Config get() {
    return get(new ConfigGetRequest(null));
  }

  /**
   * 获取配置。
   *
   * @param request 获取配置所需的请求参数。
   * @return 配置。
   */
  public Config get(ConfigGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/config", path, query, headers, body, Config.class);
  }

  /**
   * 更新配置。
   *
   * @param request 更新配置所需的请求参数，其中 body 为必填项。
   * @return 配置结果。
   */
  public Config update(ConfigUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PATCH", "/config", path, query, headers, body, Config.class);
  }

  /**
   * 获取提供商配置。
   *
   * @return 提供商配置。
   */
  public ConfigProvidersResponse providers() {
    return providers(new ConfigProvidersRequest(null));
  }

  /**
   * 获取提供商配置。
   *
   * @param request 获取提供商配置所需的请求参数。
   * @return 提供商配置。
   */
  public ConfigProvidersResponse providers(ConfigProvidersRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/config/providers", path, query, headers, body, ConfigProvidersResponse.class);
  }
}
