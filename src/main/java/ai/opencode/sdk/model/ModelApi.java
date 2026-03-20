package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 模型API数据模型。
 *
 * @param id 唯一标识。
 * @param url 可访问的地址。
 * @param npm npm 包名。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelApi {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("url")
  private final String url;
  @JsonProperty("npm")
  private final String npm;

  /** 使用字段创建模型API。 */
  @JsonCreator
  public ModelApi(
      @JsonProperty("id") String id,
      @JsonProperty("url") String url,
      @JsonProperty("npm") String npm
  ) {
    this.id = id;
    this.url = url;
    this.npm = npm;
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
   * 获取地址。
   *
   * @return 可访问的地址。
   */
  public String url() {
    return url;
  }

  /**
   * 获取npm。
   *
   * @return npm 包名。
   */
  public String npm() {
    return npm;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelApi)) return false;
    ModelApi that = (ModelApi) other;
    return Objects.equals(id, that.id)
        && Objects.equals(url, that.url)
        && Objects.equals(npm, that.npm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, npm);
  }

  @Override
  public String toString() {
    return "ModelApi{" +
        "id=" + id + "," +
        "url=" + url + "," +
        "npm=" + npm +
        "}";
  }
}
