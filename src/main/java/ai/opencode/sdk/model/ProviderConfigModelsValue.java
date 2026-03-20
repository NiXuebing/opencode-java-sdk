package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 提供商配置模型值数据模型。
 *
 * @param id 唯一标识。
 * @param name 名称。
 * @param family 家族。
 * @param releaseDate 发布date。
 * @param attachment 是否支持附件。
 * @param reasoning 是否支持推理。
 * @param temperature 采样温度。
 * @param toolCall 是否支持工具调用。
 * @param interleaved 交错。
 * @param cost 成本。
 * @param limit 返回结果数量上限。
 * @param modalities 模态。
 * @param experimental 实验性标记。
 * @param status 当前状态。
 * @param options 扩展选项映射。
 * @param headers 自定义请求头集合。
 * @param provider 提供商配置。
 * @param variants 变体映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValue {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("family")
  private final String family;
  @JsonProperty("release_date")
  private final String releaseDate;
  @JsonProperty("attachment")
  private final Boolean attachment;
  @JsonProperty("reasoning")
  private final Boolean reasoning;
  @JsonProperty("temperature")
  private final Boolean temperature;
  @JsonProperty("tool_call")
  private final Boolean toolCall;
  @JsonProperty("interleaved")
  private final JsonNode interleaved;
  @JsonProperty("cost")
  private final ProviderConfigModelsValueCost cost;
  @JsonProperty("limit")
  private final ProviderConfigModelsValueLimit limit;
  @JsonProperty("modalities")
  private final ProviderConfigModelsValueModalities modalities;
  @JsonProperty("experimental")
  private final Boolean experimental;
  @JsonProperty("status")
  private final String status;
  @JsonProperty("options")
  private final Map<String, JsonNode> options;
  @JsonProperty("headers")
  private final Map<String, String> headers;
  @JsonProperty("provider")
  private final ProviderConfigModelsValueProvider provider;
  @JsonProperty("variants")
  private final Map<String, ProviderConfigModelsValueVariantsValue> variants;

  /** 使用字段创建提供商配置模型值。 */
  @JsonCreator
  public ProviderConfigModelsValue(
      @JsonProperty("id") String id,
      @JsonProperty("name") String name,
      @JsonProperty("family") String family,
      @JsonProperty("release_date") String releaseDate,
      @JsonProperty("attachment") Boolean attachment,
      @JsonProperty("reasoning") Boolean reasoning,
      @JsonProperty("temperature") Boolean temperature,
      @JsonProperty("tool_call") Boolean toolCall,
      @JsonProperty("interleaved") JsonNode interleaved,
      @JsonProperty("cost") ProviderConfigModelsValueCost cost,
      @JsonProperty("limit") ProviderConfigModelsValueLimit limit,
      @JsonProperty("modalities") ProviderConfigModelsValueModalities modalities,
      @JsonProperty("experimental") Boolean experimental,
      @JsonProperty("status") String status,
      @JsonProperty("options") Map<String, JsonNode> options,
      @JsonProperty("headers") Map<String, String> headers,
      @JsonProperty("provider") ProviderConfigModelsValueProvider provider,
      @JsonProperty("variants") Map<String, ProviderConfigModelsValueVariantsValue> variants
  ) {
    this.id = id;
    this.name = name;
    this.family = family;
    this.releaseDate = releaseDate;
    this.attachment = attachment;
    this.reasoning = reasoning;
    this.temperature = temperature;
    this.toolCall = toolCall;
    this.interleaved = interleaved;
    this.cost = cost;
    this.limit = limit;
    this.modalities = modalities;
    this.experimental = experimental;
    this.status = status;
    this.options = options;
    this.headers = headers;
    this.provider = provider;
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
   * 获取发布date。
   *
   * @return 发布date。
   */
  public String releaseDate() {
    return releaseDate;
  }

  /**
   * 获取附件。
   *
   * @return 是否支持附件。
   */
  public Boolean attachment() {
    return attachment;
  }

  /**
   * 获取推理。
   *
   * @return 是否支持推理。
   */
  public Boolean reasoning() {
    return reasoning;
  }

  /**
   * 获取温度。
   *
   * @return 采样温度。
   */
  public Boolean temperature() {
    return temperature;
  }

  /**
   * 获取工具调用。
   *
   * @return 是否支持工具调用。
   */
  public Boolean toolCall() {
    return toolCall;
  }

  /**
   * 获取交错。
   *
   * @return 交错。
   */
  public JsonNode interleaved() {
    return interleaved;
  }

  /**
   * 获取成本。
   *
   * @return 成本。
   */
  public ProviderConfigModelsValueCost cost() {
    return cost;
  }

  /**
   * 获取限制。
   *
   * @return 返回结果数量上限。
   */
  public ProviderConfigModelsValueLimit limit() {
    return limit;
  }

  /**
   * 获取模态。
   *
   * @return 模态。
   */
  public ProviderConfigModelsValueModalities modalities() {
    return modalities;
  }

  /**
   * 获取实验性。
   *
   * @return 实验性标记。
   */
  public Boolean experimental() {
    return experimental;
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
   * 获取提供商。
   *
   * @return 提供商配置。
   */
  public ProviderConfigModelsValueProvider provider() {
    return provider;
  }

  /**
   * 获取变体。
   *
   * @return 变体映射。
   */
  public Map<String, ProviderConfigModelsValueVariantsValue> variants() {
    return variants;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValue)) return false;
    ProviderConfigModelsValue that = (ProviderConfigModelsValue) other;
    return Objects.equals(id, that.id)
        && Objects.equals(name, that.name)
        && Objects.equals(family, that.family)
        && Objects.equals(releaseDate, that.releaseDate)
        && Objects.equals(attachment, that.attachment)
        && Objects.equals(reasoning, that.reasoning)
        && Objects.equals(temperature, that.temperature)
        && Objects.equals(toolCall, that.toolCall)
        && Objects.equals(interleaved, that.interleaved)
        && Objects.equals(cost, that.cost)
        && Objects.equals(limit, that.limit)
        && Objects.equals(modalities, that.modalities)
        && Objects.equals(experimental, that.experimental)
        && Objects.equals(status, that.status)
        && Objects.equals(options, that.options)
        && Objects.equals(headers, that.headers)
        && Objects.equals(provider, that.provider)
        && Objects.equals(variants, that.variants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, family, releaseDate, attachment, reasoning, temperature, toolCall, interleaved, cost, limit, modalities, experimental, status, options, headers, provider, variants);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValue{" +
        "id=" + id + "," +
        "name=" + name + "," +
        "family=" + family + "," +
        "releaseDate=" + releaseDate + "," +
        "attachment=" + attachment + "," +
        "reasoning=" + reasoning + "," +
        "temperature=" + temperature + "," +
        "toolCall=" + toolCall + "," +
        "interleaved=" + interleaved + "," +
        "cost=" + cost + "," +
        "limit=" + limit + "," +
        "modalities=" + modalities + "," +
        "experimental=" + experimental + "," +
        "status=" + status + "," +
        "options=" + options + "," +
        "headers=" + headers + "," +
        "provider=" + provider + "," +
        "variants=" + variants +
        "}";
  }
}
