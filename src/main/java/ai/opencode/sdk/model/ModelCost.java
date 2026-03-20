package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 模型成本数据模型。
 *
 * @param input 输入。
 * @param output 输出。
 * @param cache 缓存。
 * @param experimentalOver200K 实验性超长K。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelCost {
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;
  @JsonProperty("cache")
  private final ModelCostCache cache;
  @JsonProperty("experimentalOver200K")
  private final ModelCostExperimentalOver200K experimentalOver200K;

  /** 使用字段创建模型成本。 */
  @JsonCreator
  public ModelCost(
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output,
      @JsonProperty("cache") ModelCostCache cache,
      @JsonProperty("experimentalOver200K") ModelCostExperimentalOver200K experimentalOver200K
  ) {
    this.input = input;
    this.output = output;
    this.cache = cache;
    this.experimentalOver200K = experimentalOver200K;
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
  public ModelCostCache cache() {
    return cache;
  }

  /**
   * 获取实验性超长K。
   *
   * @return 实验性超长K。
   */
  public ModelCostExperimentalOver200K experimentalOver200K() {
    return experimentalOver200K;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelCost)) return false;
    ModelCost that = (ModelCost) other;
    return Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(cache, that.cache)
        && Objects.equals(experimentalOver200K, that.experimentalOver200K);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output, cache, experimentalOver200K);
  }

  @Override
  public String toString() {
    return "ModelCost{" +
        "input=" + input + "," +
        "output=" + output + "," +
        "cache=" + cache + "," +
        "experimentalOver200K=" + experimentalOver200K +
        "}";
  }
}
