package ai.opencode.sdk.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** 面向 WebFlux 的底层 HTTP 传输器。 */
public class ReactiveApiTransport {
  private final ReactiveOpencodeClientConfig config;
  private final WebClient client;
  private final ObjectMapper mapper;

  public ReactiveApiTransport(ReactiveOpencodeClientConfig config) {
    this.config = config;
    this.client = config.webClient();
    this.mapper =
        config
            .objectMapper()
            .copy()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public <T> Mono<T> execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    return exchange(method, route, path, query, headers, body)
        .flatMap(payload -> decodeBody(payload, mapper.constructType(type), type == Void.class));
  }

  public <T> Mono<T> execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    return exchange(method, route, path, query, headers, body)
        .flatMap(payload -> decodeBody(payload, mapper.constructType(type), false));
  }

  public <T> Flux<SseEvent<T>> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    return streamInternal(
        method, route, path, query, headers, body, mapper.constructType(type));
  }

  public <T> Flux<SseEvent<T>> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    return streamInternal(
        method, route, path, query, headers, body, mapper.constructType(type));
  }

  private Mono<String> exchange(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body) {
    WebClient.RequestBodySpec spec =
        client
            .method(HttpMethod.valueOf(method))
            .uri(buildUri(route, path, query))
            .accept(MediaType.APPLICATION_JSON);
    applyHeaders(spec, headers);

    WebClient.RequestHeadersSpec<?> request = body == null ? spec : spec.bodyValue(body);
    return request
        .exchangeToMono(
            response ->
                response
                    .bodyToMono(String.class)
                    .defaultIfEmpty("")
                    .flatMap(
                        payload -> {
                          if (response.statusCode().is2xxSuccessful()) {
                            return Mono.just(payload);
                          }
                          return Mono.error(
                              new ApiException(
                                  response.rawStatusCode(), payload, response.headers().asHttpHeaders()));
                        }))
        .timeout(config.timeout());
  }

  private <T> Flux<SseEvent<T>> streamInternal(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      JavaType type) {
    WebClient.RequestBodySpec spec =
        client
            .method(HttpMethod.valueOf(method))
            .uri(buildUri(route, path, query))
            .accept(MediaType.TEXT_EVENT_STREAM);
    applyHeaders(spec, headers);

    WebClient.RequestHeadersSpec<?> request = body == null ? spec : spec.bodyValue(body);
    return request
        .exchangeToFlux(
            response -> {
              if (!response.statusCode().is2xxSuccessful()) {
                return response
                    .bodyToMono(String.class)
                    .defaultIfEmpty("")
                    .flatMapMany(
                        payload ->
                            Flux.error(
                                new ApiException(
                                    response.rawStatusCode(),
                                    payload,
                                    response.headers().asHttpHeaders())));
              }
              return response.bodyToFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {});
            })
        .timeout(config.timeout())
        .map(event -> toSseEvent(event, type));
  }

  private void applyHeaders(WebClient.RequestBodySpec spec, Map<String, String> headers) {
    for (Map.Entry<String, String> entry : config.headers().entrySet()) {
      spec.header(entry.getKey(), entry.getValue());
    }
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      spec.header(entry.getKey(), entry.getValue());
    }
    if (config.directory() != null && !config.directory().isBlank()) {
      spec.header("x-opencode-directory", encodeDirectory(config.directory()));
    }
    spec.contentType(MediaType.APPLICATION_JSON);
  }

  private <T> Mono<T> decodeBody(String payload, JavaType type, boolean isVoid) {
    if (isVoid || payload == null || payload.isBlank()) {
      return Mono.empty();
    }
    try {
      return Mono.just(mapper.readValue(payload, type));
    } catch (IOException error) {
      return Mono.error(new ApiException("Failed to parse response body", error));
    }
  }

  private <T> SseEvent<T> toSseEvent(ServerSentEvent<String> event, JavaType type) {
    try {
      String payload = event.data();
      T data = payload == null || payload.isBlank() ? null : mapper.readValue(payload, type);
      Duration retry = event.retry();
      Integer retryMillis = retry == null ? null : Math.toIntExact(retry.toMillis());
      return new SseEvent<>(data, event.event(), event.id(), retryMillis);
    } catch (IOException error) {
      throw new ApiException("Failed to parse SSE payload", error);
    }
  }

  private URI buildUri(String route, Map<String, Object> path, Map<String, Object> query) {
    String resolved = route;
    for (Map.Entry<String, Object> entry : path.entrySet()) {
      resolved =
          resolved.replace(
              "{" + entry.getKey() + "}", encode(String.valueOf(entry.getValue())));
    }

    String base = config.baseUrl();
    String join = resolved.startsWith("/") ? resolved.substring(1) : resolved;
    String uri = base.endsWith("/") ? base + join : base + resolved;
    if (query.isEmpty()) {
      return URI.create(uri);
    }

    ArrayList<String> parts = new ArrayList<String>();
    for (Map.Entry<String, Object> entry : query.entrySet()) {
      Object value = entry.getValue();
      if (value instanceof Iterable<?>) {
        Iterable<?> items = (Iterable<?>) value;
        for (Object item : items) {
          if (item != null) {
            parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
          }
        }
        continue;
      }
      if (value != null && value.getClass().isArray()) {
        Object[] array = (Object[]) value;
        for (Object item : array) {
          if (item != null) {
            parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
          }
        }
        continue;
      }
      if (value != null) {
        parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(value)));
      }
    }

    if (parts.isEmpty()) {
      return URI.create(uri);
    }
    return URI.create(uri + "?" + String.join("&", parts));
  }

  private String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private String encodeDirectory(String value) {
    boolean ascii = value.chars().allMatch(ch -> ch <= 0x7F);
    return ascii ? value : encode(value);
  }
}
