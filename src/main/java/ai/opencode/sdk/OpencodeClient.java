package ai.opencode.sdk;

import ai.opencode.sdk.api.AppApi;
import ai.opencode.sdk.api.AuthApi;
import ai.opencode.sdk.api.CommandApi;
import ai.opencode.sdk.api.ConfigApi;
import ai.opencode.sdk.api.EventApi;
import ai.opencode.sdk.api.FileApi;
import ai.opencode.sdk.api.FindApi;
import ai.opencode.sdk.api.FormatterApi;
import ai.opencode.sdk.api.GlobalApi;
import ai.opencode.sdk.api.InstanceApi;
import ai.opencode.sdk.api.LspApi;
import ai.opencode.sdk.api.McpApi;
import ai.opencode.sdk.api.PathApi;
import ai.opencode.sdk.api.PermissionApi;
import ai.opencode.sdk.api.ProjectApi;
import ai.opencode.sdk.api.ProviderApi;
import ai.opencode.sdk.api.SessionApi;
import ai.opencode.sdk.api.ToolApi;
import ai.opencode.sdk.api.TuiApi;
import ai.opencode.sdk.api.VcsApi;
import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.OpencodeClientConfig;

public final class OpencodeClient {
  private final ApiTransport transport;
  private final GlobalApi global;
  private final AuthApi auth;
  private final ProjectApi project;
  private final ConfigApi config;
  private final ToolApi tool;
  private final SessionApi session;
  private final PermissionApi permission;
  private final ProviderApi provider;
  private final FindApi find;
  private final FileApi file;
  private final McpApi mcp;
  private final TuiApi tui;
  private final InstanceApi instance;
  private final PathApi path;
  private final VcsApi vcs;
  private final CommandApi command;
  private final AppApi app;
  private final LspApi lsp;
  private final FormatterApi formatter;
  private final EventApi event;

  public OpencodeClient() {
    this(OpencodeClientConfig.builder().build());
  }

  public OpencodeClient(OpencodeClientConfig config) {
    this.transport = new ApiTransport(config);
    this.global = new GlobalApi(transport);
    this.auth = new AuthApi(transport);
    this.project = new ProjectApi(transport);
    this.config = new ConfigApi(transport);
    this.tool = new ToolApi(transport);
    this.session = new SessionApi(transport);
    this.permission = new PermissionApi(transport);
    this.provider = new ProviderApi(transport);
    this.find = new FindApi(transport);
    this.file = new FileApi(transport);
    this.mcp = new McpApi(transport);
    this.tui = new TuiApi(transport);
    this.instance = new InstanceApi(transport);
    this.path = new PathApi(transport);
    this.vcs = new VcsApi(transport);
    this.command = new CommandApi(transport);
    this.app = new AppApi(transport);
    this.lsp = new LspApi(transport);
    this.formatter = new FormatterApi(transport);
    this.event = new EventApi(transport);
  }

  /** 访问全局接口。 */
  public GlobalApi global() {
    return global;
  }

  /** 访问认证接口。 */
  public AuthApi auth() {
    return auth;
  }

  /** 访问项目接口。 */
  public ProjectApi project() {
    return project;
  }

  /** 访问配置接口。 */
  public ConfigApi config() {
    return config;
  }

  /** 访问工具接口。 */
  public ToolApi tool() {
    return tool;
  }

  /** 访问会话接口。 */
  public SessionApi session() {
    return session;
  }

  /** 访问权限接口。 */
  public PermissionApi permission() {
    return permission;
  }

  /** 访问提供商接口。 */
  public ProviderApi provider() {
    return provider;
  }

  /** 访问检索接口。 */
  public FindApi find() {
    return find;
  }

  /** 访问文件接口。 */
  public FileApi file() {
    return file;
  }

  /** 访问MCP 接口。 */
  public McpApi mcp() {
    return mcp;
  }

  /** 访问TUI HTTP 接口。 */
  public TuiApi tui() {
    return tui;
  }

  /** 访问实例接口。 */
  public InstanceApi instance() {
    return instance;
  }

  /** 访问路径接口。 */
  public PathApi path() {
    return path;
  }

  /** 访问版本控制接口。 */
  public VcsApi vcs() {
    return vcs;
  }

  /** 访问命令接口。 */
  public CommandApi command() {
    return command;
  }

  /** 访问应用接口。 */
  public AppApi app() {
    return app;
  }

  /** 访问LSP 接口。 */
  public LspApi lsp() {
    return lsp;
  }

  /** 访问格式化器接口。 */
  public FormatterApi formatter() {
    return formatter;
  }

  /** 访问事件订阅接口。 */
  public EventApi event() {
    return event;
  }
}
