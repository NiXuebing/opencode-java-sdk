package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 配置代理数据模型。
 *
 * @param plan 规划。
 * @param build 构建。
 * @param general 通用。
 * @param explore 探索模式配置。
 * @param title 标题。
 * @param summary 摘要相关配置。
 * @param compaction 压缩。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigAgent(
    @JsonProperty("plan") AgentConfig plan,
    @JsonProperty("build") AgentConfig build,
    @JsonProperty("general") AgentConfig general,
    @JsonProperty("explore") AgentConfig explore,
    @JsonProperty("title") AgentConfig title,
    @JsonProperty("summary") AgentConfig summary,
    @JsonProperty("compaction") AgentConfig compaction) {}
