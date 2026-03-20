package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * LSP状态。
 *
 * @param id 唯一标识。
 * @param name 名称。
 * @param root 根目录路径。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class LSPStatus {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("root")
  private final String root;
  @JsonProperty("status")
  private final String status;

  /** 使用字段创建LSP状态。 */
  @JsonCreator
  public LSPStatus(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("root") String root,
      @JsonProperty("status") String status
  ) {
    this.id = id;
    this.name = name;
    this.root = root;
    this.status = status;
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
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  /**
   * 获取根目录。
   *
   * @return 根目录路径。
   */
  public String root() {
    return root;
  }

  /**
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof LSPStatus)) return false;
    LSPStatus that = (LSPStatus) other;
    return Objects.equals(id, that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(root, that.root)
        && Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, root, status);
  }

  @Override
  public String toString() {
    return "LSPStatus{" +
        "id=" + id + "," +
        "name=" + name + "," +
        "root=" + root + "," +
        "status=" + status +
        "}";
  }
}
