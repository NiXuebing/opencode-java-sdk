package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 全局事件数据模型。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param payload 载荷。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class GlobalEvent {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("payload")
  private final Event payload;

  /** 使用字段创建全局事件。 */
  @JsonCreator
  public GlobalEvent(
      @JsonProperty("directory") String directory,
      @JsonProperty("payload") Event payload
  ) {
    this.directory = directory;
    this.payload = payload;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  /**
   * 获取载荷。
   *
   * @return 载荷。
   */
  public Event payload() {
    return payload;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof GlobalEvent)) return false;
    GlobalEvent that = (GlobalEvent) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(payload, that.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, payload);
  }

  @Override
  public String toString() {
    return "GlobalEvent{" +
        "directory=" + directory + "," +
        "payload=" + payload +
        "}";
  }
}
