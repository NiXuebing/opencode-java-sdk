package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商配置模型值成本数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cacheRead 缓存读取量。
 * @param cacheWrite 缓存写入量。
 * @param contextOver200k 超长上下文成本。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueCost {
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;
  @JsonProperty("cache_read")
  private final Double cacheRead;
  @JsonProperty("cache_write")
  private final Double cacheWrite;
  @JsonProperty("context_over_200k")
  private final ProviderConfigModelsValueCostContextOver200k contextOver200k;

  /** 使用字段创建提供商配置模型值成本。 */
  @JsonCreator
  public ProviderConfigModelsValueCost(
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output,
      @JsonProperty("cache_read") Double cacheRead,
      @JsonProperty("cache_write") Double cacheWrite,
      @JsonProperty("context_over_200k") ProviderConfigModelsValueCostContextOver200k contextOver200k
  ) {
    this.input = input;
    this.output = output;
    this.cacheRead = cacheRead;
    this.cacheWrite = cacheWrite;
    this.contextOver200k = contextOver200k;
  }

  /**
   * 获取输入。
   *
   * @return 输入。
   */
  public Double input() {
    return input;
  }

  /**
   * 获取输出。
   *
   * @return 输出。
   */
  public Double output() {
    return output;
  }

  /**
   * 获取缓存读取。
   *
   * @return 缓存读取量。
   */
  public Double cacheRead() {
    return cacheRead;
  }

  /**
   * 获取缓存写入。
   *
   * @return 缓存写入量。
   */
  public Double cacheWrite() {
    return cacheWrite;
  }

  /**
   * 获取上下文超长k。
   *
   * @return 超长上下文成本。
   */
  public ProviderConfigModelsValueCostContextOver200k contextOver200k() {
    return contextOver200k;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValueCost)) return false;
    ProviderConfigModelsValueCost that = (ProviderConfigModelsValueCost) other;
    return Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(cacheRead, that.cacheRead)
        && Objects.equals(cacheWrite, that.cacheWrite)
        && Objects.equals(contextOver200k, that.contextOver200k);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output, cacheRead, cacheWrite, contextOver200k);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueCost{" +
        "input=" + input + "," +
        "output=" + output + "," +
        "cacheRead=" + cacheRead + "," +
        "cacheWrite=" + cacheWrite + "," +
        "contextOver200k=" + contextOver200k +
        "}";
  }
}
