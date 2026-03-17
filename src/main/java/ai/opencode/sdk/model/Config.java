package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;

/**
 * 配置。
 *
 * @param schema 结构。
 * @param logLevel 日志级别。
 * @param server 服务端。
 * @param command 命令内容。
 * @param skills 技能配置。
 * @param watcher 监听器。
 * @param plugin 插件列表。
 * @param snapshot 是否启用快照。
 * @param share 分享。
 * @param autoshare 是否自动分享。
 * @param autoupdate 自动更新配置。
 * @param disabledProviders 已禁用的提供商列表。
 * @param enabledProviders 已启用的提供商列表。
 * @param model 模型 ID 或名称。
 * @param smallModel 轻量模型 ID 或名称。
 * @param defaultAgent 默认代理名称。
 * @param username 用户名。
 * @param mode 运行模式。
 * @param agent 代理配置。
 * @param provider 提供商配置。
 * @param mcp MCP 配置。
 * @param formatter 格式化器配置。
 * @param lsp LSP 配置。
 * @param instructions 操作说明。
 * @param layout 布局配置。
 * @param permission 权限配置。
 * @param tools 工具开关配置。
 * @param enterprise 企业版。
 * @param compaction 压缩。
 * @param experimental 实验性。
 */
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
