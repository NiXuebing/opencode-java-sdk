package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 提供商配置。
 *
 * @param api API。
 * @param name 名称。
 * @param env 环境变量列表。
 * @param id 唯一标识。
 * @param npm npm 包名。
 * @param models 模型映射。
 * @param whitelist 白名单列表。
 * @param blacklist blacklist列表。
 * @param options 扩展选项映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfig {
  @JsonProperty("api")
  private final String api;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("env")
  private final List<String> env;
  @JsonProperty("id")
  private final String id;
  @JsonProperty("npm")
  private final String npm;
  @JsonProperty("models")
  private final Map<String, ProviderConfigModelsValue> models;
  @JsonProperty("whitelist")
  private final List<String> whitelist;
  @JsonProperty("blacklist")
  private final List<String> blacklist;
  @JsonProperty("options")
  private final ProviderConfigOptions options;

  /** 使用字段创建提供商配置。 */
  @JsonCreator
  public ProviderConfig(
      @JsonProperty("api") String api,
      @JsonProperty("name") String name,
      @JsonProperty("env") List<String> env,
      @JsonProperty("id") String id,
      @JsonProperty("npm") String npm,
      @JsonProperty("models") Map<String, ProviderConfigModelsValue> models,
      @JsonProperty("whitelist") List<String> whitelist,
      @JsonProperty("blacklist") List<String> blacklist,
      @JsonProperty("options") ProviderConfigOptions options
  ) {
    this.api = api;
    this.name = name;
    this.env = env;
    this.id = id;
    this.npm = npm;
    this.models = models;
    this.whitelist = whitelist;
    this.blacklist = blacklist;
    this.options = options;
  }

  /**
   * 获取API。
   *
   * @return API。
   */
  public String api() {
    return api;
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
   * 获取环境变量。
   *
   * @return 环境变量列表。
   */
  public List<String> env() {
    return env;
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
   * 获取npm。
   *
   * @return npm 包名。
   */
  public String npm() {
    return npm;
  }

  /**
   * 获取模型。
   *
   * @return 模型映射。
   */
  public Map<String, ProviderConfigModelsValue> models() {
    return models;
  }

  /**
   * 获取白名单。
   *
   * @return 白名单列表。
   */
  public List<String> whitelist() {
    return whitelist;
  }

  /**
   * 获取blacklist。
   *
   * @return blacklist列表。
   */
  public List<String> blacklist() {
    return blacklist;
  }

  /**
   * 获取选项。
   *
   * @return 扩展选项映射。
   */
  public ProviderConfigOptions options() {
    return options;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfig)) return false;
    ProviderConfig that = (ProviderConfig) other;
    return Objects.equals(api, that.api)
        && Objects.equals(name, that.name)
        && Objects.equals(env, that.env)
        && Objects.equals(id, that.id)
        && Objects.equals(npm, that.npm)
        && Objects.equals(models, that.models)
        && Objects.equals(whitelist, that.whitelist)
        && Objects.equals(blacklist, that.blacklist)
        && Objects.equals(options, that.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(api, name, env, id, npm, models, whitelist, blacklist, options);
  }

  @Override
  public String toString() {
    return "ProviderConfig{" +
        "api=" + api + "," +
        "name=" + name + "," +
        "env=" + env + "," +
        "id=" + id + "," +
        "npm=" + npm + "," +
        "models=" + models + "," +
        "whitelist=" + whitelist + "," +
        "blacklist=" + blacklist + "," +
        "options=" + options +
        "}";
  }
}
