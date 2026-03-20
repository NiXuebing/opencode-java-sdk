package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * MCP浏览器打开失败事件属性。
 *
 * @param mcpName MCP 服务名称。
 * @param url 可访问的地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMcpBrowserOpenFailedProperties {
  @JsonProperty("mcpName")
  private final String mcpName;
  @JsonProperty("url")
  private final String url;

  /** 使用字段创建事件MCP浏览器打开失败属性。 */
  @JsonCreator
  public EventMcpBrowserOpenFailedProperties(
      @JsonProperty("mcpName") String mcpName,
      @JsonProperty("url") String url
  ) {
    this.mcpName = mcpName;
    this.url = url;
  }

  /**
   * 获取MCP Name。
   *
   * @return MCP 服务名称。
   */
  public String mcpName() {
    return mcpName;
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
    if (!(other instanceof EventMcpBrowserOpenFailedProperties)) return false;
    EventMcpBrowserOpenFailedProperties that = (EventMcpBrowserOpenFailedProperties) other;
    return Objects.equals(mcpName, that.mcpName)
        && Objects.equals(url, that.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mcpName, url);
  }

  @Override
  public String toString() {
    return "EventMcpBrowserOpenFailedProperties{" +
        "mcpName=" + mcpName + "," +
        "url=" + url +
        "}";
  }
}
