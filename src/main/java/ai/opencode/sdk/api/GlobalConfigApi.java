package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class GlobalConfigApi {
  private final ApiTransport transport;

  public GlobalConfigApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Get global configuration
 * Retrieve the current global OpenCode configuration settings and preferences.
   */
  public Config get() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/global/config", path, query, headers, body, Config.class);
  }

  /**
 * Update global configuration
 * Update global OpenCode configuration settings and preferences.
   */
  public Config update(GlobalConfigUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PATCH", "/global/config", path, query, headers, body, Config.class);
  }

}
