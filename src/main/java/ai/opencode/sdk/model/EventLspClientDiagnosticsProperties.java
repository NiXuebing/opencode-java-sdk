package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * LSP客户端诊断事件属性。
 *
 * @param serverID 服务端 ID。
 * @param path 目标文件或目录路径。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EventLspClientDiagnosticsProperties {
  @JsonProperty("serverID")
  private final String serverID;
  @JsonProperty("path")
  private final String path;

  /** 使用字段创建事件LSP客户端诊断属性。 */
  @JsonCreator
  public EventLspClientDiagnosticsProperties(
      @JsonProperty("serverID") String serverID,
      @JsonProperty("path") String path
  ) {
    this.serverID = serverID;
    this.path = path;
  }

  /**
   * 获取服务端ID。
   *
   * @return 服务端 ID。
   */
  public String serverID() {
    return serverID;
  }

  /**
   * 获取路径。
   *
   * @return 目标文件或目录路径。
   */
  public String path() {
    return path;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof EventLspClientDiagnosticsProperties)) return false;
    EventLspClientDiagnosticsProperties that = (EventLspClientDiagnosticsProperties) other;
    return Objects.equals(serverID, that.serverID)
        && Objects.equals(path, that.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverID, path);
  }

  @Override
  public String toString() {
    return "EventLspClientDiagnosticsProperties{" +
        "serverID=" + serverID + "," +
        "path=" + path +
        "}";
  }
}
