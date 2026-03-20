package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 会话初始化请求体。
 *
 * @param modelID 模型 ID。
 * @param providerID 目标提供商 ID。
 * @param messageID 目标消息 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionInitBody {
  @JsonProperty("modelID")
  private final String modelID;
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("messageID")
  private final String messageID;

  /** 使用字段创建会话初始化请求体。 */
  @JsonCreator
  public SessionInitBody(
      @JsonProperty("modelID") String modelID,
      @JsonProperty("providerID") String providerID,
      @JsonProperty("messageID") String messageID
  ) {
    this.modelID = modelID;
    this.providerID = providerID;
    this.messageID = messageID;
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

  /**
   * 获取消息ID。
   *
   * @return 目标消息 ID。
   */
  public String messageID() {
    return messageID;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionInitBody)) return false;
    SessionInitBody that = (SessionInitBody) other;
    return Objects.equals(modelID, that.modelID)
        && Objects.equals(providerID, that.providerID)
        && Objects.equals(messageID, that.messageID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelID, providerID, messageID);
  }

  @Override
  public String toString() {
    return "SessionInitBody{" +
        "modelID=" + modelID + "," +
        "providerID=" + providerID + "," +
        "messageID=" + messageID +
        "}";
  }
}
