package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 配置技能数据模型。
 *
 * @param paths 路径列表。
 * @param urls 地址列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigSkills {
  @JsonProperty("paths")
  private final List<String> paths;
  @JsonProperty("urls")
  private final List<String> urls;

  /** 使用字段创建配置技能。 */
  @JsonCreator
  public ConfigSkills(
      @JsonProperty("paths") List<String> paths,
      @JsonProperty("urls") List<String> urls
  ) {
    this.paths = paths;
    this.urls = urls;
  }

  /**
   * 获取路径。
   *
   * @return 路径列表。
   */
  public List<String> paths() {
    return paths;
  }

  /**
   * 获取地址。
   *
   * @return 地址列表。
   */
  public List<String> urls() {
    return urls;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigSkills)) return false;
    ConfigSkills that = (ConfigSkills) other;
    return Objects.equals(paths, that.paths)
        && Objects.equals(urls, that.urls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paths, urls);
  }

  @Override
  public String toString() {
    return "ConfigSkills{" +
        "paths=" + paths + "," +
        "urls=" + urls +
        "}";
  }
}
