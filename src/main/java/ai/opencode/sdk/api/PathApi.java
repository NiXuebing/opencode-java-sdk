package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Path;
import ai.opencode.sdk.request.PathGetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class PathApi {
  private final ApiTransport transport;

  public PathApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取路径信息。 */
  public Path get() {
    return get(new PathGetRequest(null));
  }

  /** 获取路径信息。 可传入请求参数。 */
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
