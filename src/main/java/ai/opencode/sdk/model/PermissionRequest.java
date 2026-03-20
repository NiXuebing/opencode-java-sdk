package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 权限请求数据模型。
 *
 * @param id 唯一标识。
 * @param sessionID 目标会话 ID。
 * @param permission 权限配置。
 * @param patterns patterns列表。
 * @param metadata 元数据映射。
 * @param always always列表。
 * @param tool 工具。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionRequest {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("sessionID")
  private final String sessionID;
  @JsonProperty("permission")
  private final String permission;
  @JsonProperty("patterns")
  private final List<String> patterns;
  @JsonProperty("metadata")
  private final Map<String, JsonNode> metadata;
  @JsonProperty("always")
  private final List<String> always;
  @JsonProperty("tool")
  private final PermissionRequestTool tool;

  /** 使用字段创建权限请求。 */
  @JsonCreator
  public PermissionRequest(
      @JsonProperty("id") String id,
      @JsonProperty("sessionID") String sessionID,
      @JsonProperty("permission") String permission,
      @JsonProperty("patterns") List<String> patterns,
      @JsonProperty("metadata") Map<String, JsonNode> metadata,
      @JsonProperty("always") List<String> always,
      @JsonProperty("tool") PermissionRequestTool tool
  ) {
    this.id = id;
    this.sessionID = sessionID;
    this.permission = permission;
    this.patterns = patterns;
    this.metadata = metadata;
    this.always = always;
    this.tool = tool;
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
   * 获取权限。
   *
   * @return 权限配置。
   */
  public String permission() {
    return permission;
  }

  /**
   * 获取patterns。
   *
   * @return patterns列表。
   */
  public List<String> patterns() {
    return patterns;
  }

  /**
   * 获取metadata。
   *
   * @return 元数据映射。
   */
  public Map<String, JsonNode> metadata() {
    return metadata;
  }

  /**
   * 获取always。
   *
   * @return always列表。
   */
  public List<String> always() {
    return always;
  }

  /**
   * 获取工具。
   *
   * @return 工具。
   */
  public PermissionRequestTool tool() {
    return tool;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionRequest)) return false;
    PermissionRequest that = (PermissionRequest) other;
    return Objects.equals(id, that.id)
        && Objects.equals(sessionID, that.sessionID)
        && Objects.equals(permission, that.permission)
        && Objects.equals(patterns, that.patterns)
        && Objects.equals(metadata, that.metadata)
        && Objects.equals(always, that.always)
        && Objects.equals(tool, that.tool);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sessionID, permission, patterns, metadata, always, tool);
  }

  @Override
  public String toString() {
    return "PermissionRequest{" +
        "id=" + id + "," +
        "sessionID=" + sessionID + "," +
        "permission=" + permission + "," +
        "patterns=" + patterns + "," +
        "metadata=" + metadata + "," +
        "always=" + always + "," +
        "tool=" + tool +
        "}";
  }
}
