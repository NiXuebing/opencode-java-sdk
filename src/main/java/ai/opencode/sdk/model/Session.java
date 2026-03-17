package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 会话数据模型。
 *
 * @param id 唯一标识。
 * @param slug slug。
 * @param projectID 项目 ID。
 * @param workspaceID 工作区 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param parentID parent ID。
 * @param summary summary。
 * @param share 分享。
 * @param title 标题。
 * @param version 版本号。
 * @param time 时间。
 * @param permission 权限配置。
 * @param revert 撤回。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Session(
    @JsonProperty("id") String id,
    @JsonProperty("slug") String slug,
    @JsonProperty("projectID") String projectID,
    @JsonProperty("workspaceID") String workspaceID,
    @JsonProperty("directory") String directory,
    @JsonProperty("parentID") String parentID,
    @JsonProperty("summary") SessionSummary summary,
    @JsonProperty("share") SessionShare share,
    @JsonProperty("title") String title,
    @JsonProperty("version") String version,
    @JsonProperty("time") SessionTime time,
    @JsonProperty("permission") PermissionRuleset permission,
    @JsonProperty("revert") SessionRevert revert) {}
