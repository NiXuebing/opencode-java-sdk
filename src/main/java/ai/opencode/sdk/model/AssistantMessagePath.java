package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 助手消息路径数据模型。
 *
 * @param cwd 当前工作目录。
 * @param root 根目录路径。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AssistantMessagePath {
  @JsonProperty("cwd")
  private final String cwd;
  @JsonProperty("root")
  private final String root;

  /** 使用字段创建助手消息路径。 */
  @JsonCreator
  public AssistantMessagePath(
      @JsonProperty("cwd") String cwd,
      @JsonProperty("root") String root
  ) {
    this.cwd = cwd;
    this.root = root;
  }

  /**
   * 获取工作目录。
   *
   * @return 当前工作目录。
   */
  public String cwd() {
    return cwd;
  }

  /**
   * 获取根目录。
   *
   * @return 根目录路径。
   */
  public String root() {
    return root;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AssistantMessagePath)) return false;
    AssistantMessagePath that = (AssistantMessagePath) other;
    return Objects.equals(cwd, that.cwd)
        && Objects.equals(root, that.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cwd, root);
  }

  @Override
  public String toString() {
    return "AssistantMessagePath{" +
        "cwd=" + cwd + "," +
        "root=" + root +
        "}";
  }
}
