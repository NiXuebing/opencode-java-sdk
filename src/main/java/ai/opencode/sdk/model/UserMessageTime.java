package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 用户消息时间数据模型。
 *
 * @param created 已创建。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class UserMessageTime {
  @JsonProperty("created")
  private final Double created;

  /** 使用字段创建用户消息时间。 */
  @JsonCreator
  public UserMessageTime(
      @JsonProperty("created") Double created
  ) {
    this.created = created;
  }

  /**
   * 获取已创建。
   *
   * @return 已创建。
   */
  public Double created() {
    return created;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof UserMessageTime)) return false;
    UserMessageTime that = (UserMessageTime) other;
    return Objects.equals(created, that.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created);
  }

  @Override
  public String toString() {
    return "UserMessageTime{" +
        "created=" + created +
        "}";
  }
}
