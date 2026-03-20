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
 * 提供商数据模型。
 *
 * @param id 唯一标识。
 * @param name 名称。
 * @param source 来源。
 * @param env 环境变量列表。
 * @param key 密钥。
 * @param options 扩展选项映射。
 * @param models 模型映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Provider {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("source")
  private final String source;
  @JsonProperty("env")
  private final List<String> env;
  @JsonProperty("key")
  private final String key;
  @JsonProperty("options")
  private final Map<String, JsonNode> options;
  @JsonProperty("models")
  private final Map<String, Model> models;

  /** 使用字段创建提供商。 */
  @JsonCreator
  public Provider(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("source") String source,
      @JsonProperty("env") List<String> env,
      @JsonProperty("key") String key,
      @JsonProperty("options") Map<String, JsonNode> options,
      @JsonProperty("models") Map<String, Model> models
  ) {
    this.id = id;
    this.name = name;
    this.source = source;
    this.env = env;
    this.key = key;
    this.options = options;
    this.models = models;
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
   * 获取来源。
   *
   * @return 来源。
   */
  public String source() {
    return source;
  }

  /**
   * 获取环境变量。
   *
   * @return 环境变量列表。
   */
  public List<String> env() {
    return env;
  }

  /**
   * 获取key。
   *
   * @return 密钥。
   */
  public String key() {
    return key;
  }

  /**
   * 获取选项。
   *
   * @return 扩展选项映射。
   */
  public Map<String, JsonNode> options() {
    return options;
  }

  /**
   * 获取模型。
   *
   * @return 模型映射。
   */
  public Map<String, Model> models() {
    return models;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Provider)) return false;
    Provider that = (Provider) other;
    return Objects.equals(id, that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(source, that.source)
        && Objects.equals(env, that.env)
        && Objects.equals(key, that.key)
        && Objects.equals(options, that.options)
        && Objects.equals(models, that.models);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, source, env, key, options, models);
  }

  @Override
  public String toString() {
    return "Provider{" +
        "id=" + id + "," +
        "name=" + name + "," +
        "source=" + source + "," +
        "env=" + env + "," +
        "key=" + key + "," +
        "options=" + options + "," +
        "models=" + models +
        "}";
  }
}
