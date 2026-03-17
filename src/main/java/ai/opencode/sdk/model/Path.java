package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 路径数据模型。
 *
 * @param home 主目录路径。
 * @param state 状态。
 * @param config 配置内容。
 * @param worktree 工作树。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Path(
    @JsonProperty("home") String home,
    @JsonProperty("state") String state,
    @JsonProperty("config") String config,
    @JsonProperty("worktree") String worktree,
    @JsonProperty("directory") String directory) {}
