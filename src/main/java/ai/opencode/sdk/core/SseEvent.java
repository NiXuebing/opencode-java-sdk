package ai.opencode.sdk.core;

public record SseEvent<T>(
    T data,
    String event,
    String id,
    Integer retry
) {
}
