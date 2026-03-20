package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话时间数据模型。
 *
 * @param created 已创建。
 * @param updated 已更新。
 * @param compacting compacting。
 * @param archived 归档时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionTime {
  @JsonProperty("created")
  private final Double created;
  @JsonProperty("updated")
  private final Double updated;
  @JsonProperty("compacting")
  private final Double compacting;
  @JsonProperty("archived")
  private final Double archived;

  /** 使用字段创建会话时间。 */
  @JsonCreator
  public SessionTime(
      @JsonProperty("created") Double created,
      @JsonProperty("updated") Double updated,
      @JsonProperty("compacting") Double compacting,
      @JsonProperty("archived") Double archived
  ) {
    this.created = created;
    this.updated = updated;
    this.compacting = compacting;
    this.archived = archived;
  }

  /**
   * 获取已创建。
   *
   * @return 已创建。
   */
  public Double created() {
    return created;
  }

  /**
   * 获取已更新。
   *
   * @return 已更新。
   */
  public Double updated() {
    return updated;
  }

  /**
   * 获取compacting。
   *
   * @return compacting。
   */
  public Double compacting() {
    return compacting;
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
    if (!(other instanceof SessionTime)) return false;
    SessionTime that = (SessionTime) other;
    return Objects.equals(created, that.created)
        && Objects.equals(updated, that.updated)
        && Objects.equals(compacting, that.compacting)
        && Objects.equals(archived, that.archived);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, updated, compacting, archived);
  }

  @Override
  public String toString() {
    return "SessionTime{" +
        "created=" + created + "," +
        "updated=" + updated + "," +
        "compacting=" + compacting + "," +
        "archived=" + archived +
        "}";
  }
}
