package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话更新请求体时间数据模型。
 *
 * @param archived 归档时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionUpdateBodyTime {
  @JsonProperty("archived")
  private final Double archived;

  /** 使用字段创建会话更新请求体时间。 */
  @JsonCreator
  public SessionUpdateBodyTime(
      @JsonProperty("archived") Double archived
  ) {
    this.archived = archived;
  }

  /**
   * 获取archived。
   *
   * @return 归档时间。
   */
  public Double archived() {
    return archived;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionUpdateBodyTime)) return false;
    SessionUpdateBodyTime that = (SessionUpdateBodyTime) other;
    return Objects.equals(archived, that.archived);
  }

  @Override
  public int hashCode() {
    return Objects.hash(archived);
  }

  @Override
  public String toString() {
    return "SessionUpdateBodyTime{" +
        "archived=" + archived +
        "}";
  }
}
