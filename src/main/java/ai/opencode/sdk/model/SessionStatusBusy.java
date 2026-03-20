package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话状态Busy数据模型。
 *
 * @param type 类型标识。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionStatusBusy implements SessionStatus {
  @JsonProperty("type")
  private final String type;

  /** 使用字段创建会话状态Busy。 */
  @JsonCreator
  public SessionStatusBusy(
      @JsonProperty("type") String type
  ) {
    this.type = type;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionStatusBusy)) return false;
    SessionStatusBusy that = (SessionStatusBusy) other;
    return Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    return "SessionStatusBusy{" +
        "type=" + type +
        "}";
  }
}
