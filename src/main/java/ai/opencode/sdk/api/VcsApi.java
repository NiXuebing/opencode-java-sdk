package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class VcsApi {
  private final ApiTransport transport;

  public VcsApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * Get VCS info Retrieve version control system (VCS) information for the current project, such as
   * git branch.
   */
  public VcsInfo get() {
    return get(new VcsGetRequest(null));
  }

  public VcsInfo get(VcsGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/vcs", path, query, headers, body, VcsInfo.class);
  }
}
