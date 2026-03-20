package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 会话命令响应数据。
 *
 * @param info 元信息。
 * @param parts 片段列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SessionCommandResponse {
  @JsonProperty("info")
  private final AssistantMessage info;
  @JsonProperty("parts")
  private final List<Part> parts;

  /** 使用字段创建会话命令响应。 */
  @JsonCreator
  public SessionCommandResponse(
      @JsonProperty("info") AssistantMessage info,
      @JsonProperty("parts") List<Part> parts
  ) {
    this.info = info;
    this.parts = parts;
  }

  /**
   * 获取信息。
   *
   * @return 元信息。
   */
  public AssistantMessage info() {
    return info;
  }

  /**
   * 获取片段。
   *
   * @return 片段列表。
   */
  public List<Part> parts() {
    return parts;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof SessionCommandResponse)) return false;
    SessionCommandResponse that = (SessionCommandResponse) other;
    return Objects.equals(info, that.info)
        && Objects.equals(parts, that.parts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(info, parts);
  }

  @Override
  public String toString() {
    return "SessionCommandResponse{" +
        "info=" + info + "," +
        "parts=" + parts +
        "}";
  }
}
