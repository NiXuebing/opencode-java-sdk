package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 符号数据模型。
 *
 * @param name 名称。
 * @param kind 类型值。
 * @param location 位置信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Symbol {
  @JsonProperty("name")
  private final String name;
  @JsonProperty("kind")
  private final Double kind;
  @JsonProperty("location")
  private final SymbolLocation location;

  /** 使用字段创建符号。 */
  @JsonCreator
  public Symbol(
      @JsonProperty("name") String name,
      @JsonProperty("kind") Double kind,
      @JsonProperty("location") SymbolLocation location
  ) {
    this.name = name;
    this.kind = kind;
    this.location = location;
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
   * 获取类型。
   *
   * @return 类型值。
   */
  public Double kind() {
    return kind;
  }

  /**
   * 获取location。
   *
   * @return 位置信息。
   */
  public SymbolLocation location() {
    return location;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Symbol)) return false;
    Symbol that = (Symbol) other;
    return Objects.equals(name, that.name)
        && Objects.equals(kind, that.kind)
        && Objects.equals(location, that.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, kind, location);
  }

  @Override
  public String toString() {
    return "Symbol{" +
        "name=" + name + "," +
        "kind=" + kind + "," +
        "location=" + location +
        "}";
  }
}
