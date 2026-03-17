package ai.opencode.sdk.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
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

/** 底层 HTTP 传输器，负责请求构造、序列化、响应解析以及 SSE 事件流的打开。 */
public class ApiTransport {
  private final OpencodeClientConfig config;
  private final HttpClient client;
  private final ObjectMapper mapper;

  /**
   * 根据客户端配置创建传输器。
   *
   * @param config 客户端配置。
   */
  public ApiTransport(OpencodeClientConfig config) {
    this.config = config;
    this.client = config.httpClient();
    this.mapper =
        config
            .objectMapper()
            .copy()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  /**
   * 发送普通 HTTP 请求，并按具体类型解析 JSON 响应。
   *
   * @param method HTTP 方法。
   * @param route 接口路径模板。
   * @param path 路径参数映射。
   * @param query 查询参数映射。
   * @param headers 额外请求头。
   * @param body 请求体对象，为 null 时不发送请求体。
   * @param type 目标响应类型。
   * @return 解析后的响应对象；若接口无返回体则返回 null。
   * @throws ApiException 当请求失败、序列化失败或响应无法解析时抛出。
   */
  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    try {
      return parseResponse(
          send(
              method,
              route,
              path,
              query,
              headers,
              body,
              HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)),
          type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  /**
   * 发送普通 HTTP 请求，并按泛型类型解析 JSON 响应。
   *
   * @param method HTTP 方法。
   * @param route 接口路径模板。
   * @param path 路径参数映射。
   * @param query 查询参数映射。
   * @param headers 额外请求头。
   * @param body 请求体对象，为 null 时不发送请求体。
   * @param type 目标响应泛型类型。
   * @return 解析后的响应对象；若接口无返回体则返回 null。
   * @throws ApiException 当请求失败、序列化失败或响应无法解析时抛出。
   */
  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    try {
      return parseResponse(
          send(
              method,
              route,
              path,
              query,
              headers,
              body,
              HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)),
          type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  /**
   * 打开 SSE 事件流，并按具体类型解析事件数据。
   *
   * @param method HTTP 方法。
   * @param route 接口路径模板。
   * @param path 路径参数映射。
   * @param query 查询参数映射。
   * @param headers 额外请求头。
   * @param body 请求体对象，为 null 时不发送请求体。
   * @param type 事件数据类型。
   * @return 可迭代读取的 SSE 事件流。
   * @throws ApiException 当事件流无法建立时抛出。
   */
  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type) {
    return openStream(method, route, path, query, headers, body, mapper.constructType(type));
  }

  /**
   * 打开 SSE 事件流，并按泛型类型解析事件数据。
   *
   * @param method HTTP 方法。
   * @param route 接口路径模板。
   * @param path 路径参数映射。
   * @param query 查询参数映射。
   * @param headers 额外请求头。
   * @param body 请求体对象，为 null 时不发送请求体。
   * @param type 事件数据泛型类型。
   * @return 可迭代读取的 SSE 事件流。
   * @throws ApiException 当事件流无法建立时抛出。
   */
  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type) {
    return openStream(method, route, path, query, headers, body, mapper.constructType(type));
  }

  private <T> T parseResponse(HttpResponse<String> response, Class<T> type) throws IOException {
    ensureSuccess(response);
    if (type == Void.class) return null;
    return readBody(response.body(), type);
  }

  private <T> T parseResponse(HttpResponse<String> response, TypeReference<T> type)
      throws IOException {
    ensureSuccess(response);
    return readBody(response.body(), type);
  }

  private void ensureSuccess(HttpResponse<String> response) {
    if (response.statusCode() < 200 || response.statusCode() >= 300) {
      throw ApiException.from(response);
    }
  }

  private <T> T readBody(String body, Class<T> type) throws IOException {
    if (body == null || body.isBlank()) return null;
    return mapper.readValue(body, type);
  }

  private <T> T readBody(String body, TypeReference<T> type) throws IOException {
    if (body == null || body.isBlank()) return null;
    return mapper.readValue(body, type);
  }

  private <T> SseEventStream<T> openStream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      JavaType type) {
    return new SseEventStream<>(
        client,
        mapper,
        buildRequest(method, route, path, query, headers, body, "text/event-stream"),
        type);
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
