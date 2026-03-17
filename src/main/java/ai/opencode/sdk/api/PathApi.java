package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Path;
import ai.opencode.sdk.request.PathGetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 路径接口的 HTTP 客户端封装。 */
public final class PathApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建路径接口封装。
   *
   * @param transport 底层传输器。
   */
  public PathApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取路径信息。
   *
   * @return 路径信息。
   */
  public Path get() {
    return get(new PathGetRequest(null));
  }

  /**
   * 获取路径信息。
   *
   * @param request 获取路径信息所需的请求参数。
   * @return 路径信息。
   */
  public Path get(PathGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/path", path, query, headers, body, Path.class);
  }
}
