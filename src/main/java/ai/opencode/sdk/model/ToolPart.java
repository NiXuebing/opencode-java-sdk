package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 工具片段数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param messageID 目标消息 ID。
 * @param type 类型标识。
 * @param callID 调用 ID。
 * @param tool 工具。
 * @param state 状态。
 * @param metadata 元数据映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolPart implements Part {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("messageID")
  private final String messageID;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("callID")
  private final String callID;
  @JsonProperty("tool")
  private final String tool;
  @JsonProperty("state")
  private final ToolState state;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;

  /** 使用字段创建工具片段。 */
  @JsonCreator
  public ToolPart(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("messageID") String messageID,
      @JsonProperty("type") String type,
      @JsonProperty("callID") String callID,
      @JsonProperty("tool") String tool,
      @JsonProperty("state") ToolState state,
      @JsonProperty("metadata") Map<String, JsonNode> metadata
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.messageID = messageID;
    this.type = type;
    this.callID = callID;
    this.tool = tool;
    this.state = state;
    this.metadata = metadata;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
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
   * 获取消息ID。
   *
   * @return 目标消息 ID。
   */
  public String messageID() {
    return messageID;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取调用ID。
   *
   * @return 调用 ID。
   */
  public String callID() {
    return callID;
  }

  /**
   * 获取工具。
   *
   * @return 工具。
   */
  public String tool() {
    return tool;
  }

  /**
   * 获取状态。
   *
   * @return 状态。
   */
  public ToolState state() {
    return state;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, JsonNode> metadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolPart)) return false;
    ToolPart that = (ToolPart) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(messageID, that.messageID)
        && Objects.equals(type, that.type)
        && Objects.equals(callID, that.callID)
        && Objects.equals(tool, that.tool)
        && Objects.equals(state, that.state)
        && Objects.equals(metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, messageID, type, callID, tool, state, metadata);
  }

  @Override
  public String toString() {
    return "ToolPart{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "messageID=" + messageID + "," +
        "type=" + type + "," +
        "callID=" + callID + "," +
        "tool=" + tool + "," +
        "state=" + state + "," +
        "metadata=" + metadata +
        "}";
  }
}
