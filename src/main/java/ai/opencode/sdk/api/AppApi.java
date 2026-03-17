package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Agent;
import ai.opencode.sdk.request.AppAgentsRequest;
import ai.opencode.sdk.request.AppLogRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 封装应用接口相关的 HTTP 调用。 */
public final class AppApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建应用接口封装。
   *
   * @param transport 底层传输器。
   */
  public AppApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 写入日志。
   *
   * @param request 写入日志所需的请求参数，其中 body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean log(AppLogRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/log", path, query, headers, body, Boolean.class);
  }

  /**
   * 列出代理。
   *
   * @return 代理列表。
   */
  public List<Agent> agents() {
    return agents(new AppAgentsRequest(null));
  }

  /**
   * 列出代理。
   *
   * @param request 列出代理所需的请求参数。
   * @return 代理列表。
   */
  public List<Agent> agents(AppAgentsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/agent", path, query, headers, body, new TypeReference<List<Agent>>() {});
  }
}
