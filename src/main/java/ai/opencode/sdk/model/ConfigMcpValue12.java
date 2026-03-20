package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 配置MCP值数据模型。
 *
 * @param type 类型标识。
 * @param url 可访问的地址。
 * @param enabled 是否启用。
 * @param headers 自定义请求头集合。
 * @param oauth OAuth。
 * @param timeout 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigMcpValue12 {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("url")
  private final String url;
  @JsonProperty("enabled")
  private final Boolean enabled;
  @JsonProperty("headers")
  private final Map<String, String> headers;
  @JsonProperty("oauth")
  private final JsonNode oauth;
  @JsonProperty("timeout")
  private final Long timeout;

  /** 使用字段创建配置MCP值。 */
  @JsonCreator
  public ConfigMcpValue12(
      @JsonProperty("type") String type,
      @JsonProperty("url") String url,
      @JsonProperty("enabled") Boolean enabled,
      @JsonProperty("headers") Map<String, String> headers,
      @JsonProperty("oauth") JsonNode oauth,
      @JsonProperty("timeout") Long timeout
  ) {
    this.type = type;
    this.url = url;
    this.enabled = enabled;
    this.headers = headers;
    this.oauth = oauth;
    this.timeout = timeout;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取地址。
   *
   * @return 可访问的地址。
   */
  public String url() {
    return url;
  }

  /**
   * 获取启用。
   *
   * @return 是否启用。
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * 获取headers。
   *
   * @return 自定义请求头集合。
   */
  public Map<String, String> headers() {
    return headers;
  }

  /**
   * 获取OAuth。
   *
   * @return OAuth。
   */
  public JsonNode oauth() {
    return oauth;
  }

  /**
   * 获取timeout。
   *
   * @return 请求超时时间。
   */
  public Long timeout() {
    return timeout;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigMcpValue12)) return false;
    ConfigMcpValue12 that = (ConfigMcpValue12) other;
    return Objects.equals(type, that.type)
        && Objects.equals(url, that.url)
        && Objects.equals(enabled, that.enabled)
        && Objects.equals(headers, that.headers)
        && Objects.equals(oauth, that.oauth)
        && Objects.equals(timeout, that.timeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, url, enabled, headers, oauth, timeout);
  }

  @Override
  public String toString() {
    return "ConfigMcpValue12{" +
        "type=" + type + "," +
        "url=" + url + "," +
        "enabled=" + enabled + "," +
        "headers=" + headers + "," +
        "oauth=" + oauth + "," +
        "timeout=" + timeout +
        "}";
  }
}
