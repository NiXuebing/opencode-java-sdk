package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Config(
    @JsonProperty("$schema") String schema,
    @JsonProperty("logLevel") LogLevel logLevel,
    @JsonProperty("server") ServerConfig server,
    @JsonProperty("command") Map<String, ConfigCommandValue> command,
    @JsonProperty("skills") ConfigSkills skills,
    @JsonProperty("watcher") ConfigWatcher watcher,
    @JsonProperty("plugin") List<String> plugin,
    @JsonProperty("snapshot") Boolean snapshot,
    @JsonProperty("share") String share,
    @JsonProperty("autoshare") Boolean autoshare,
    @JsonProperty("autoupdate") JsonNode autoupdate,
    @JsonProperty("disabled_providers") List<String> disabledProviders,
    @JsonProperty("enabled_providers") List<String> enabledProviders,
    @JsonProperty("model") String model,
    @JsonProperty("small_model") String smallModel,
    @JsonProperty("default_agent") String defaultAgent,
    @JsonProperty("username") String username,
    @JsonProperty("mode") ConfigMode mode,
    @JsonProperty("agent") ConfigAgent agent,
    @JsonProperty("provider") Map<String, ProviderConfig> provider,
    @JsonProperty("mcp") Map<String, JsonNode> mcp,
    @JsonProperty("formatter") JsonNode formatter,
    @JsonProperty("lsp") JsonNode lsp,
    @JsonProperty("instructions") List<String> instructions,
    @JsonProperty("layout") LayoutConfig layout,
    @JsonProperty("permission") PermissionConfig permission,
    @JsonProperty("tools") Map<String, Boolean> tools,
    @JsonProperty("enterprise") ConfigEnterprise enterprise,
    @JsonProperty("compaction") ConfigCompaction compaction,
    @JsonProperty("experimental") ConfigExperimental experimental) {}
