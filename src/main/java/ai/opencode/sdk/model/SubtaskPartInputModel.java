package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 子任务片段输入模型数据模型。
 *
 * @param providerID 目标提供商 ID。
 * @param modelID 模型 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SubtaskPartInputModel {
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("modelID")
  private final String modelID;

  /** 使用字段创建子任务片段输入模型。 */
  @JsonCreator
  public SubtaskPartInputModel(
      @JsonProperty("providerID") String providerID,
      @JsonProperty("modelID") String modelID
  ) {
    this.providerID = providerID;
    this.modelID = modelID;
  }

  /**
   * 获取提供商ID。
   *
   * @return 目标提供商 ID。
   */
  public String providerID() {
    return providerID;
  }

  /**
   * 获取模型ID。
   *
   * @return 模型 ID。
   */
  public String modelID() {
    return modelID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SubtaskPartInputModel)) return false;
    SubtaskPartInputModel that = (SubtaskPartInputModel) other;
    return Objects.equals(providerID, that.providerID)
        && Objects.equals(modelID, that.modelID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(providerID, modelID);
  }

  @Override
  public String toString() {
    return "SubtaskPartInputModel{" +
        "providerID=" + providerID + "," +
        "modelID=" + modelID +
        "}";
  }
}
