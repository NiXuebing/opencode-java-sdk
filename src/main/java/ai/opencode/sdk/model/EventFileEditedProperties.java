package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件已编辑事件属性。
 *
 * @param file 文件信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventFileEditedProperties {
  @JsonProperty("file")
  private final String file;

  /** 使用字段创建事件文件已编辑属性。 */
  @JsonCreator
  public EventFileEditedProperties(
      @JsonProperty("file") String file
  ) {
    this.file = file;
  }

  /**
   * 获取文件。
   *
   * @return 文件信息。
   */
  public String file() {
    return file;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventFileEditedProperties)) return false;
    EventFileEditedProperties that = (EventFileEditedProperties) other;
    return Objects.equals(file, that.file);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file);
  }

  @Override
  public String toString() {
    return "EventFileEditedProperties{" +
        "file=" + file +
        "}";
  }
}
