package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class GlobalApi {
  private final ApiTransport transport;
  private final GlobalConfigApi config;

  public GlobalApi(ApiTransport transport) {
    this.transport = transport;
    this.config = new GlobalConfigApi(transport);

  }

  public GlobalConfigApi config() {
    return config;
  }

  /**
 * Get health
 * Get health information about the OpenCode server.
   */
  public GlobalHealthResponse health() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/global/health", path, query, headers, body, GlobalHealthResponse.class);
  }

  /**
 * Get global events
 * Subscribe to global events from the OpenCode system using server-sent events.
   */
  public SseEventStream<GlobalEvent> event() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.stream("GET", "/global/event", path, query, headers, body, GlobalEvent.class);
  }

  /**
 * Dispose instance
 * Clean up and dispose all OpenCode instances, releasing all resources.
   */
  public Boolean dispose() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/global/dispose", path, query, headers, body, Boolean.class);
  }

}
