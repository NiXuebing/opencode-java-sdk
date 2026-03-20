package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 项目时间数据模型。
 *
 * @param created 已创建。
 * @param updated 已更新。
 * @param initialized 初始化时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProjectTime {
  @JsonProperty("created")
  private final Double created;
  @JsonProperty("updated")
  private final Double updated;
  @JsonProperty("initialized")
  private final Double initialized;

  /** 使用字段创建项目时间。 */
  @JsonCreator
  public ProjectTime(
      @JsonProperty("created") Double created,
      @JsonProperty("updated") Double updated,
      @JsonProperty("initialized") Double initialized
  ) {
    this.created = created;
    this.updated = updated;
    this.initialized = initialized;
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
   * 获取initialized。
   *
   * @return 初始化时间。
   */
  public Double initialized() {
    return initialized;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProjectTime)) return false;
    ProjectTime that = (ProjectTime) other;
    return Objects.equals(created, that.created)
        && Objects.equals(updated, that.updated)
        && Objects.equals(initialized, that.initialized);
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, updated, initialized);
  }

  @Override
  public String toString() {
    return "ProjectTime{" +
        "created=" + created + "," +
        "updated=" + updated + "," +
        "initialized=" + initialized +
        "}";
  }
}
