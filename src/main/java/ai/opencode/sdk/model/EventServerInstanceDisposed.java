package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 服务端实例已释放事件数据。
 *
 * @param type 类型标识。
 * @param properties 附加属性。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventServerInstanceDisposed implements Event {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("properties")
  private final EventServerInstanceDisposedProperties properties;

  /** 使用字段创建事件服务端实例已释放。 */
  @JsonCreator
  public EventServerInstanceDisposed(
      @JsonProperty("type") String type,
      @JsonProperty("properties") EventServerInstanceDisposedProperties properties
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
  public EventServerInstanceDisposedProperties properties() {
    return properties;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventServerInstanceDisposed)) return false;
    EventServerInstanceDisposed that = (EventServerInstanceDisposed) other;
    return Objects.equals(type, that.type)
        && Objects.equals(properties, that.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, properties);
  }

  @Override
  public String toString() {
    return "EventServerInstanceDisposed{" +
        "type=" + type + "," +
        "properties=" + properties +
        "}";
  }
}
