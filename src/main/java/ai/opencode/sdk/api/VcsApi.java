package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.VcsInfo;
import ai.opencode.sdk.request.VcsGetRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 封装版本控制接口相关的 HTTP 调用。 */
public final class VcsApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建版本控制接口封装。
   *
   * @param transport 底层传输器。
   */
  public VcsApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取版本控制信息。
   *
   * @return 版本控制信息。
   */
  public VcsInfo get() {
    return get(new VcsGetRequest(null));
  }

  /**
   * 获取版本控制信息。
   *
   * @param request 获取版本控制信息所需的请求参数。
   * @return 版本控制信息。
   */
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
