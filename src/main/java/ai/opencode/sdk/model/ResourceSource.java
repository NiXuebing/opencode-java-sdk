package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Resource来源数据模型。
 *
 * @param text 文本内容。
 * @param type 类型标识。
 * @param clientName 客户端名称。
 * @param uri URI 地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ResourceSource implements FilePartSource {
  @JsonProperty("text")
  private final FilePartSourceText text;
  @JsonProperty("type")
  private final String type;
  @JsonProperty("clientName")
  private final String clientName;
  @JsonProperty("uri")
  private final String uri;

  /** 使用字段创建Resource来源。 */
  @JsonCreator
  public ResourceSource(
      @JsonProperty("text") FilePartSourceText text,
      @JsonProperty("type") String type,
      @JsonProperty("clientName") String clientName,
      @JsonProperty("uri") String uri
  ) {
    this.text = text;
    this.type = type;
    this.clientName = clientName;
    this.uri = uri;
  }

  /**
   * 获取文本。
   *
   * @return 文本内容。
   */
  public FilePartSourceText text() {
    return text;
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
   * 获取客户端Name。
   *
   * @return 客户端名称。
   */
  public String clientName() {
    return clientName;
  }

  /**
   * 获取URI。
   *
   * @return URI 地址。
   */
  public String uri() {
    return uri;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ResourceSource)) return false;
    ResourceSource that = (ResourceSource) other;
    return Objects.equals(text, that.text)
        && Objects.equals(type, that.type)
        && Objects.equals(clientName, that.clientName)
        && Objects.equals(uri, that.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, type, clientName, uri);
  }

  @Override
  public String toString() {
    return "ResourceSource{" +
        "text=" + text + "," +
        "type=" + type + "," +
        "clientName=" + clientName + "," +
        "uri=" + uri +
        "}";
  }
}
