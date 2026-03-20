package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 模型成本实验性超长K数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cache 缓存。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelCostExperimentalOver200K {
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;
  @JsonProperty("cache")
  private final ModelCostExperimentalOver200KCache cache;

  /** 使用字段创建模型成本实验性超长K。 */
  @JsonCreator
  public ModelCostExperimentalOver200K(
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output,
      @JsonProperty("cache") ModelCostExperimentalOver200KCache cache
  ) {
    this.input = input;
    this.output = output;
    this.cache = cache;
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
   * 获取缓存。
   *
   * @return 缓存。
   */
  public ModelCostExperimentalOver200KCache cache() {
    return cache;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelCostExperimentalOver200K)) return false;
    ModelCostExperimentalOver200K that = (ModelCostExperimentalOver200K) other;
    return Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(cache, that.cache);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output, cache);
  }

  @Override
  public String toString() {
    return "ModelCostExperimentalOver200K{" +
        "input=" + input + "," +
        "output=" + output + "," +
        "cache=" + cache +
        "}";
  }
}
