package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商认证错误详情。
 *
 * @param providerID 目标提供商 ID。
 * @param message 消息内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderAuthErrorData {
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("message")
  private final String message;

  /** 使用字段创建提供商认证错误数据。 */
  @JsonCreator
  public ProviderAuthErrorData(
      @JsonProperty("providerID") String providerID,
      @JsonProperty("message") String message
  ) {
    this.providerID = providerID;
    this.message = message;
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
   * 获取消息。
   *
   * @return 消息内容。
   */
  public String message() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderAuthErrorData)) return false;
    ProviderAuthErrorData that = (ProviderAuthErrorData) other;
    return Objects.equals(providerID, that.providerID)
        && Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(providerID, message);
  }

  @Override
  public String toString() {
    return "ProviderAuthErrorData{" +
        "providerID=" + providerID + "," +
        "message=" + message +
        "}";
  }
}
