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

public final class ProjectApi {
  private final ApiTransport transport;

  public ProjectApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 列出项目。 */
  public List<Project> list() {
    return list(new ProjectListRequest(null));
  }

  /** 列出项目。 可传入请求参数。 */
  public List<Project> list(ProjectListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/project", path, query, headers, body, new TypeReference<List<Project>>() {});
  }

  /** 获取当前项目。 */
  public Project current() {
    return current(new ProjectCurrentRequest(null));
  }

  /** 获取当前项目。 可传入请求参数。 */
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
