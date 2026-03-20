package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 格式化器状态。
 *
 * @param name 名称。
 * @param extensions 扩展名列表。
 * @param enabled 是否启用。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FormatterStatus {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("extensions")
  private final List<String> extensions;
  @JsonProperty("enabled")
  private final Boolean enabled;

  /** 使用字段创建格式化器状态。 */
  @JsonCreator
  public FormatterStatus(
      @JsonProperty("name") String name,
      @JsonProperty("extensions") List<String> extensions,
      @JsonProperty("enabled") Boolean enabled
  ) {
    this.name = name;
    this.extensions = extensions;
    this.enabled = enabled;
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
   * 获取扩展名。
   *
   * @return 扩展名列表。
   */
  public List<String> extensions() {
    return extensions;
  }

  /**
   * 获取启用。
   *
   * @return 是否启用。
   */
  public Boolean enabled() {
    return enabled;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FormatterStatus)) return false;
    FormatterStatus that = (FormatterStatus) other;
    return Objects.equals(name, that.name)
        && Objects.equals(extensions, that.extensions)
        && Objects.equals(enabled, that.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, extensions, enabled);
  }

  @Override
  public String toString() {
    return "FormatterStatus{" +
        "name=" + name + "," +
        "extensions=" + extensions + "," +
        "enabled=" + enabled +
        "}";
  }
}
