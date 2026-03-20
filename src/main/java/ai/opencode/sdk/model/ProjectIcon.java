package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 项目Icon数据模型。
 *
 * @param url 可访问的地址。
 * @param override 覆盖配置。
 * @param color 颜色标识。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProjectIcon {
  @JsonProperty("url")
  private final String url;
  @JsonProperty("override")
  private final String override;
  @JsonProperty("color")
  private final String color;

  /** 使用字段创建项目Icon。 */
  @JsonCreator
  public ProjectIcon(
      @JsonProperty("url") String url,
      @JsonProperty("override") String override,
      @JsonProperty("color") String color
  ) {
    this.url = url;
    this.override = override;
    this.color = color;
  }

  /**
   * 获取地址。
   *
   * @return 可访问的地址。
   */
  public String url() {
    return url;
  }

  /**
   * 获取override。
   *
   * @return 覆盖配置。
   */
  public String override() {
    return override;
  }

  /**
   * 获取color。
   *
   * @return 颜色标识。
   */
  public String color() {
    return color;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProjectIcon)) return false;
    ProjectIcon that = (ProjectIcon) other;
    return Objects.equals(url, that.url)
        && Objects.equals(override, that.override)
        && Objects.equals(color, that.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, override, color);
  }

  @Override
  public String toString() {
    return "ProjectIcon{" +
        "url=" + url + "," +
        "override=" + override + "," +
        "color=" + color +
        "}";
  }
}
