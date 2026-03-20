package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * LSP客户端诊断事件数据。
 *
 * @param type 类型标识。
 * @param properties 附加属性。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventLspClientDiagnostics implements Event {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("properties")
  private final EventLspClientDiagnosticsProperties properties;

  /** 使用字段创建事件LSP客户端诊断。 */
  @JsonCreator
  public EventLspClientDiagnostics(
      @JsonProperty("type") String type,
      @JsonProperty("properties") EventLspClientDiagnosticsProperties properties
  ) {
    this.type = type;
    this.properties = properties;
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
   * 获取属性。
   *
   * @return 附加属性。
   */
  public EventLspClientDiagnosticsProperties properties() {
    return properties;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventLspClientDiagnostics)) return false;
    EventLspClientDiagnostics that = (EventLspClientDiagnostics) other;
    return Objects.equals(type, that.type)
        && Objects.equals(properties, that.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, properties);
  }

  @Override
  public String toString() {
    return "EventLspClientDiagnostics{" +
        "type=" + type + "," +
        "properties=" + properties +
        "}";
  }
}
