package ai.opencode.sdk;

import ai.opencode.sdk.api.AppApi;
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
import ai.opencode.sdk.api.QuestionApi;
import ai.opencode.sdk.api.SessionApi;
import ai.opencode.sdk.api.ToolApi;
import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.OpencodeClientConfig;

/** 用于访问 OpenCode serve HTTP 接口的 Java 客户端。 */
public final class OpencodeClient {
  private final ApiTransport transport;
  private final GlobalApi global;
  private final ProjectApi project;
  private final ConfigApi config;
  private final ToolApi tool;
  private final SessionApi session;
  private final PermissionApi permission;
  private final QuestionApi question;
  private final FindApi find;
  private final FileApi file;
  private final McpApi mcp;
  private final InstanceApi instance;
  private final PathApi path;
  private final CommandApi command;
  private final AppApi app;
  private final LspApi lsp;
  private final FormatterApi formatter;
  private final EventApi event;

  /** 使用默认配置创建客户端。 */
  public OpencodeClient() {
    this(OpencodeClientConfig.builder().build());
  }

  /**
   * 使用指定配置创建客户端。
   *
   * @param config 客户端配置。
   */
  public OpencodeClient(OpencodeClientConfig config) {
    this.transport = new ApiTransport(config);
    this.global = new GlobalApi(transport);
    this.project = new ProjectApi(transport);
    this.config = new ConfigApi(transport);
    this.tool = new ToolApi(transport);
    this.session = new SessionApi(transport);
    this.permission = new PermissionApi(transport);
    this.question = new QuestionApi(transport);
    this.find = new FindApi(transport);
    this.file = new FileApi(transport);
    this.mcp = new McpApi(transport);
    this.instance = new InstanceApi(transport);
    this.path = new PathApi(transport);
    this.command = new CommandApi(transport);
    this.app = new AppApi(transport);
    this.lsp = new LspApi(transport);
    this.formatter = new FormatterApi(transport);
    this.event = new EventApi(transport);
  }

  /**
   * 获取全局接口。
   *
   * @return 全局接口实例。
   */
  public GlobalApi global() {
    return global;
  }

  /**
   * 获取项目接口。
   *
   * @return 项目接口实例。
   */
  public ProjectApi project() {
    return project;
  }

  /**
   * 获取配置接口。
   *
   * @return 配置接口实例。
   */
  public ConfigApi config() {
    return config;
  }

  /**
   * 获取工具接口。
   *
   * @return 工具接口实例。
   */
  public ToolApi tool() {
    return tool;
  }

  /**
   * 获取会话接口。
   *
   * @return 会话接口实例。
   */
  public SessionApi session() {
    return session;
  }

  /**
   * 获取权限接口。
   *
   * @return 权限接口实例。
   */
  public PermissionApi permission() {
    return permission;
  }

  /**
   * 获取问题接口。
   *
   * @return 问题接口实例。
   */
  public QuestionApi question() {
    return question;
  }

  /**
   * 获取检索接口。
   *
   * @return 检索接口实例。
   */
  public FindApi find() {
    return find;
  }

  /**
   * 获取文件接口。
   *
   * @return 文件接口实例。
   */
  public FileApi file() {
    return file;
  }

  /**
   * 获取 MCP 接口。
   *
   * @return MCP 接口实例。
   */
  public McpApi mcp() {
    return mcp;
  }

  /**
   * 获取实例接口。
   *
   * @return 实例接口实例。
   */
  public InstanceApi instance() {
    return instance;
  }

  /**
   * 获取路径接口。
   *
   * @return 路径接口实例。
   */
  public PathApi path() {
    return path;
  }

  /**
   * 获取命令接口。
   *
   * @return 命令接口实例。
   */
  public CommandApi command() {
    return command;
  }

  /**
   * 获取应用接口。
   *
   * @return 应用接口实例。
   */
  public AppApi app() {
    return app;
  }

  /**
   * 获取 LSP 接口。
   *
   * @return LSP 接口实例。
   */
  public LspApi lsp() {
    return lsp;
  }

  /**
   * 获取格式化器接口。
   *
   * @return 格式化器接口实例。
   */
  public FormatterApi formatter() {
    return formatter;
  }

  /**
   * 获取事件订阅接口。
   *
   * @return 事件订阅接口实例。
   */
  public EventApi event() {
    return event;
  }
}
