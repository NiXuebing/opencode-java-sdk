package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话更新请求体。
 *
 * @param title 标题。
 * @param time 时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionUpdateBody {
  @JsonProperty("title")
  private final String title;
  @JsonProperty("time")
  private final SessionUpdateBodyTime time;

  /** 使用字段创建会话更新请求体。 */
  @JsonCreator
  public SessionUpdateBody(
      @JsonProperty("title") String title,
      @JsonProperty("time") SessionUpdateBodyTime time
  ) {
    this.title = title;
    this.time = time;
  }

  /**
   * 获取title。
   *
   * @return 标题。
   */
  public String title() {
    return title;
  }

  /**
   * 获取时间。
   *
   * @return 时间。
   */
  public SessionUpdateBodyTime time() {
    return time;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionUpdateBody)) return false;
    SessionUpdateBody that = (SessionUpdateBody) other;
    return Objects.equals(title, that.title)
        && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, time);
  }

  @Override
  public String toString() {
    return "SessionUpdateBody{" +
        "title=" + title + "," +
        "time=" + time +
        "}";
  }
}
