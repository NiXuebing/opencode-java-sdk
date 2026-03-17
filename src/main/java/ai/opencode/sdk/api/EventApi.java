package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import java.util.*;

public final class EventApi {
  private final ApiTransport transport;

  public EventApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Subscribe to events Get events */
  public SseEventStream<Event> subscribe() {
    return subscribe(new EventSubscribeRequest(null));
  }

  public SseEventStream<Event> subscribe(EventSubscribeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.stream("GET", "/event", path, query, headers, body, Event.class);
  }
}
