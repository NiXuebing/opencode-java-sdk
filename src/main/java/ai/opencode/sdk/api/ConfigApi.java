package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ConfigApi {
  private final ApiTransport transport;

  public ConfigApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Get configuration
 * Retrieve the current OpenCode configuration settings and preferences.
   */
  public Config get() {
    return get(new ConfigGetRequest(null));
  }

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
 * Update configuration
 * Update OpenCode configuration settings and preferences.
   */
  public Config update(ConfigUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PATCH", "/config", path, query, headers, body, Config.class);
  }

  /**
 * List config providers
 * Get a list of all configured AI providers and their default models.
   */
  public ConfigProvidersResponse providers() {
    return providers(new ConfigProvidersRequest(null));
  }

  public ConfigProvidersResponse providers(ConfigProvidersRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/config/providers", path, query, headers, body, ConfigProvidersResponse.class);
  }

}
