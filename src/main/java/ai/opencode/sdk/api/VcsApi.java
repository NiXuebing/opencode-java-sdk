package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.VcsInfo;
import ai.opencode.sdk.request.VcsGetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class VcsApi {
  private final ApiTransport transport;

  public VcsApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取版本控制信息。 */
  public VcsInfo get() {
    return get(new VcsGetRequest(null));
  }

  /** 获取版本控制信息。 可传入请求参数。 */
  public VcsInfo get(VcsGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/vcs", path, query, headers, body, VcsInfo.class);
  }
}
