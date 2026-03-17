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
 * @param logLevel 日志Level。
 * @param server 服务端。
 * @param command 命令内容。
 * @param skills skills。
 * @param watcher 监听器。
 * @param plugin plugin列表。
 * @param snapshot snapshot标记。
 * @param share 分享。
 * @param autoshare autoshare标记。
 * @param autoupdate autoupdate。
 * @param disabledProviders 已禁用提供商列表。
 * @param enabledProviders enabled提供商列表。
 * @param model 模型配置。
 * @param smallModel small模型。
 * @param defaultAgent 默认代理。
 * @param username username。
 * @param mode mode。
 * @param agent 代理名称或代理配置。
 * @param provider 提供商标识。
 * @param mcp MCP映射。
 * @param formatter 格式化器。
 * @param lsp LSP。
 * @param instructions 操作说明。
 * @param layout 布局。
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
