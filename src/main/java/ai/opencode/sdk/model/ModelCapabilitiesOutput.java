package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 模型能力输出数据模型。
 *
 * @param text 文本内容。
 * @param audio 是否支持音频。
 * @param image 是否支持图像。
 * @param video 是否支持视频。
 * @param pdf 是否支持 PDF。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ModelCapabilitiesOutput {
  @JsonProperty("text")
  private final Boolean text;
  @JsonProperty("audio")
  private final Boolean audio;
  @JsonProperty("image")
  private final Boolean image;
  @JsonProperty("video")
  private final Boolean video;
  @JsonProperty("pdf")
  private final Boolean pdf;

  /** 使用字段创建模型能力输出。 */
  @JsonCreator
  public ModelCapabilitiesOutput(
      @JsonProperty("text") Boolean text,
      @JsonProperty("audio") Boolean audio,
      @JsonProperty("image") Boolean image,
      @JsonProperty("video") Boolean video,
      @JsonProperty("pdf") Boolean pdf
  ) {
    this.text = text;
    this.audio = audio;
    this.image = image;
    this.video = video;
    this.pdf = pdf;
  }

  /**
   * 获取文本。
   *
   * @return 文本内容。
   */
  public Boolean text() {
    return text;
  }

  /**
   * 获取音频。
   *
   * @return 是否支持音频。
   */
  public Boolean audio() {
    return audio;
  }

  /**
   * 获取图像。
   *
   * @return 是否支持图像。
   */
  public Boolean image() {
    return image;
  }

  /**
   * 获取视频。
   *
   * @return 是否支持视频。
   */
  public Boolean video() {
    return video;
  }

  /**
   * 获取PDF。
   *
   * @return 是否支持 PDF。
   */
  public Boolean pdf() {
    return pdf;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModelCapabilitiesOutput)) return false;
    ModelCapabilitiesOutput that = (ModelCapabilitiesOutput) other;
    return Objects.equals(text, that.text)
        && Objects.equals(audio, that.audio)
        && Objects.equals(image, that.image)
        && Objects.equals(video, that.video)
        && Objects.equals(pdf, that.pdf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, audio, image, video, pdf);
  }

  @Override
  public String toString() {
    return "ModelCapabilitiesOutput{" +
        "text=" + text + "," +
        "audio=" + audio + "," +
        "image=" + image + "," +
        "video=" + video + "," +
        "pdf=" + pdf +
        "}";
  }
}
