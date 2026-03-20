package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Step Finish片段令牌缓存数据模型。
 *
 * @param read 读取信息。
 * @param write 写入信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class StepFinishPartTokensCache {
  @JsonProperty("read")
  private final Double read;
  @JsonProperty("write")
  private final Double write;

  /** 使用字段创建Step Finish片段令牌缓存。 */
  @JsonCreator
  public StepFinishPartTokensCache(
      @JsonProperty("read") Double read,
      @JsonProperty("write") Double write
  ) {
    this.read = read;
    this.write = write;
  }

  /**
   * 获取读取。
   *
   * @return 读取信息。
   */
  public Double read() {
    return read;
  }

  /**
   * 获取写入。
   *
   * @return 写入信息。
   */
  public Double write() {
    return write;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof StepFinishPartTokensCache)) return false;
    StepFinishPartTokensCache that = (StepFinishPartTokensCache) other;
    return Objects.equals(read, that.read)
        && Objects.equals(write, that.write);
  }

  @Override
  public int hashCode() {
    return Objects.hash(read, write);
  }

  @Override
  public String toString() {
    return "StepFinishPartTokensCache{" +
        "read=" + read + "," +
        "write=" + write +
        "}";
  }
}
