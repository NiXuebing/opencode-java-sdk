package ai.opencode.sdk.core;

import java.util.Objects;

/**
 * 单条 SSE 事件。
 *
 * @param data 事件数据。
 * @param event 事件名称。
 * @param id 事件 ID。
 * @param retry 服务端建议的重试间隔，单位为毫秒。
 */
public final class SseEvent<T> {
  private final T data;
  private final String event;
  private final String id;
  private final Integer retry;

  public SseEvent(T data, String event, String id, Integer retry) {
    this.data = data;
    this.event = event;
    this.id = id;
    this.retry = retry;
  }

  public T data() {
    return data;
  }

  public String event() {
    return event;
  }

  public String id() {
    return id;
  }

  public Integer retry() {
    return retry;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SseEvent)) return false;
    SseEvent<?> that = (SseEvent<?>) other;
    return Objects.equals(data, that.data)
        && Objects.equals(event, that.event)
        && Objects.equals(id, that.id)
        && Objects.equals(retry, that.retry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, event, id, retry);
  }

  @Override
  public String toString() {
    return "SseEvent{"
        + "data="
        + data
        + ",event="
        + event
        + ",id="
        + id
        + ",retry="
        + retry
        + "}";
  }
}
