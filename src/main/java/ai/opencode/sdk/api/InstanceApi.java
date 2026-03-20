package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.request.InstanceDisposeRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 实例接口的 HTTP 客户端封装。 */
public final class InstanceApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建实例接口封装。
   *
   * @param transport 底层传输器。
   */
  public InstanceApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 释放实例。
   *
   * @return 操作是否成功。
   */
  public Boolean dispose() {
    return dispose(new InstanceDisposeRequest(null));
  }

  /**
   * 释放实例。
   *
   * @param request 释放实例所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean dispose(InstanceDisposeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/instance/dispose", path, query, headers, body, Boolean.class);
  }

}
