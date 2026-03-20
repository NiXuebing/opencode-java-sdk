package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置企业版数据模型。
 *
 * @param url 可访问的地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigEnterprise {
  @JsonProperty("url")
  private final String url;

  /** 使用字段创建配置企业版。 */
  @JsonCreator
  public ConfigEnterprise(
      @JsonProperty("url") String url
  ) {
    this.url = url;
  }

  /**
   * 获取地址。
   *
   * @return 可访问的地址。
   */
  public String url() {
    return url;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigEnterprise)) return false;
    ConfigEnterprise that = (ConfigEnterprise) other;
    return Objects.equals(url, that.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url);
  }

  @Override
  public String toString() {
    return "ConfigEnterprise{" +
        "url=" + url +
        "}";
  }
}
