package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 执行文本检索接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param pattern 匹配模式。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FindTextRequest {
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("pattern")
  private final String pattern;

  /** 创建检索文本请求。 */
  @JsonCreator
  public FindTextRequest(
      @JsonProperty("directory") String directory,
      @JsonProperty("pattern") String pattern
  ) {
    this.directory = directory;
    this.pattern = pattern;
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
   * 获取pattern。
   *
   * @return 匹配模式。
   */
  public String pattern() {
    return pattern;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof FindTextRequest)) return false;
    FindTextRequest that = (FindTextRequest) other;
    return Objects.equals(directory, that.directory)
        && Objects.equals(pattern, that.pattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directory, pattern);
  }

  @Override
  public String toString() {
    return "FindTextRequest{" +
        "directory=" + directory + "," +
        "pattern=" + pattern +
        "}";
  }
}
