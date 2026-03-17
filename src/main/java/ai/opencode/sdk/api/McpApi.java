package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.MCPStatus;
import ai.opencode.sdk.request.McpAddRequest;
import ai.opencode.sdk.request.McpStatusRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class McpApi {
  private final ApiTransport transport;

  public McpApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取 MCP 状态。 */
  public Map<String, MCPStatus> status() {
    return status(new McpStatusRequest(null));
  }

  /** 获取 MCP 状态。 可传入请求参数。 */
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

  /** 添加 MCP 服务。 可传入请求参数。 */
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
