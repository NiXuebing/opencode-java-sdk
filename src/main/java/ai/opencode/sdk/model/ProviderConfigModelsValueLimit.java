package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 提供商配置模型值限制数据模型。
 *
 * @param context 上下文。
 * @param input 输入。
 * @param output 输出。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ProviderConfigModelsValueLimit {
  @JsonProperty("context")
  private final Double context;
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;

  /** 使用字段创建提供商配置模型值限制。 */
  @JsonCreator
  public ProviderConfigModelsValueLimit(
      @JsonProperty("context") Double context,
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output
  ) {
    this.context = context;
    this.input = input;
    this.output = output;
  }

  /**
   * 获取上下文。
   *
   * @return 上下文。
   */
  public Double context() {
    return context;
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

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ProviderConfigModelsValueLimit)) return false;
    ProviderConfigModelsValueLimit that = (ProviderConfigModelsValueLimit) other;
    return Objects.equals(context, that.context)
        && Objects.equals(input, that.input)
        && Objects.equals(output, that.output);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, input, output);
  }

  @Override
  public String toString() {
    return "ProviderConfigModelsValueLimit{" +
        "context=" + context + "," +
        "input=" + input + "," +
        "output=" + output +
        "}";
  }
}
