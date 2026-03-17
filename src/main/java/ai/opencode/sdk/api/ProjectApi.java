package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

public final class ProjectApi {
  private final ApiTransport transport;

  public ProjectApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** List all projects Get a list of projects that have been opened with OpenCode. */
  public List<Project> list() {
    return list(new ProjectListRequest(null));
  }

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

  /** Get current project Retrieve the currently active project that OpenCode is working with. */
  public Project current() {
    return current(new ProjectCurrentRequest(null));
  }

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
