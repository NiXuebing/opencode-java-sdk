package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.SseEventStream;
import ai.opencode.sdk.model.GlobalEvent;
import ai.opencode.sdk.model.GlobalHealthResponse;
import java.util.Map;

public final class GlobalApi {
  private final ApiTransport transport;

  public GlobalApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取全局健康状态。 */
  public GlobalHealthResponse health() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/global/health", path, query, headers, body, GlobalHealthResponse.class);
  }

  /** 订阅全局事件。 */
  public SseEventStream<GlobalEvent> event() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.stream("GET", "/global/event", path, query, headers, body, GlobalEvent.class);
  }
}
