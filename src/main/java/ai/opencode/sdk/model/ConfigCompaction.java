package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 配置压缩数据模型。
 *
 * @param auto 是否自动执行。
 * @param prune 是否执行裁剪。
 * @param reserved 预留。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigCompaction {
  @JsonProperty("auto")
  private final Boolean auto;
  @JsonProperty("prune")
  private final Boolean prune;
  @JsonProperty("reserved")
  private final Long reserved;

  /** 使用字段创建配置压缩。 */
  @JsonCreator
  public ConfigCompaction(
      @JsonProperty("auto") Boolean auto,
      @JsonProperty("prune") Boolean prune,
      @JsonProperty("reserved") Long reserved
  ) {
    this.auto = auto;
    this.prune = prune;
    this.reserved = reserved;
  }

  /**
   * 获取自动。
   *
   * @return 是否自动执行。
   */
  public Boolean auto() {
    return auto;
  }

  /**
   * 获取裁剪。
   *
   * @return 是否执行裁剪。
   */
  public Boolean prune() {
    return prune;
  }

  /**
   * 获取预留。
   *
   * @return 预留。
   */
  public Long reserved() {
    return reserved;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigCompaction)) return false;
    ConfigCompaction that = (ConfigCompaction) other;
    return Objects.equals(auto, that.auto)
        && Objects.equals(prune, that.prune)
        && Objects.equals(reserved, that.reserved);
  }

  @Override
  public int hashCode() {
    return Objects.hash(auto, prune, reserved);
  }

  @Override
  public String toString() {
    return "ConfigCompaction{" +
        "auto=" + auto + "," +
        "prune=" + prune + "," +
        "reserved=" + reserved +
        "}";
  }
}
