package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class InstanceApi {
  private final ApiTransport transport;

  public InstanceApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * Dispose instance Clean up and dispose the current OpenCode instance, releasing all resources.
   */
  public Boolean dispose() {
    return dispose(new InstanceDisposeRequest(null));
  }

  public Boolean dispose(InstanceDisposeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/instance/dispose", path, query, headers, body, Boolean.class);
  }
}
