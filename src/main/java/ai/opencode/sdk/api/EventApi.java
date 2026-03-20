package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.SseEventStream;
import ai.opencode.sdk.model.Event;
import ai.opencode.sdk.request.EventSubscribeRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 事件订阅接口的 HTTP 客户端封装。 */
public final class EventApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建事件订阅接口封装。
   *
   * @param transport 底层传输器。
   */
  public EventApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 订阅服务事件。
   *
   * @return 服务端持续推送的事件流。
   */
  public SseEventStream<Event> subscribe() {
    return subscribe(new EventSubscribeRequest(null));
  }

  /**
   * 订阅服务事件。
   *
   * @param request 订阅服务事件所需的请求参数。
   * @return 服务端持续推送的事件流。
   */
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
