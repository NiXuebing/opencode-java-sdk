package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class GlobalApi {
  private final ApiTransport transport;

  public GlobalApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Get health Get health information about the OpenCode server. */
  public GlobalHealthResponse health() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/global/health", path, query, headers, body, GlobalHealthResponse.class);
  }

  /**
   * Get global events Subscribe to global events from the OpenCode system using server-sent events.
   */
  public SseEventStream<GlobalEvent> event() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.stream("GET", "/global/event", path, query, headers, body, GlobalEvent.class);
  }
}
