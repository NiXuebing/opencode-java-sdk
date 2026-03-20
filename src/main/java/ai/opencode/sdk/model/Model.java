package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 模型数据模型。
 *
 * @param id 唯一标识。
 * @param providerID 目标提供商 ID。
 * @param api API。
 * @param name 名称。
 * @param family 家族。
 * @param capabilities 能力。
 * @param cost 成本。
 * @param limit 返回结果数量上限。
 * @param status 当前状态。
 * @param options 扩展选项映射。
 * @param headers 自定义请求头集合。
 * @param releaseDate 发布date。
 * @param variants 变体映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Model {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("providerID")
  private final String providerID;
  @JsonProperty("api")
  private final ModelApi api;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("family")
  private final String family;
  @JsonProperty("capabilities")
  private final ModelCapabilities capabilities;
  @JsonProperty("cost")
  private final ModelCost cost;
  @JsonProperty("limit")
  private final ModelLimit limit;
  @JsonProperty("status")
  private final String status;
  @JsonProperty("options")
  private final Map<String, JsonNode> options;
  @JsonProperty("headers")
  private final Map<String, String> headers;
  @JsonProperty("release_date")
  private final String releaseDate;
  @JsonProperty("variants")
  private final Map<String, Map<String, JsonNode>> variants;

  /** 使用字段创建模型。 */
  @JsonCreator
  public Model(
      @JsonProperty("id") String id,
      @JsonProperty("providerID") String providerID,
      @JsonProperty("api") ModelApi api,
      @JsonProperty("name") String name,
      @JsonProperty("family") String family,
      @JsonProperty("capabilities") ModelCapabilities capabilities,
      @JsonProperty("cost") ModelCost cost,
      @JsonProperty("limit") ModelLimit limit,
      @JsonProperty("status") String status,
      @JsonProperty("options") Map<String, JsonNode> options,
      @JsonProperty("headers") Map<String, String> headers,
      @JsonProperty("release_date") String releaseDate,
      @JsonProperty("variants") Map<String, Map<String, JsonNode>> variants
  ) {
    this.id = id;
    this.providerID = providerID;
    this.api = api;
    this.name = name;
    this.family = family;
    this.capabilities = capabilities;
    this.cost = cost;
    this.limit = limit;
    this.status = status;
    this.options = options;
    this.headers = headers;
    this.releaseDate = releaseDate;
    this.variants = variants;
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
   * 获取提供商ID。
   *
   * @return 目标提供商 ID。
   */
  public String providerID() {
    return providerID;
  }

  /**
   * 获取API。
   *
   * @return API。
   */
  public ModelApi api() {
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
   * 获取家族。
   *
   * @return 家族。
   */
  public String family() {
    return family;
  }

  /**
   * 获取能力。
   *
   * @return 能力。
   */
  public ModelCapabilities capabilities() {
    return capabilities;
  }

  /**
   * 获取成本。
   *
   * @return 成本。
   */
  public ModelCost cost() {
    return cost;
  }

  /**
   * 获取限制。
   *
   * @return 返回结果数量上限。
   */
  public ModelLimit limit() {
    return limit;
  }

  /**
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
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
   * 获取headers。
   *
   * @return 自定义请求头集合。
   */
  public Map<String, String> headers() {
    return headers;
  }

  /**
   * 获取发布date。
   *
   * @return 发布date。
   */
  public String releaseDate() {
    return releaseDate;
  }

  /**
   * 获取变体。
   *
   * @return 变体映射。
   */
  public Map<String, Map<String, JsonNode>> variants() {
    return variants;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Model)) return false;
    Model that = (Model) other;
    return Objects.equals(id, that.id)
        && Objects.equals(providerID, that.providerID)
        && Objects.equals(api, that.api)
        && Objects.equals(name, that.name)
        && Objects.equals(family, that.family)
        && Objects.equals(capabilities, that.capabilities)
        && Objects.equals(cost, that.cost)
        && Objects.equals(limit, that.limit)
        && Objects.equals(status, that.status)
        && Objects.equals(options, that.options)
        && Objects.equals(headers, that.headers)
        && Objects.equals(releaseDate, that.releaseDate)
        && Objects.equals(variants, that.variants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, providerID, api, name, family, capabilities, cost, limit, status, options, headers, releaseDate, variants);
  }

  @Override
  public String toString() {
    return "Model{" +
        "id=" + id + "," +
        "providerID=" + providerID + "," +
        "api=" + api + "," +
        "name=" + name + "," +
        "family=" + family + "," +
        "capabilities=" + capabilities + "," +
        "cost=" + cost + "," +
        "limit=" + limit + "," +
        "status=" + status + "," +
        "options=" + options + "," +
        "headers=" + headers + "," +
        "releaseDate=" + releaseDate + "," +
        "variants=" + variants +
        "}";
  }
}
