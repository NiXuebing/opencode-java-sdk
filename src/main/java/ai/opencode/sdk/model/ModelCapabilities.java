package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

/**
 * 模型能力数据模型。
 *
 * @param temperature 采样温度。
 * @param reasoning 是否支持推理。
 * @param attachment 是否支持附件。
 * @param toolcall 是否支持工具调用。
 * @param input 输入。
 * @param output 输出。
 * @param interleaved 交错。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelCapabilities {
  @JsonProperty("temperature")
  private final Boolean temperature;
  @JsonProperty("reasoning")
  private final Boolean reasoning;
  @JsonProperty("attachment")
  private final Boolean attachment;
  @JsonProperty("toolcall")
  private final Boolean toolcall;
  @JsonProperty("input")
  private final ModelCapabilitiesInput input;
  @JsonProperty("output")
  private final ModelCapabilitiesOutput output;
  @JsonProperty("interleaved")
  private final JsonNode interleaved;

  /** 使用字段创建模型能力。 */
  @JsonCreator
  public ModelCapabilities(
      @JsonProperty("temperature") Boolean temperature,
      @JsonProperty("reasoning") Boolean reasoning,
      @JsonProperty("attachment") Boolean attachment,
      @JsonProperty("toolcall") Boolean toolcall,
      @JsonProperty("input") ModelCapabilitiesInput input,
      @JsonProperty("output") ModelCapabilitiesOutput output,
      @JsonProperty("interleaved") JsonNode interleaved
  ) {
    this.temperature = temperature;
    this.reasoning = reasoning;
    this.attachment = attachment;
    this.toolcall = toolcall;
    this.input = input;
    this.output = output;
    this.interleaved = interleaved;
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
   * 获取推理。
   *
   * @return 是否支持推理。
   */
  public Boolean reasoning() {
    return reasoning;
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
   * 获取toolcall。
   *
   * @return 是否支持工具调用。
   */
  public Boolean toolcall() {
    return toolcall;
  }

  /**
   * 获取输入。
   *
   * @return 输入。
   */
  public ModelCapabilitiesInput input() {
    return input;
  }

  /**
   * 获取输出。
   *
   * @return 输出。
   */
  public ModelCapabilitiesOutput output() {
    return output;
  }

  /**
   * 获取交错。
   *
   * @return 交错。
   */
  public JsonNode interleaved() {
    return interleaved;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelCapabilities)) return false;
    ModelCapabilities that = (ModelCapabilities) other;
    return Objects.equals(temperature, that.temperature)
        && Objects.equals(reasoning, that.reasoning)
        && Objects.equals(attachment, that.attachment)
        && Objects.equals(toolcall, that.toolcall)
        && Objects.equals(input, that.input)
        && Objects.equals(output, that.output)
        && Objects.equals(interleaved, that.interleaved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, reasoning, attachment, toolcall, input, output, interleaved);
  }

  @Override
  public String toString() {
    return "ModelCapabilities{" +
        "temperature=" + temperature + "," +
        "reasoning=" + reasoning + "," +
        "attachment=" + attachment + "," +
        "toolcall=" + toolcall + "," +
        "input=" + input + "," +
        "output=" + output + "," +
        "interleaved=" + interleaved +
        "}";
  }
}
