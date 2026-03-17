package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class AuthApi {
  private final ApiTransport transport;

  public AuthApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Set auth credentials Set authentication credentials */
  public Boolean set(AuthSetRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.providerID(), "request.providerID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "PUT", "/auth/{providerID}", path, query, headers, body, Boolean.class);
  }
}
