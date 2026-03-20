package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 会话差异事件属性。
 *
 * @param sessionID 目标会话 ID。
 * @param diff 差异列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventSessionDiffProperties {
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("diff")
  private final List<FileDiff> diff;

  /** 使用字段创建事件会话差异属性。 */
  @JsonCreator
  public EventSessionDiffProperties(
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("diff") List<FileDiff> diff
  ) {
    this.sessionID = sessionID;
    this.diff = diff;
  }

  /**
   * 获取会话ID。
   *
   * @return 目标会话 ID。
   */
  public String sessionID() {
    return sessionID;
  }

  /**
   * 获取差异。
   *
   * @return 差异列表。
   */
  public List<FileDiff> diff() {
    return diff;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventSessionDiffProperties)) return false;
    EventSessionDiffProperties that = (EventSessionDiffProperties) other;
    return Objects.equals(sessionID, that.sessionID)
        && Objects.equals(diff, that.diff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, diff);
  }

  @Override
  public String toString() {
    return "EventSessionDiffProperties{" +
        "sessionID=" + sessionID + "," +
        "diff=" + diff +
        "}";
  }
}
