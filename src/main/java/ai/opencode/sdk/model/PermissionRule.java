package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 权限Rule数据模型。
 *
 * @param permission 权限配置。
 * @param pattern 匹配模式。
 * @param action action。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionRule {
  @JsonProperty("permission")
  private final String permission;
  @JsonProperty("pattern")
  private final String pattern;
  @JsonProperty("action")
  private final PermissionAction action;

  /** 使用字段创建权限Rule。 */
  @JsonCreator
  public PermissionRule(
      @JsonProperty("permission") String permission,
      @JsonProperty("pattern") String pattern,
      @JsonProperty("action") PermissionAction action
  ) {
    this.permission = permission;
    this.pattern = pattern;
    this.action = action;
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
   * 获取pattern。
   *
   * @return 匹配模式。
   */
  public String pattern() {
    return pattern;
  }

  /**
   * 获取action。
   *
   * @return action。
   */
  public PermissionAction action() {
    return action;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionRule)) return false;
    PermissionRule that = (PermissionRule) other;
    return Objects.equals(permission, that.permission)
        && Objects.equals(pattern, that.pattern)
        && Objects.equals(action, that.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permission, pattern, action);
  }

  @Override
  public String toString() {
    return "PermissionRule{" +
        "permission=" + permission + "," +
        "pattern=" + pattern + "," +
        "action=" + action +
        "}";
  }
}
