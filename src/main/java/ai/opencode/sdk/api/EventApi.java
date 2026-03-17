package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.SseEventStream;
import ai.opencode.sdk.model.Event;
import ai.opencode.sdk.request.EventSubscribeRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class EventApi {
  private final ApiTransport transport;

  public EventApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 订阅服务事件。 */
  public SseEventStream<Event> subscribe() {
    return subscribe(new EventSubscribeRequest(null));
  }

  /** 订阅服务事件。 可传入请求参数。 */
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
