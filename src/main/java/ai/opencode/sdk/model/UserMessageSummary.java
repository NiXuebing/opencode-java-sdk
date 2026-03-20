package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 用户消息摘要数据模型。
 *
 * @param title 标题。
 * @param body 请求体内容。
 * @param diffs 差异列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UserMessageSummary {
  @JsonProperty("title")
  private final String title;
  @JsonProperty("body")
  private final String body;
  @JsonProperty("diffs")
  private final List<FileDiff> diffs;

  /** 使用字段创建用户消息摘要。 */
  @JsonCreator
  public UserMessageSummary(
      @JsonProperty("title") String title,
      @JsonProperty("body") String body,
      @JsonProperty("diffs") List<FileDiff> diffs
  ) {
    this.title = title;
    this.body = body;
    this.diffs = diffs;
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
   * 获取请求体。
   *
   * @return 请求体内容。
   */
  public String body() {
    return body;
  }

  /**
   * 获取diffs。
   *
   * @return 差异列表。
   */
  public List<FileDiff> diffs() {
    return diffs;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof UserMessageSummary)) return false;
    UserMessageSummary that = (UserMessageSummary) other;
    return Objects.equals(title, that.title)
        && Objects.equals(body, that.body)
        && Objects.equals(diffs, that.diffs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, body, diffs);
  }

  @Override
  public String toString() {
    return "UserMessageSummary{" +
        "title=" + title + "," +
        "body=" + body + "," +
        "diffs=" + diffs +
        "}";
  }
}
