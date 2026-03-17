package ai.opencode.sdk.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

public class ApiTransport {
  private final OpencodeClientConfig config;
  private final HttpClient client;
  private final ObjectMapper mapper;

  public ApiTransport(OpencodeClientConfig config) {
    this.config = config;
    this.client = config.httpClient();
    this.mapper =
        config
            .objectMapper()
            .copy()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    try {
      var response =
          send(
              method,
              route,
              path,
              query,
              headers,
              body,
              HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() < 200 || response.statusCode() >= 300)
        throw ApiException.from(response);
      if (type == Void.class) return null;
      if (response.body() == null || response.body().isBlank()) return null;
      return mapper.readValue(response.body(), type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    try {
      var response =
          send(
              method,
              route,
              path,
              query,
              headers,
              body,
              HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() < 200 || response.statusCode() >= 300)
        throw ApiException.from(response);
      if (response.body() == null || response.body().isBlank()) return null;
      return mapper.readValue(response.body(), type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    return new SseEventStream<>(
        client,
        mapper,
        buildRequest(method, route, path, query, headers, body, "text/event-stream"),
        mapper.constructType(type));
  }

  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    return new SseEventStream<>(
        client,
        mapper,
        buildRequest(method, route, path, query, headers, body, "text/event-stream"),
        mapper.constructType(type));
  }

  private <T> HttpResponse<T> send(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      HttpResponse.BodyHandler<T> handler)
      throws IOException, InterruptedException {
    return client.send(
        buildRequest(method, route, path, query, headers, body, "application/json"), handler);
  }

  private HttpRequest buildRequest(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      String accept) {
    var builder =
        HttpRequest.newBuilder(buildUri(route, path, query))
            .timeout(config.timeout())
            .header("Accept", accept);

    for (var entry : config.headers().entrySet()) {
      builder.header(entry.getKey(), entry.getValue());
    }
    for (var entry : headers.entrySet()) {
      builder.header(entry.getKey(), entry.getValue());
    }

    if (config.directory() != null && !config.directory().isBlank()) {
      builder.header("x-opencode-directory", encodeDirectory(config.directory()));
    }

    if (body == null) {
      builder.method(method, HttpRequest.BodyPublishers.noBody());
      return builder.build();
    }

    try {
      var json = mapper.writeValueAsString(body);
      builder.header("Content-Type", "application/json");
      builder.method(method, HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8));
      return builder.build();
    } catch (IOException error) {
      throw new ApiException("Failed to serialize request body", error);
    }
  }

  private URI buildUri(String route, Map<String, Object> path, Map<String, Object> query) {
    var resolved = route;
    for (var entry : path.entrySet()) {
      resolved =
          resolved.replace("{" + entry.getKey() + "}", encode(String.valueOf(entry.getValue())));
    }

    var base = config.baseUrl();
    var join = resolved.startsWith("/") ? resolved.substring(1) : resolved;
    var uri = base.endsWith("/") ? base + join : base + resolved;
    if (query.isEmpty()) return URI.create(uri);

    var parts = new ArrayList<String>();
    for (var entry : query.entrySet()) {
      if (entry.getValue() instanceof Iterable<?> items) {
        for (var item : items) {
          if (item != null) parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
        }
        continue;
      }
      if (entry.getValue() != null && entry.getValue().getClass().isArray()) {
        var array = (Object[]) entry.getValue();
        for (var item : array) {
          if (item != null) parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
        }
        continue;
      }
      if (entry.getValue() != null) {
        parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(entry.getValue())));
      }
    }

    if (parts.isEmpty()) return URI.create(uri);
    return URI.create(uri + "?" + String.join("&", parts));
  }

  private String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private String encodeDirectory(String value) {
    var ascii = value.chars().allMatch(ch -> ch <= 0x7F);
    return ascii ? value : encode(value);
  }
}
