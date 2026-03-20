package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话总结请求体。
 *
 * @param providerID 目标提供商 ID。
 * @param modelID 模型 ID。
 * @param auto 是否自动执行。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionSummarizeBody {
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("modelID")
  private final String modelID;
  @JsonProperty("auto")
  private final Boolean auto;

  /** 使用字段创建会话总结请求体。 */
  @JsonCreator
  public SessionSummarizeBody(
      @JsonProperty("providerID") String providerID,
      @JsonProperty("modelID") String modelID,
      @JsonProperty("auto") Boolean auto
  ) {
    this.providerID = providerID;
    this.modelID = modelID;
    this.auto = auto;
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

  /**
   * 获取自动。
   *
   * @return 是否自动执行。
   */
  public Boolean auto() {
    return auto;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionSummarizeBody)) return false;
    SessionSummarizeBody that = (SessionSummarizeBody) other;
    return Objects.equals(providerID, that.providerID)
        && Objects.equals(modelID, that.modelID)
        && Objects.equals(auto, that.auto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(providerID, modelID, auto);
  }

  @Override
  public String toString() {
    return "SessionSummarizeBody{" +
        "providerID=" + providerID + "," +
        "modelID=" + modelID + "," +
        "auto=" + auto +
        "}";
  }
}
