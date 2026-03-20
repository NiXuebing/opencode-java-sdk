package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
public final class Config {
  @JsonProperty("$schema")
  private final String schema;
  @JsonProperty("logLevel")
  private final LogLevel logLevel;
  @JsonProperty("server")
  private final ServerConfig server;
  @JsonProperty("command")
  private final Map<String, ConfigCommandValue> command;
  @JsonProperty("skills")
  private final ConfigSkills skills;
  @JsonProperty("watcher")
  private final ConfigWatcher watcher;
  @JsonProperty("plugin")
  private final List<String> plugin;
  @JsonProperty("snapshot")
  private final Boolean snapshot;
  @JsonProperty("share")
  private final String share;
  @JsonProperty("autoshare")
  private final Boolean autoshare;
  @JsonProperty("autoupdate")
  private final JsonNode autoupdate;
  @JsonProperty("disabled_providers")
  private final List<String> disabledProviders;
  @JsonProperty("enabled_providers")
  private final List<String> enabledProviders;
  @JsonProperty("model")
  private final String model;
  @JsonProperty("small_model")
  private final String smallModel;
  @JsonProperty("default_agent")
  private final String defaultAgent;
  @JsonProperty("username")
  private final String username;
  @JsonProperty("mode")
  private final ConfigMode mode;
  @JsonProperty("agent")
  private final ConfigAgent agent;
  @JsonProperty("provider")
  private final Map<String, ProviderConfig> provider;
  @JsonProperty("mcp")
  private final Map<String, JsonNode> mcp;
  @JsonProperty("formatter")
  private final JsonNode formatter;
  @JsonProperty("lsp")
  private final JsonNode lsp;
  @JsonProperty("instructions")
  private final List<String> instructions;
  @JsonProperty("layout")
  private final LayoutConfig layout;
  @JsonProperty("permission")
  private final PermissionConfig permission;
  @JsonProperty("tools")
  private final Map<String, Boolean> tools;
  @JsonProperty("enterprise")
  private final ConfigEnterprise enterprise;
  @JsonProperty("compaction")
  private final ConfigCompaction compaction;
  @JsonProperty("experimental")
  private final ConfigExperimental experimental;

  /** 使用字段创建配置。 */
  @JsonCreator
  public Config(
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
      @JsonProperty("experimental") ConfigExperimental experimental
  ) {
    this.schema = schema;
    this.logLevel = logLevel;
    this.server = server;
    this.command = command;
    this.skills = skills;
    this.watcher = watcher;
    this.plugin = plugin;
    this.snapshot = snapshot;
    this.share = share;
    this.autoshare = autoshare;
    this.autoupdate = autoupdate;
    this.disabledProviders = disabledProviders;
    this.enabledProviders = enabledProviders;
    this.model = model;
    this.smallModel = smallModel;
    this.defaultAgent = defaultAgent;
    this.username = username;
    this.mode = mode;
    this.agent = agent;
    this.provider = provider;
    this.mcp = mcp;
    this.formatter = formatter;
    this.lsp = lsp;
    this.instructions = instructions;
    this.layout = layout;
    this.permission = permission;
    this.tools = tools;
    this.enterprise = enterprise;
    this.compaction = compaction;
    this.experimental = experimental;
  }

  /**
   * 获取结构。
   *
   * @return 结构。
   */
  public String schema() {
    return schema;
  }

  /**
   * 获取日志Level。
   *
   * @return 日志级别。
   */
  public LogLevel logLevel() {
    return logLevel;
  }

  /**
   * 获取服务端。
   *
   * @return 服务端。
   */
  public ServerConfig server() {
    return server;
  }

  /**
   * 获取命令。
   *
   * @return 命令内容。
   */
  public Map<String, ConfigCommandValue> command() {
    return command;
  }

  /**
   * 获取技能。
   *
   * @return 技能配置。
   */
  public ConfigSkills skills() {
    return skills;
  }

  /**
   * 获取监听器。
   *
   * @return 监听器。
   */
  public ConfigWatcher watcher() {
    return watcher;
  }

  /**
   * 获取插件。
   *
   * @return 插件列表。
   */
  public List<String> plugin() {
    return plugin;
  }

  /**
   * 获取snapshot。
   *
   * @return 是否启用快照。
   */
  public Boolean snapshot() {
    return snapshot;
  }

  /**
   * 获取分享。
   *
   * @return 分享。
   */
  public String share() {
    return share;
  }

  /**
   * 获取autoshare。
   *
   * @return 是否自动分享。
   */
  public Boolean autoshare() {
    return autoshare;
  }

  /**
   * 获取autoupdate。
   *
   * @return 自动更新配置。
   */
  public JsonNode autoupdate() {
    return autoupdate;
  }

  /**
   * 获取已禁用提供商。
   *
   * @return 已禁用的提供商列表。
   */
  public List<String> disabledProviders() {
    return disabledProviders;
  }

  /**
   * 获取启用提供商。
   *
   * @return 已启用的提供商列表。
   */
  public List<String> enabledProviders() {
    return enabledProviders;
  }

  /**
   * 获取模型。
   *
   * @return 模型 ID 或名称。
   */
  public String model() {
    return model;
  }

  /**
   * 获取轻量模型。
   *
   * @return 轻量模型 ID 或名称。
   */
  public String smallModel() {
    return smallModel;
  }

  /**
   * 获取默认代理。
   *
   * @return 默认代理名称。
   */
  public String defaultAgent() {
    return defaultAgent;
  }

  /**
   * 获取用户名。
   *
   * @return 用户名。
   */
  public String username() {
    return username;
  }

  /**
   * 获取模式。
   *
   * @return 运行模式。
   */
  public ConfigMode mode() {
    return mode;
  }

  /**
   * 获取代理。
   *
   * @return 代理配置。
   */
  public ConfigAgent agent() {
    return agent;
  }

  /**
   * 获取提供商。
   *
   * @return 提供商配置。
   */
  public Map<String, ProviderConfig> provider() {
    return provider;
  }

  /**
   * 获取MCP。
   *
   * @return MCP 配置。
   */
  public Map<String, JsonNode> mcp() {
    return mcp;
  }

  /**
   * 获取格式化器。
   *
   * @return 格式化器配置。
   */
  public JsonNode formatter() {
    return formatter;
  }

  /**
   * 获取LSP。
   *
   * @return LSP 配置。
   */
  public JsonNode lsp() {
    return lsp;
  }

  /**
   * 获取说明。
   *
   * @return 操作说明。
   */
  public List<String> instructions() {
    return instructions;
  }

  /**
   * 获取布局。
   *
   * @return 布局配置。
   */
  public LayoutConfig layout() {
    return layout;
  }

  /**
   * 获取权限。
   *
   * @return 权限配置。
   */
  public PermissionConfig permission() {
    return permission;
  }

  /**
   * 获取工具。
   *
   * @return 工具开关配置。
   */
  public Map<String, Boolean> tools() {
    return tools;
  }

  /**
   * 获取企业版。
   *
   * @return 企业版。
   */
  public ConfigEnterprise enterprise() {
    return enterprise;
  }

  /**
   * 获取压缩。
   *
   * @return 压缩。
   */
  public ConfigCompaction compaction() {
    return compaction;
  }

  /**
   * 获取实验性。
   *
   * @return 实验性。
   */
  public ConfigExperimental experimental() {
    return experimental;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Config)) return false;
    Config that = (Config) other;
    return Objects.equals(schema, that.schema)
        && Objects.equals(logLevel, that.logLevel)
        && Objects.equals(server, that.server)
        && Objects.equals(command, that.command)
        && Objects.equals(skills, that.skills)
        && Objects.equals(watcher, that.watcher)
        && Objects.equals(plugin, that.plugin)
        && Objects.equals(snapshot, that.snapshot)
        && Objects.equals(share, that.share)
        && Objects.equals(autoshare, that.autoshare)
        && Objects.equals(autoupdate, that.autoupdate)
        && Objects.equals(disabledProviders, that.disabledProviders)
        && Objects.equals(enabledProviders, that.enabledProviders)
        && Objects.equals(model, that.model)
        && Objects.equals(smallModel, that.smallModel)
        && Objects.equals(defaultAgent, that.defaultAgent)
        && Objects.equals(username, that.username)
        && Objects.equals(mode, that.mode)
        && Objects.equals(agent, that.agent)
        && Objects.equals(provider, that.provider)
        && Objects.equals(mcp, that.mcp)
        && Objects.equals(formatter, that.formatter)
        && Objects.equals(lsp, that.lsp)
        && Objects.equals(instructions, that.instructions)
        && Objects.equals(layout, that.layout)
        && Objects.equals(permission, that.permission)
        && Objects.equals(tools, that.tools)
        && Objects.equals(enterprise, that.enterprise)
        && Objects.equals(compaction, that.compaction)
        && Objects.equals(experimental, that.experimental);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schema, logLevel, server, command, skills, watcher, plugin, snapshot, share, autoshare, autoupdate, disabledProviders, enabledProviders, model, smallModel, defaultAgent, username, mode, agent, provider, mcp, formatter, lsp, instructions, layout, permission, tools, enterprise, compaction, experimental);
  }

  @Override
  public String toString() {
    return "Config{" +
        "schema=" + schema + "," +
        "logLevel=" + logLevel + "," +
        "server=" + server + "," +
        "command=" + command + "," +
        "skills=" + skills + "," +
        "watcher=" + watcher + "," +
        "plugin=" + plugin + "," +
        "snapshot=" + snapshot + "," +
        "share=" + share + "," +
        "autoshare=" + autoshare + "," +
        "autoupdate=" + autoupdate + "," +
        "disabledProviders=" + disabledProviders + "," +
        "enabledProviders=" + enabledProviders + "," +
        "model=" + model + "," +
        "smallModel=" + smallModel + "," +
        "defaultAgent=" + defaultAgent + "," +
        "username=" + username + "," +
        "mode=" + mode + "," +
        "agent=" + agent + "," +
        "provider=" + provider + "," +
        "mcp=" + mcp + "," +
        "formatter=" + formatter + "," +
        "lsp=" + lsp + "," +
        "instructions=" + instructions + "," +
        "layout=" + layout + "," +
        "permission=" + permission + "," +
        "tools=" + tools + "," +
        "enterprise=" + enterprise + "," +
        "compaction=" + compaction + "," +
        "experimental=" + experimental +
        "}";
  }
}
