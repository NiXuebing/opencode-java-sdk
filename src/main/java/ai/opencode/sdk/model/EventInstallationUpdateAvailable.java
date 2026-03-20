package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 安装更新可用事件数据。
 *
 * @param type 类型标识。
 * @param properties 附加属性。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventInstallationUpdateAvailable implements Event {
  @JsonProperty("type")
  private final String type;
  @JsonProperty("properties")
  private final EventInstallationUpdateAvailableProperties properties;

  /** 使用字段创建事件安装更新可用。 */
  @JsonCreator
  public EventInstallationUpdateAvailable(
      @JsonProperty("type") String type,
      @JsonProperty("properties") EventInstallationUpdateAvailableProperties properties
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
  public EventInstallationUpdateAvailableProperties properties() {
    return properties;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventInstallationUpdateAvailable)) return false;
    EventInstallationUpdateAvailable that = (EventInstallationUpdateAvailable) other;
    return Objects.equals(type, that.type)
        && Objects.equals(properties, that.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, properties);
  }

  @Override
  public String toString() {
    return "EventInstallationUpdateAvailable{" +
        "type=" + type + "," +
        "properties=" + properties +
        "}";
  }
}
