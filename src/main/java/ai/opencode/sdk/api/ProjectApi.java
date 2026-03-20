package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Project;
import ai.opencode.sdk.request.ProjectCurrentRequest;
import ai.opencode.sdk.request.ProjectListRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 项目接口的 HTTP 客户端封装。 */
public final class ProjectApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建项目接口封装。
   *
   * @param transport 底层传输器。
   */
  public ProjectApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 列出项目。
   *
   * @return 项目列表。
   */
  public List<Project> list() {
    return list(new ProjectListRequest(null));
  }

  /**
   * 列出项目。
   *
   * @param request 列出项目所需的请求参数。
   * @return 项目列表。
   */
  public List<Project> list(ProjectListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/project", path, query, headers, body, new TypeReference<List<Project>>() {});
  }

  /**
   * 获取当前项目。
   *
   * @return 当前项目。
   */
  public Project current() {
    return current(new ProjectCurrentRequest(null));
  }

  /**
   * 获取当前项目。
   *
   * @param request 获取当前项目所需的请求参数。
   * @return 当前项目。
   */
  public Project current(ProjectCurrentRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/project/current", path, query, headers, body, Project.class);
  }

}
