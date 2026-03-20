package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 安装已更新事件属性。
 *
 * @param version 版本号。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventInstallationUpdatedProperties {
  @JsonProperty("version")
  private final String version;

  /** 使用字段创建事件安装已更新属性。 */
  @JsonCreator
  public EventInstallationUpdatedProperties(
      @JsonProperty("version") String version
  ) {
    this.version = version;
  }

  /**
   * 获取版本。
   *
   * @return 版本号。
   */
  public String version() {
    return version;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventInstallationUpdatedProperties)) return false;
    EventInstallationUpdatedProperties that = (EventInstallationUpdatedProperties) other;
    return Objects.equals(version, that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version);
  }

  @Override
  public String toString() {
    return "EventInstallationUpdatedProperties{" +
        "version=" + version +
        "}";
  }
}
