package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 权限配置数据模型。
 *
 * @param originalKeys 原始键列表。
 * @param read 读取信息。
 * @param edit 编辑。
 * @param glob 通配。
 * @param grep Grep 权限配置。
 * @param list 列表。
 * @param bash Bash 权限配置。
 * @param task 任务。
 * @param externalDirectory 外部目录权限。
 * @param todowrite 待办写入权限配置。
 * @param todoread 待办读取权限配置。
 * @param question 问题。
 * @param webfetch WebFetch 权限配置。
 * @param websearch WebSearch 权限配置。
 * @param codesearch CodeSearch 权限配置。
 * @param lsp LSP 配置。
 * @param doomLoop 是否允许死循环。
 * @param skill 技能。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionConfig1(
    @JsonProperty("__originalKeys") List<String> originalKeys,
    @JsonProperty("read") PermissionRuleConfig read,
    @JsonProperty("edit") PermissionRuleConfig edit,
    @JsonProperty("glob") PermissionRuleConfig glob,
    @JsonProperty("grep") PermissionRuleConfig grep,
    @JsonProperty("list") PermissionRuleConfig list,
    @JsonProperty("bash") PermissionRuleConfig bash,
    @JsonProperty("task") PermissionRuleConfig task,
    @JsonProperty("external_directory") PermissionRuleConfig externalDirectory,
    @JsonProperty("todowrite") PermissionActionConfig todowrite,
    @JsonProperty("todoread") PermissionActionConfig todoread,
    @JsonProperty("question") PermissionActionConfig question,
    @JsonProperty("webfetch") PermissionActionConfig webfetch,
    @JsonProperty("websearch") PermissionActionConfig websearch,
    @JsonProperty("codesearch") PermissionActionConfig codesearch,
    @JsonProperty("lsp") PermissionRuleConfig lsp,
    @JsonProperty("doom_loop") PermissionActionConfig doomLoop,
    @JsonProperty("skill") PermissionRuleConfig skill) {}
