package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

public final class McpApi {
  private final ApiTransport transport;

  public McpApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Get MCP status Get the status of all Model Context Protocol (MCP) servers. */
  public Map<String, MCPStatus> status() {
    return status(new McpStatusRequest(null));
  }

  public Map<String, MCPStatus> status(McpStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/mcp", path, query, headers, body, new TypeReference<Map<String, MCPStatus>>() {});
  }

  /** Add MCP server Dynamically add a new Model Context Protocol (MCP) server to the system. */
  public Map<String, MCPStatus> add(McpAddRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/mcp", path, query, headers, body, new TypeReference<Map<String, MCPStatus>>() {});
  }
}
