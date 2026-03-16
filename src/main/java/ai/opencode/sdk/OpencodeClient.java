package ai.opencode.sdk;

import ai.opencode.sdk.api.*;
import ai.opencode.sdk.core.*;

public final class OpencodeClient {
  private final ApiTransport transport;
  private final GlobalApi global;
  private final AuthApi auth;
  private final ProjectApi project;
  private final PtyApi pty;
  private final ConfigApi config;
  private final ToolApi tool;
  private final WorktreeApi worktree;
  private final ExperimentalApi experimental;
  private final SessionApi session;
  private final PartApi part;
  private final PermissionApi permission;
  private final QuestionApi question;
  private final MirrorApi mirror;
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
    this.pty = new PtyApi(transport);
    this.config = new ConfigApi(transport);
    this.tool = new ToolApi(transport);
    this.worktree = new WorktreeApi(transport);
    this.experimental = new ExperimentalApi(transport);
    this.session = new SessionApi(transport);
    this.part = new PartApi(transport);
    this.permission = new PermissionApi(transport);
    this.question = new QuestionApi(transport);
    this.mirror = new MirrorApi(transport);
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

  public GlobalApi global() {
    return global;
  }

  public AuthApi auth() {
    return auth;
  }

  public ProjectApi project() {
    return project;
  }

  public PtyApi pty() {
    return pty;
  }

  public ConfigApi config() {
    return config;
  }

  public ToolApi tool() {
    return tool;
  }

  public WorktreeApi worktree() {
    return worktree;
  }

  public ExperimentalApi experimental() {
    return experimental;
  }

  public SessionApi session() {
    return session;
  }

  public PartApi part() {
    return part;
  }

  public PermissionApi permission() {
    return permission;
  }

  public QuestionApi question() {
    return question;
  }

  public MirrorApi mirror() {
    return mirror;
  }

  public ProviderApi provider() {
    return provider;
  }

  public FindApi find() {
    return find;
  }

  public FileApi file() {
    return file;
  }

  public McpApi mcp() {
    return mcp;
  }

  public TuiApi tui() {
    return tui;
  }

  public InstanceApi instance() {
    return instance;
  }

  public PathApi path() {
    return path;
  }

  public VcsApi vcs() {
    return vcs;
  }

  public CommandApi command() {
    return command;
  }

  public AppApi app() {
    return app;
  }

  public LspApi lsp() {
    return lsp;
  }

  public FormatterApi formatter() {
    return formatter;
  }

  public EventApi event() {
    return event;
  }
}
