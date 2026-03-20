package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Objects;

/**
 * 应用日志请求体。
 *
 * @param service 服务名称。
 * @param level 日志级别。
 * @param message 消息内容。
 * @param extra 附加信息映射。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class AppLogBody {
  @JsonProperty("service")
  private final String service;
  @JsonProperty("level")
  private final String level;
  @JsonProperty("message")
  private final String message;
  @JsonProperty("extra")
  private final Map<String, JsonNode> extra;

  /** 使用字段创建应用日志请求体。 */
  @JsonCreator
  public AppLogBody(
      @JsonProperty("service") String service,
      @JsonProperty("level") String level,
      @JsonProperty("message") String message,
      @JsonProperty("extra") Map<String, JsonNode> extra
  ) {
    this.service = service;
    this.level = level;
    this.message = message;
    this.extra = extra;
  }

  /**
   * 获取服务。
   *
   * @return 服务名称。
   */
  public String service() {
    return service;
  }

  /**
   * 获取level。
   *
   * @return 日志级别。
   */
  public String level() {
    return level;
  }

  /**
   * 获取消息。
   *
   * @return 消息内容。
   */
  public String message() {
    return message;
  }

  /**
   * 获取extra。
   *
   * @return 附加信息映射。
   */
  public Map<String, JsonNode> extra() {
    return extra;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AppLogBody)) return false;
    AppLogBody that = (AppLogBody) other;
    return Objects.equals(service, that.service)
        && Objects.equals(level, that.level)
        && Objects.equals(message, that.message)
        && Objects.equals(extra, that.extra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, level, message, extra);
  }

  @Override
  public String toString() {
    return "AppLogBody{" +
        "service=" + service + "," +
        "level=" + level + "," +
        "message=" + message + "," +
        "extra=" + extra +
        "}";
  }
}
