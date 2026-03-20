package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商配置模型值成本超长上下文数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cacheRead 缓存读取量。
 * @param cacheWrite 缓存写入量。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueCostContextOver200k {
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;
  @JsonProperty("cache_read")
  private final Double cacheRead;
  @JsonProperty("cache_write")
  private final Double cacheWrite;

  /** 使用字段创建提供商配置模型值成本上下文超长k。 */
  @JsonCreator
  public ProviderConfigModelsValueCostContextOver200k(
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output,
      @JsonProperty("cache_read") Double cacheRead,
      @JsonProperty("cache_write") Double cacheWrite
  ) {
    this.input = input;
    this.output = output;
    this.cacheRead = cacheRead;
    this.cacheWrite = cacheWrite;
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValueCostContextOver200k)) return false;
    ProviderConfigModelsValueCostContextOver200k that = (ProviderConfigModelsValueCostContextOver200k) other;
    return Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(cacheRead, that.cacheRead)
        && Objects.equals(cacheWrite, that.cacheWrite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output, cacheRead, cacheWrite);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueCostContextOver200k{" +
        "input=" + input + "," +
        "output=" + output + "," +
        "cacheRead=" + cacheRead + "," +
        "cacheWrite=" + cacheWrite +
        "}";
  }
}
