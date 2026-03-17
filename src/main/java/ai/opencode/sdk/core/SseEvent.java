package ai.opencode.sdk.core;

/**
 * 单条 SSE 事件。
 *
 * @param data 事件数据。
 * @param event 事件名称。
 * @param id 事件 ID。
 * @param retry 服务端建议的重试间隔，单位为毫秒。
 */
public record SseEvent<T>(T data, String event, String id, Integer retry) {}
