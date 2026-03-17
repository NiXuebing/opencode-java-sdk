package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class PermissionApi {
  private final ApiTransport transport;

  public PermissionApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Respond to permission Approve or deny a permission request from the AI assistant. */
  public Boolean respond(PermissionRespondRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.permissionID(), "request.permissionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("permissionID", request.permissionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST",
        "/session/{sessionID}/permissions/{permissionID}",
        path,
        query,
        headers,
        body,
        Boolean.class);
  }
}
