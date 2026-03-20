package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 提供商配置模型值模态数据模型。
 *
 * @param input 输入列表。
 * @param output 输出列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueModalities {
  @JsonProperty("input")
  private final List<String> input;
  @JsonProperty("output")
  private final List<String> output;

  /** 使用字段创建提供商配置模型值模态。 */
  @JsonCreator
  public ProviderConfigModelsValueModalities(
      @JsonProperty("input") List<String> input,
      @JsonProperty("output") List<String> output
  ) {
    this.input = input;
    this.output = output;
  }

  /**
   * 获取输入。
   *
   * @return 输入列表。
   */
  public List<String> input() {
    return input;
  }

  /**
   * 获取输出。
   *
   * @return 输出列表。
   */
  public List<String> output() {
    return output;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValueModalities)) return false;
    ProviderConfigModelsValueModalities that = (ProviderConfigModelsValueModalities) other;
    return Objects.equals(input, that.input)
        && Objects.equals(output, that.output);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, output);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueModalities{" +
        "input=" + input + "," +
        "output=" + output +
        "}";
  }
}
