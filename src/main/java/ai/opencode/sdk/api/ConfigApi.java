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

public final class ConfigApi {
  private final ApiTransport transport;

  public ConfigApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取配置。 */
  public Config get() {
    return get(new ConfigGetRequest(null));
  }

  /** 获取配置。 可传入请求参数。 */
  public Config get(ConfigGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/config", path, query, headers, body, Config.class);
  }

  /** 更新配置。 可传入请求参数。 */
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

  /** 获取提供商配置。 */
  public ConfigProvidersResponse providers() {
    return providers(new ConfigProvidersRequest(null));
  }

  /** 获取提供商配置。 可传入请求参数。 */
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
