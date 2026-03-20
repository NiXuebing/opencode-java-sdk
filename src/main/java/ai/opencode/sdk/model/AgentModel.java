package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 代理模型数据模型。
 *
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AgentModel {
  @JsonProperty("modelID")
  private final String modelID;
  @JsonProperty("providerID")
  private final String providerID;

  /** 使用字段创建代理模型。 */
  @JsonCreator
  public AgentModel(
      @JsonProperty("modelID") String modelID,
      @JsonProperty("providerID") String providerID
  ) {
    this.modelID = modelID;
    this.providerID = providerID;
  }

  /**
   * 获取模型ID。
   *
   * @return 模型 ID。
   */
  public String modelID() {
    return modelID;
  }

  /**
   * 获取提供商ID。
   *
   * @return 目标提供商 ID。
   */
  public String providerID() {
    return providerID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AgentModel)) return false;
    AgentModel that = (AgentModel) other;
    return Objects.equals(modelID, that.modelID)
        && Objects.equals(providerID, that.providerID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelID, providerID);
  }

  @Override
  public String toString() {
    return "AgentModel{" +
        "modelID=" + modelID + "," +
        "providerID=" + providerID +
        "}";
  }
}
