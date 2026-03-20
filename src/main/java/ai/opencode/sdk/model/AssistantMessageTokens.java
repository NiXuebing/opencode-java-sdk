package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 助手消息令牌数据模型。
 *
 * @param total 总量。
 * @param input 输入。
 * @param output 输出。
 * @param reasoning 推理信息。
 * @param cache 缓存。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AssistantMessageTokens {
  @JsonProperty("total")
  private final Double total;
  @JsonProperty("input")
  private final Double input;
  @JsonProperty("output")
  private final Double output;
  @JsonProperty("reasoning")
  private final Double reasoning;
  @JsonProperty("cache")
  private final AssistantMessageTokensCache cache;

  /** 使用字段创建助手消息令牌。 */
  @JsonCreator
  public AssistantMessageTokens(
      @JsonProperty("total") Double total,
      @JsonProperty("input") Double input,
      @JsonProperty("output") Double output,
      @JsonProperty("reasoning") Double reasoning,
      @JsonProperty("cache") AssistantMessageTokensCache cache
  ) {
    this.total = total;
    this.input = input;
    this.output = output;
    this.reasoning = reasoning;
    this.cache = cache;
  }

  /**
   * 获取total。
   *
   * @return 总量。
   */
  public Double total() {
    return total;
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
   * 获取推理。
   *
   * @return 推理信息。
   */
  public Double reasoning() {
    return reasoning;
  }

  /**
   * 获取缓存。
   *
   * @return 缓存。
   */
  public AssistantMessageTokensCache cache() {
    return cache;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AssistantMessageTokens)) return false;
    AssistantMessageTokens that = (AssistantMessageTokens) other;
    return Objects.equals(total, that.total)
        && Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(reasoning, that.reasoning)
        && Objects.equals(cache, that.cache);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, input, output, reasoning, cache);
  }

  @Override
  public String toString() {
    return "AssistantMessageTokens{" +
        "total=" + total + "," +
        "input=" + input + "," +
        "output=" + output + "," +
        "reasoning=" + reasoning + "," +
        "cache=" + cache +
        "}";
  }
}
