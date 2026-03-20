package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ReactiveApiTransport;
import ai.opencode.sdk.core.SseEvent;
import ai.opencode.sdk.model.Event;
import ai.opencode.sdk.request.EventSubscribeRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import reactor.core.publisher.Flux;

/** 事件订阅接口的 Reactive HTTP 客户端封装。 */
public final class ReactiveEventApi {
  private final ReactiveApiTransport transport;

  public ReactiveEventApi(ReactiveApiTransport transport) {
    this.transport = transport;
  }

  public Flux<SseEvent<Event>> subscribe() {
    return subscribe(new EventSubscribeRequest(null));
  }

  public Flux<SseEvent<Event>> subscribe(EventSubscribeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (request.directory() != null) query.put("directory", request.directory());
    return transport.stream("GET", "/event", Map.of(), query, Map.of(), null, Event.class);
  }
}
