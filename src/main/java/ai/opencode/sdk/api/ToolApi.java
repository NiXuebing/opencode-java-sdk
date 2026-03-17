package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.ToolIDs;
import ai.opencode.sdk.model.ToolList;
import ai.opencode.sdk.request.ToolIdsRequest;
import ai.opencode.sdk.request.ToolListRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 封装工具接口相关的 HTTP 调用。 */
public final class ToolApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建工具接口封装。
   *
   * @param transport 底层传输器。
   */
  public ToolApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取工具 ID 列表。
   *
   * @return 工具 ID 列表。
   */
  public ToolIDs ids() {
    return ids(new ToolIdsRequest(null));
  }

  /**
   * 获取工具 ID 列表。
   *
   * @param request 获取工具 ID 列表所需的请求参数。
   * @return 工具 ID 列表。
   */
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
   * 获取工具列表。
   *
   * @param request 获取工具列表所需的请求参数，其中 provider、model 为必填项。
   * @return 工具列表。
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
