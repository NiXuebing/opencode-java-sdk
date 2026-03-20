package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 服务端实例已释放事件属性。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventServerInstanceDisposedProperties {
  @JsonProperty("directory")
  private final String directory;

  /** 使用字段创建事件服务端实例已释放属性。 */
  @JsonCreator
  public EventServerInstanceDisposedProperties(
      @JsonProperty("directory") String directory
  ) {
    this.directory = directory;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventServerInstanceDisposedProperties)) return false;
    EventServerInstanceDisposedProperties that = (EventServerInstanceDisposedProperties) other;
    return Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory);
  }

  @Override
  public String toString() {
    return "EventServerInstanceDisposedProperties{" +
        "directory=" + directory +
        "}";
  }
}
