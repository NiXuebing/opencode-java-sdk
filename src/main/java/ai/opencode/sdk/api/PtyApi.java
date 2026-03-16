package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class PtyApi {
  private final ApiTransport transport;

  public PtyApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * List PTY sessions
 * Get a list of all active pseudo-terminal (PTY) sessions managed by OpenCode.
   */
  public List<Pty> list() {
    return list(new PtyListRequest(null));
  }

  public List<Pty> list(PtyListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/pty", path, query, headers, body, new TypeReference<List<Pty>>() {});
  }

  /**
 * Create PTY session
 * Create a new pseudo-terminal (PTY) session for running shell commands and processes.
   */
  public Pty create(PtyCreateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/pty", path, query, headers, body, Pty.class);
  }

  /**
 * Get PTY session
 * Retrieve detailed information about a specific pseudo-terminal (PTY) session.
   */
  public Pty get(PtyGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("ptyID", request.ptyID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/pty/{ptyID}", path, query, headers, body, Pty.class);
  }

  /**
 * Update PTY session
 * Update properties of an existing pseudo-terminal (PTY) session.
   */
  public Pty update(PtyUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("ptyID", request.ptyID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PUT", "/pty/{ptyID}", path, query, headers, body, Pty.class);
  }

  /**
 * Remove PTY session
 * Remove and terminate a specific pseudo-terminal (PTY) session.
   */
  public Boolean remove(PtyRemoveRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("ptyID", request.ptyID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("DELETE", "/pty/{ptyID}", path, query, headers, body, Boolean.class);
  }

  /**
 * Connect to PTY session
 * Establish a WebSocket connection to interact with a pseudo-terminal (PTY) session in real-time.
   */
  public Boolean connect(PtyConnectRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("ptyID", request.ptyID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/pty/{ptyID}/connect", path, query, headers, body, Boolean.class);
  }

}
