package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class AppApi {
  private final ApiTransport transport;

  public AppApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Write log
 * Write a log entry to the server logs with specified level and metadata.
   */
  public Boolean log(AppLogRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/log", path, query, headers, body, Boolean.class);
  }

  /**
 * List agents
 * Get a list of all available AI agents in the OpenCode system.
   */
  public List<Agent> agents() {
    return agents(new AppAgentsRequest(null));
  }

  public List<Agent> agents(AppAgentsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/agent", path, query, headers, body, new TypeReference<List<Agent>>() {});
  }

  /**
 * List skills
 * Get a list of all available skills in the OpenCode system.
   */
  public List<AppSkillsResponseItem> skills() {
    return skills(new AppSkillsRequest(null));
  }

  public List<AppSkillsResponseItem> skills(AppSkillsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/skill", path, query, headers, body, new TypeReference<List<AppSkillsResponseItem>>() {});
  }

}
