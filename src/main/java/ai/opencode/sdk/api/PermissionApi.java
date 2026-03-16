package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class PermissionApi {
  private final ApiTransport transport;

  public PermissionApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Respond to permission
 * Approve or deny a permission request from the AI assistant.
   */
  public Boolean respond(PermissionRespondRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("permissionID", request.permissionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/permissions/{permissionID}", path, query, headers, body, Boolean.class);
  }

  /**
 * Respond to permission request
 * Approve or deny a permission request from the AI assistant.
   */
  public Boolean reply(PermissionReplyRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/permission/{requestID}/reply", path, query, headers, body, Boolean.class);
  }

  /**
 * List pending permissions
 * Get all pending permission requests across all sessions.
   */
  public List<PermissionRequest> list() {
    return list(new PermissionListRequest(null));
  }

  public List<PermissionRequest> list(PermissionListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/permission", path, query, headers, body, new TypeReference<List<PermissionRequest>>() {});
  }

}
