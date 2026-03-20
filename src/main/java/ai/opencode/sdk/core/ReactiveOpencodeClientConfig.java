package ai.opencode.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.reactive.function.client.WebClient;

/** OpenCode Reactive 客户端配置。 */
public final class ReactiveOpencodeClientConfig {
  private final String baseUrl;
  private final WebClient webClient;
  private final ObjectMapper objectMapper;
  private final Map<String, String> headers;
  private final Duration timeout;
  private final String directory;

  public ReactiveOpencodeClientConfig(
      String baseUrl,
      WebClient webClient,
      ObjectMapper objectMapper,
      Map<String, String> headers,
      Duration timeout,
      String directory) {
    this.baseUrl = baseUrl;
    this.webClient = webClient;
    this.objectMapper = objectMapper;
    this.headers = headers;
    this.timeout = timeout;
    this.directory = directory;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String baseUrl() {
    return baseUrl;
  }

  public WebClient webClient() {
    return webClient;
  }

  public ObjectMapper objectMapper() {
    return objectMapper;
  }

  public Map<String, String> headers() {
    return headers;
  }

  public Duration timeout() {
    return timeout;
  }

  public String directory() {
    return directory;
  }

  public static final class Builder {
    private String baseUrl = "http://localhost:4096";
    private WebClient webClient = WebClient.builder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, String> headers = new LinkedHashMap<>();
    private Duration timeout = Duration.ofSeconds(30);
    private String directory;

    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder webClient(WebClient webClient) {
      this.webClient = webClient;
      return this;
    }

    public Builder objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      return this;
    }

    public Builder headers(Map<String, String> headers) {
      this.headers = new LinkedHashMap<>(headers);
      return this;
    }

    public Builder header(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    public Builder directory(String directory) {
      this.directory = directory;
      return this;
    }

    public ReactiveOpencodeClientConfig build() {
      return new ReactiveOpencodeClientConfig(
          baseUrl, webClient, objectMapper, Map.copyOf(headers), timeout, directory);
    }
  }
}
