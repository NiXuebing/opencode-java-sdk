package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.ToolIDs;
import ai.opencode.sdk.model.ToolList;
import ai.opencode.sdk.request.ToolIdsRequest;
import ai.opencode.sdk.request.ToolListRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class ToolApi {
  private final ApiTransport transport;

  public ToolApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取工具 ID 列表。 */
  public ToolIDs ids() {
    return ids(new ToolIdsRequest(null));
  }

  /** 获取工具 ID 列表。 可传入请求参数。 */
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

  /** 获取工具列表。 可传入请求参数。 */
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
