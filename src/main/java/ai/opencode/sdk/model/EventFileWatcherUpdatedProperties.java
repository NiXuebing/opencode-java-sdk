package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 文件监听器已更新事件属性。
 *
 * @param file 文件信息。
 * @param event 事件名称。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventFileWatcherUpdatedProperties {
  @JsonProperty("file")
  private final String file;
  @JsonProperty("event")
  private final String event;

  /** 使用字段创建事件文件监听器已更新属性。 */
  @JsonCreator
  public EventFileWatcherUpdatedProperties(
      @JsonProperty("file") String file,
      @JsonProperty("event") String event
  ) {
    this.file = file;
    this.event = event;
  }

  /**
   * 获取文件。
   *
   * @return 文件信息。
   */
  public String file() {
    return file;
  }

  /**
   * 获取事件。
   *
   * @return 事件名称。
   */
  public String event() {
    return event;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventFileWatcherUpdatedProperties)) return false;
    EventFileWatcherUpdatedProperties that = (EventFileWatcherUpdatedProperties) other;
    return Objects.equals(file, that.file)
        && Objects.equals(event, that.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, event);
  }

  @Override
  public String toString() {
    return "EventFileWatcherUpdatedProperties{" +
        "file=" + file + "," +
        "event=" + event +
        "}";
  }
}
