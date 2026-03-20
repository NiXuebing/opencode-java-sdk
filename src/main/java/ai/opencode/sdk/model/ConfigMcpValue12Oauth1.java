package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置MCP值OAuth数据模型。
 *
 * @param clientId 客户端 ID。
 * @param clientSecret 客户端密钥。
 * @param scope 授权范围。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigMcpValue12Oauth1 {
  @JsonProperty("clientId")
  private final String clientId;
  @JsonProperty("clientSecret")
  private final String clientSecret;
  @JsonProperty("scope")
  private final String scope;

  /** 使用字段创建配置MCP值OAuth。 */
  @JsonCreator
  public ConfigMcpValue12Oauth1(
      @JsonProperty("clientId") String clientId,
      @JsonProperty("clientSecret") String clientSecret,
      @JsonProperty("scope") String scope
  ) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.scope = scope;
  }

  /**
   * 获取客户端Id。
   *
   * @return 客户端 ID。
   */
  public String clientId() {
    return clientId;
  }

  /**
   * 获取客户端密钥。
   *
   * @return 客户端密钥。
   */
  public String clientSecret() {
    return clientSecret;
  }

  /**
   * 获取范围。
   *
   * @return 授权范围。
   */
  public String scope() {
    return scope;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigMcpValue12Oauth1)) return false;
    ConfigMcpValue12Oauth1 that = (ConfigMcpValue12Oauth1) other;
    return Objects.equals(clientId, that.clientId)
        && Objects.equals(clientSecret, that.clientSecret)
        && Objects.equals(scope, that.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientSecret, scope);
  }

  @Override
  public String toString() {
    return "ConfigMcpValue12Oauth1{" +
        "clientId=" + clientId + "," +
        "clientSecret=" + clientSecret + "," +
        "scope=" + scope +
        "}";
  }
}
