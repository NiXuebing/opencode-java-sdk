package ai.opencode.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * OpenCode 客户端配置。
 *
 * @param baseUrl 服务端基础地址。
 * @param httpClient 底层 HTTP 客户端。
 * @param objectMapper 用于序列化和反序列化的 Jackson 对象映射器。
 * @param headers 默认请求头。
 * @param timeout 请求超时时间。
 * @param directory 默认工作目录。
 */
public record OpencodeClientConfig(
    String baseUrl,
    HttpClient httpClient,
    ObjectMapper objectMapper,
    Map<String, String> headers,
    Duration timeout,
    String directory) {
  /** 创建配置构建器。 */
  public static Builder builder() {
    return new Builder();
  }

  /** 用于构建客户端配置的构建器。 */
  public static final class Builder {
    private String baseUrl = "http://localhost:4096";
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, String> headers = new LinkedHashMap<>();
    private Duration timeout = Duration.ofSeconds(30);
    private String directory;

    /**
     * 设置服务端基础地址。
     *
     * @param baseUrl 服务端基础地址。
     * @return 当前构建器。
     */
    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    /**
     * 设置底层 HTTP 客户端。
     *
     * @param httpClient 底层 HTTP 客户端。
     * @return 当前构建器。
     */
    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
      return this;
    }

    /**
     * 设置 Jackson 对象映射器。
     *
     * @param objectMapper Jackson 对象映射器。
     * @return 当前构建器。
     */
    public Builder objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      return this;
    }

    /**
     * 批量设置默认请求头。
     *
     * @param headers 默认请求头。
     * @return 当前构建器。
     */
    public Builder headers(Map<String, String> headers) {
      this.headers = new LinkedHashMap<>(headers);
      return this;
    }

    /**
     * 追加单个默认请求头。
     *
     * @param key 请求头名称。
     * @param value 请求头值。
     * @return 当前构建器。
     */
    public Builder header(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    /**
     * 设置请求超时时间。
     *
     * @param timeout 请求超时时间。
     * @return 当前构建器。
     */
    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * 设置默认工作目录。
     *
     * @param directory 默认工作目录。
     * @return 当前构建器。
     */
    public Builder directory(String directory) {
      this.directory = directory;
      return this;
    }

    /**
     * 构建客户端配置。
     *
     * @return 构建完成的客户端配置。
     */
    public OpencodeClientConfig build() {
      return new OpencodeClientConfig(
          baseUrl, httpClient, objectMapper, Map.copyOf(headers), timeout, directory);
    }
  }
}
