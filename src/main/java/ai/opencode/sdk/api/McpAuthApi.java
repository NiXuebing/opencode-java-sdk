package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class McpAuthApi {
  private final ApiTransport transport;

  public McpAuthApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Start MCP OAuth
 * Start OAuth authentication flow for a Model Context Protocol (MCP) server.
   */
  public McpAuthStartResponse start(McpAuthStartRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/mcp/{name}/auth", path, query, headers, body, McpAuthStartResponse.class);
  }

  /**
 * Remove MCP OAuth
 * Remove OAuth credentials for an MCP server
   */
  public McpAuthRemoveResponse remove(McpAuthRemoveRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("DELETE", "/mcp/{name}/auth", path, query, headers, body, McpAuthRemoveResponse.class);
  }

  /**
 * Complete MCP OAuth
 * Complete OAuth authentication for a Model Context Protocol (MCP) server using the authorization code.
   */
  public MCPStatus callback(McpAuthCallbackRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mcp/{name}/auth/callback", path, query, headers, body, MCPStatus.class);
  }

  /**
 * Authenticate MCP OAuth
 * Start OAuth flow and wait for callback (opens browser)
   */
  public MCPStatus authenticate(McpAuthAuthenticateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("name", request.name());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/mcp/{name}/auth/authenticate", path, query, headers, body, MCPStatus.class);
  }

}
