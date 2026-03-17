package ai.opencode.sdk.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public record OpencodeClientConfig(
    String baseUrl,
    HttpClient httpClient,
    ObjectMapper objectMapper,
    Map<String, String> headers,
    Duration timeout,
    String directory) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String baseUrl = "http://localhost:4096";
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, String> headers = new LinkedHashMap<>();
    private Duration timeout = Duration.ofSeconds(30);
    private String directory;

    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
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

    public OpencodeClientConfig build() {
      return new OpencodeClientConfig(
          baseUrl, httpClient, objectMapper, Map.copyOf(headers), timeout, directory);
    }
  }
}
