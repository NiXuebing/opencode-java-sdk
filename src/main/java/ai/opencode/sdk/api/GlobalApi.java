package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.SseEventStream;
import ai.opencode.sdk.model.GlobalEvent;
import ai.opencode.sdk.model.GlobalHealthResponse;
import java.util.Map;

/** 全局接口的 HTTP 客户端封装。 */
public final class GlobalApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建全局接口封装。
   *
   * @param transport 底层传输器。
   */
  public GlobalApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取全局健康状态。
   *
   * @return 全局健康状态。
   */
  public GlobalHealthResponse health() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/global/health", path, query, headers, body, GlobalHealthResponse.class);
  }

  /**
   * 订阅全局事件。
   *
   * @return 服务端持续推送的事件流。
   */
  public SseEventStream<GlobalEvent> event() {
    Map<String, Object> path = Map.of();
    Map<String, Object> query = Map.of();
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.stream("GET", "/global/event", path, query, headers, body, GlobalEvent.class);
  }
}
