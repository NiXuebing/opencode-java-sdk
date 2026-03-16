package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class MirrorApi {
  private final ApiTransport transport;

  public MirrorApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Initialize mirror
 * Initialize the mirror automation flow and create a new session.
   */
  public MirrorInitResponse init(MirrorInitRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mirror/init", path, query, headers, body, MirrorInitResponse.class);
  }

  /**
 * Run mirror automation
 * Trigger mirror automation asynchronously and return accepted status.
   */
  public MirrorRunResponse run(MirrorRunRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mirror/run", path, query, headers, body, MirrorRunResponse.class);
  }

  /**
 * Append message to mirror session
 * Trigger append asynchronously and return accepted status.
   */
  public MirrorAppendResponse append(MirrorAppendRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mirror/append", path, query, headers, body, MirrorAppendResponse.class);
  }

  /**
 * Subscribe mirror events
 * Subscribe to SSE events filtered by mirror session ID.
   */
  public SseEventStream<MirrorEventEvent> event(MirrorEventRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.stream("POST", "/mirror/event", path, query, headers, body, MirrorEventEvent.class);
  }

  /**
 * Teardown mirror session
 * Clears the active mirror session and disposes internal resources.
   */
  public MirrorTeardownResponse teardown(MirrorTeardownRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mirror/teardown", path, query, headers, body, MirrorTeardownResponse.class);
  }

  /**
 * Get mirror session status
 * Returns the aggregated status of the current mirror session.
   */
  public MirrorStatusResponse status(MirrorStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/mirror/status", path, query, headers, body, MirrorStatusResponse.class);
  }

}
