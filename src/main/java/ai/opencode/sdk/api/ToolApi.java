package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class ToolApi {
  private final ApiTransport transport;

  public ToolApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * List tool IDs Get a list of all available tool IDs, including both built-in tools and
   * dynamically registered tools.
   */
  public ToolIDs ids() {
    return ids(new ToolIdsRequest(null));
  }

  public ToolIDs ids(ToolIdsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/experimental/tool/ids", path, query, headers, body, ToolIDs.class);
  }

  /**
   * List tools Get a list of available tools with their JSON schema parameters for a specific
   * provider and model combination.
   */
  public ToolList list(ToolListRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.provider(), "request.provider");
    Objects.requireNonNull(request.model(), "request.model");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("provider", request.provider());
    query.put("model", request.model());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/experimental/tool", path, query, headers, body, ToolList.class);
  }
}
