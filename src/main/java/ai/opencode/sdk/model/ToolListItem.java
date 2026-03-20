package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;

/**
 * 工具列表项数据模型。
 *
 * @param id 唯一标识。
 * @param description 描述信息。
 * @param parameters 参数结构定义。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolListItem {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("description")
  private final String description;
  @JsonProperty("parameters")
  private final JsonNode parameters;

  /** 使用字段创建工具列表项。 */
  @JsonCreator
  public ToolListItem(
      @JsonProperty("id") String id,
      @JsonProperty("description") String description,
      @JsonProperty("parameters") JsonNode parameters
  ) {
    this.id = id;
    this.description = description;
    this.parameters = parameters;
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
   * 获取description。
   *
   * @return 描述信息。
   */
  public String description() {
    return description;
  }

  /**
   * 获取parameters。
   *
   * @return 参数结构定义。
   */
  public JsonNode parameters() {
    return parameters;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolListItem)) return false;
    ToolListItem that = (ToolListItem) other;
    return Objects.equals(id, that.id)
        && Objects.equals(description, that.description)
        && Objects.equals(parameters, that.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, parameters);
  }

  @Override
  public String toString() {
    return "ToolListItem{" +
        "id=" + id + "," +
        "description=" + description + "," +
        "parameters=" + parameters +
        "}";
  }
}
