package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class McpApi {
  private final ApiTransport transport;
  private final McpAuthApi auth;

  public McpApi(ApiTransport transport) {
    this.transport = transport;
    this.auth = new McpAuthApi(transport);

  }

  public McpAuthApi auth() {
    return auth;
  }

  /**
 * Get MCP status
 * Get the status of all Model Context Protocol (MCP) servers.
   */
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
    return transport.execute("GET", "/mcp", path, query, headers, body, new TypeReference<Map<String, MCPStatus>>() {});
  }

  /**
 * Add MCP server
 * Dynamically add a new Model Context Protocol (MCP) server to the system.
   */
  public Map<String, MCPStatus> add(McpAddRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mcp", path, query, headers, body, new TypeReference<Map<String, MCPStatus>>() {});
  }

  /**
 * Connect an MCP server
   */
  public Boolean connect(McpConnectRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/mcp/{name}/connect", path, query, headers, body, Boolean.class);
  }

  /**
 * Disconnect an MCP server
   */
  public Boolean disconnect(McpDisconnectRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/mcp/{name}/disconnect", path, query, headers, body, Boolean.class);
  }

}
