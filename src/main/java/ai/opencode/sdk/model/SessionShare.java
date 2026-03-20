package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话分享数据模型。
 *
 * @param url 可访问的地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionShare {
  @JsonProperty("url")
  private final String url;

  /** 使用字段创建会话分享。 */
  @JsonCreator
  public SessionShare(
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
    if (!(other instanceof SessionShare)) return false;
    SessionShare that = (SessionShare) other;
    return Objects.equals(url, that.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url);
  }

  @Override
  public String toString() {
    return "SessionShare{" +
        "url=" + url +
        "}";
  }
}
