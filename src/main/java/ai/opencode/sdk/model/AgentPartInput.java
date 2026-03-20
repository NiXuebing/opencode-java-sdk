package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 代理片段输入数据模型。
 *
 * @param id 唯一标识。
 * @param type 类型标识。
 * @param name 名称。
 * @param source 来源。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AgentPartInput implements SessionPromptBodyPartsItem, SessionPromptAsyncBodyPartsItem {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("name")
  private final String name;
  @JsonProperty("source")
  private final AgentPartInputSource source;

  /** 使用字段创建代理片段输入。 */
  @JsonCreator
  public AgentPartInput(
      @JsonProperty("id") String id,
      @JsonProperty("type") String type,
      @JsonProperty("name") String name,
      @JsonProperty("source") AgentPartInputSource source
  ) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.source = source;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取类型。
   *
   * @return 类型标识。
   */
  public String type() {
    return type;
  }

  /**
   * 获取name。
   *
   * @return 名称。
   */
  public String name() {
    return name;
  }

  /**
   * 获取来源。
   *
   * @return 来源。
   */
  public AgentPartInputSource source() {
    return source;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AgentPartInput)) return false;
    AgentPartInput that = (AgentPartInput) other;
    return Objects.equals(id, that.id)
        && Objects.equals(type, that.type)
        && Objects.equals(name, that.name)
        && Objects.equals(source, that.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, source);
  }

  @Override
  public String toString() {
    return "AgentPartInput{" +
        "id=" + id + "," +
        "type=" + type + "," +
        "name=" + name + "," +
        "source=" + source +
        "}";
  }
}
