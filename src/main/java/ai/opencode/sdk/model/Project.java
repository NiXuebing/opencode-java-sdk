package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 项目数据模型。
 *
 * @param id 唯一标识。
 * @param worktree 工作树。
 * @param vcs 版本控制。
 * @param name 名称。
 * @param icon 图标配置。
 * @param commands 命令。
 * @param time 时间。
 * @param sandboxes 沙箱列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Project(
    @JsonProperty("id") String id,
    @JsonProperty("worktree") String worktree,
    @JsonProperty("vcs") String vcs,
    @JsonProperty("name") String name,
    @JsonProperty("icon") ProjectIcon icon,
    @JsonProperty("commands") ProjectCommands commands,
    @JsonProperty("time") ProjectTime time,
    @JsonProperty("sandboxes") List<String> sandboxes) {}
