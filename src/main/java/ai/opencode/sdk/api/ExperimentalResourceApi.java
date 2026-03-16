package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ExperimentalResourceApi {
  private final ApiTransport transport;

  public ExperimentalResourceApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Get MCP resources
 * Get all available MCP resources from connected servers. Optionally filter by name.
   */
  public Map<String, McpResource> list() {
    return list(new ExperimentalResourceListRequest(null));
  }

  public Map<String, McpResource> list(ExperimentalResourceListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/experimental/resource", path, query, headers, body, new TypeReference<Map<String, McpResource>>() {});
  }

}
