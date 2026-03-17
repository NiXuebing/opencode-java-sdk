package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

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
