package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * MCP工具已变更事件属性。
 *
 * @param server 服务端。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventMcpToolsChangedProperties {
  @JsonProperty("server")
  private final String server;

  /** 使用字段创建事件MCP工具已变更属性。 */
  @JsonCreator
  public EventMcpToolsChangedProperties(
      @JsonProperty("server") String server
  ) {
    this.server = server;
  }

  /**
   * 获取服务端。
   *
   * @return 服务端。
   */
  public String server() {
    return server;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventMcpToolsChangedProperties)) return false;
    EventMcpToolsChangedProperties that = (EventMcpToolsChangedProperties) other;
    return Objects.equals(server, that.server);
  }

  @Override
  public int hashCode() {
    return Objects.hash(server);
  }

  @Override
  public String toString() {
    return "EventMcpToolsChangedProperties{" +
        "server=" + server +
        "}";
  }
}
