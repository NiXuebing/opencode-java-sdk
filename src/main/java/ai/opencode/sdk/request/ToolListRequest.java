package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 获取工具列表接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param provider 提供商 ID 或名称。
 * @param model 模型 ID 或名称。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ToolListRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("provider")
  private final String provider;
  @JsonProperty("model")
  private final String model;

  /** 创建工具列表请求。 */
  @JsonCreator
  public ToolListRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("provider") String provider,
      @JsonProperty("model") String model
  ) {
    this.directory = directory;
    this.provider = provider;
    this.model = model;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  /**
   * 获取提供商。
   *
   * @return 提供商 ID 或名称。
   */
  public String provider() {
    return provider;
  }

  /**
   * 获取模型。
   *
   * @return 模型 ID 或名称。
   */
  public String model() {
    return model;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ToolListRequest)) return false;
    ToolListRequest that = (ToolListRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(provider, that.provider)
        && Objects.equals(model, that.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, provider, model);
  }

  @Override
  public String toString() {
    return "ToolListRequest{" +
        "directory=" + directory + "," +
        "provider=" + provider + "," +
        "model=" + model +
        "}";
  }
}
