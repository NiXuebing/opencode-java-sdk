package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class PathApi {
  private final ApiTransport transport;

  public PathApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * Get paths Retrieve the current working directory and related path information for the OpenCode
   * instance.
   */
  public Path get() {
    return get(new PathGetRequest(null));
  }

  public Path get(PathGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/path", path, query, headers, body, Path.class);
  }
}
