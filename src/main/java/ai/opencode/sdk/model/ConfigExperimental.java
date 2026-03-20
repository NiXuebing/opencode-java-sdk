package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 配置实验性数据模型。
 *
 * @param disablePasteSummary 是否禁用粘贴摘要。
 * @param batchTool 是否启用批量工具。
 * @param openTelemetry 是否启用 OpenTelemetry。
 * @param primaryTools 主要工具列表。
 * @param continueLoopOnDeny 是否在拒绝后继续循环。
 * @param mcpTimeout MCP 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ConfigExperimental {
  @JsonProperty("disable_paste_summary")
  private final Boolean disablePasteSummary;
  @JsonProperty("batch_tool")
  private final Boolean batchTool;
  @JsonProperty("openTelemetry")
  private final Boolean openTelemetry;
  @JsonProperty("primary_tools")
  private final List<String> primaryTools;
  @JsonProperty("continue_loop_on_deny")
  private final Boolean continueLoopOnDeny;
  @JsonProperty("mcp_timeout")
  private final Long mcpTimeout;

  /** 使用字段创建配置实验性。 */
  @JsonCreator
  public ConfigExperimental(
      @JsonProperty("disable_paste_summary") Boolean disablePasteSummary,
      @JsonProperty("batch_tool") Boolean batchTool,
      @JsonProperty("openTelemetry") Boolean openTelemetry,
      @JsonProperty("primary_tools") List<String> primaryTools,
      @JsonProperty("continue_loop_on_deny") Boolean continueLoopOnDeny,
      @JsonProperty("mcp_timeout") Long mcpTimeout
  ) {
    this.disablePasteSummary = disablePasteSummary;
    this.batchTool = batchTool;
    this.openTelemetry = openTelemetry;
    this.primaryTools = primaryTools;
    this.continueLoopOnDeny = continueLoopOnDeny;
    this.mcpTimeout = mcpTimeout;
  }

  /**
   * 获取disable paste摘要。
   *
   * @return 是否禁用粘贴摘要。
   */
  public Boolean disablePasteSummary() {
    return disablePasteSummary;
  }

  /**
   * 获取批量工具。
   *
   * @return 是否启用批量工具。
   */
  public Boolean batchTool() {
    return batchTool;
  }

  /**
   * 获取打开遥测。
   *
   * @return 是否启用 OpenTelemetry。
   */
  public Boolean openTelemetry() {
    return openTelemetry;
  }

  /**
   * 获取主要工具。
   *
   * @return 主要工具列表。
   */
  public List<String> primaryTools() {
    return primaryTools;
  }

  /**
   * 获取继续loop on拒绝。
   *
   * @return 是否在拒绝后继续循环。
   */
  public Boolean continueLoopOnDeny() {
    return continueLoopOnDeny;
  }

  /**
   * 获取MCP timeout。
   *
   * @return MCP 请求超时时间。
   */
  public Long mcpTimeout() {
    return mcpTimeout;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ConfigExperimental)) return false;
    ConfigExperimental that = (ConfigExperimental) other;
    return Objects.equals(disablePasteSummary, that.disablePasteSummary)
        && Objects.equals(batchTool, that.batchTool)
        && Objects.equals(openTelemetry, that.openTelemetry)
        && Objects.equals(primaryTools, that.primaryTools)
        && Objects.equals(continueLoopOnDeny, that.continueLoopOnDeny)
        && Objects.equals(mcpTimeout, that.mcpTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disablePasteSummary, batchTool, openTelemetry, primaryTools, continueLoopOnDeny, mcpTimeout);
  }

  @Override
  public String toString() {
    return "ConfigExperimental{" +
        "disablePasteSummary=" + disablePasteSummary + "," +
        "batchTool=" + batchTool + "," +
        "openTelemetry=" + openTelemetry + "," +
        "primaryTools=" + primaryTools + "," +
        "continueLoopOnDeny=" + continueLoopOnDeny + "," +
        "mcpTimeout=" + mcpTimeout +
        "}";
  }
}
