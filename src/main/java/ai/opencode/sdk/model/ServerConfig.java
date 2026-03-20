package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 服务端配置。
 *
 * @param port 端口。
 * @param hostname 主机名。
 * @param mdns 是否启用 mDNS。
 * @param mdnsDomain mDNS 域名。
 * @param cors 跨域来源列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ServerConfig {
  @JsonProperty("port")
  private final Long port;
  @JsonProperty("hostname")
  private final String hostname;
  @JsonProperty("mdns")
  private final Boolean mdns;
  @JsonProperty("mdnsDomain")
  private final String mdnsDomain;
  @JsonProperty("cors")
  private final List<String> cors;

  /** 使用字段创建服务端配置。 */
  @JsonCreator
  public ServerConfig(
      @JsonProperty("port") Long port,
      @JsonProperty("hostname") String hostname,
      @JsonProperty("mdns") Boolean mdns,
      @JsonProperty("mdnsDomain") String mdnsDomain,
      @JsonProperty("cors") List<String> cors
  ) {
    this.port = port;
    this.hostname = hostname;
    this.mdns = mdns;
    this.mdnsDomain = mdnsDomain;
    this.cors = cors;
  }

  /**
   * 获取端口。
   *
   * @return 端口。
   */
  public Long port() {
    return port;
  }

  /**
   * 获取hostname。
   *
   * @return 主机名。
   */
  public String hostname() {
    return hostname;
  }

  /**
   * 获取mDNS。
   *
   * @return 是否启用 mDNS。
   */
  public Boolean mdns() {
    return mdns;
  }

  /**
   * 获取mDNS Domain。
   *
   * @return mDNS 域名。
   */
  public String mdnsDomain() {
    return mdnsDomain;
  }

  /**
   * 获取cors。
   *
   * @return 跨域来源列表。
   */
  public List<String> cors() {
    return cors;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ServerConfig)) return false;
    ServerConfig that = (ServerConfig) other;
    return Objects.equals(port, that.port)
        && Objects.equals(hostname, that.hostname)
        && Objects.equals(mdns, that.mdns)
        && Objects.equals(mdnsDomain, that.mdnsDomain)
        && Objects.equals(cors, that.cors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(port, hostname, mdns, mdnsDomain, cors);
  }

  @Override
  public String toString() {
    return "ServerConfig{" +
        "port=" + port + "," +
        "hostname=" + hostname + "," +
        "mdns=" + mdns + "," +
        "mdnsDomain=" + mdnsDomain + "," +
        "cors=" + cors +
        "}";
  }
}
