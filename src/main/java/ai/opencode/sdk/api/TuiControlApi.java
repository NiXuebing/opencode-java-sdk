package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class TuiControlApi {
  private final ApiTransport transport;

  public TuiControlApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Get next TUI request
 * Retrieve the next TUI (Terminal User Interface) request from the queue for processing.
   */
  public TuiControlNextResponse next() {
    return next(new TuiControlNextRequest(null));
  }

  public TuiControlNextResponse next(TuiControlNextRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/tui/control/next", path, query, headers, body, TuiControlNextResponse.class);
  }

  /**
 * Submit TUI response
 * Submit a response to the TUI request queue to complete a pending request.
   */
  public Boolean response(TuiControlResponseRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/control/response", path, query, headers, body, Boolean.class);
  }

}
