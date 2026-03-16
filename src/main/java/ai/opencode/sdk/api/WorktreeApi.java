package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class WorktreeApi {
  private final ApiTransport transport;

  public WorktreeApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Create worktree
 * Create a new git worktree for the current project and run any configured startup scripts.
   */
  public Worktree create(WorktreeCreateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/experimental/worktree", path, query, headers, body, Worktree.class);
  }

  /**
 * List worktrees
 * List all sandbox worktrees for the current project.
   */
  public List<String> list() {
    return list(new WorktreeListRequest(null));
  }

  public List<String> list(WorktreeListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/experimental/worktree", path, query, headers, body, new TypeReference<List<String>>() {});
  }

  /**
 * Remove worktree
 * Remove a git worktree and delete its branch.
   */
  public Boolean remove(WorktreeRemoveRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("DELETE", "/experimental/worktree", path, query, headers, body, Boolean.class);
  }

  /**
 * Reset worktree
 * Reset a worktree branch to the primary default branch.
   */
  public Boolean reset(WorktreeResetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/experimental/worktree/reset", path, query, headers, body, Boolean.class);
  }

}
