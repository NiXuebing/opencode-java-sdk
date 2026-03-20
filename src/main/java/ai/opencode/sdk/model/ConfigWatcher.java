package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 配置监听器数据模型。
 *
 * @param ignore 忽略列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigWatcher {
  @JsonProperty("ignore")
  private final List<String> ignore;

  /** 使用字段创建配置监听器。 */
  @JsonCreator
  public ConfigWatcher(
      @JsonProperty("ignore") List<String> ignore
  ) {
    this.ignore = ignore;
  }

  /**
   * 获取忽略。
   *
   * @return 忽略列表。
   */
  public List<String> ignore() {
    return ignore;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigWatcher)) return false;
    ConfigWatcher that = (ConfigWatcher) other;
    return Objects.equals(ignore, that.ignore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ignore);
  }

  @Override
  public String toString() {
    return "ConfigWatcher{" +
        "ignore=" + ignore +
        "}";
  }
}
