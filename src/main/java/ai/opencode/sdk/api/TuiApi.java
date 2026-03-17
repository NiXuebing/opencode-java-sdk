package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.request.TuiAppendPromptRequest;
import ai.opencode.sdk.request.TuiClearPromptRequest;
import ai.opencode.sdk.request.TuiExecuteCommandRequest;
import ai.opencode.sdk.request.TuiOpenHelpRequest;
import ai.opencode.sdk.request.TuiOpenModelsRequest;
import ai.opencode.sdk.request.TuiOpenSessionsRequest;
import ai.opencode.sdk.request.TuiOpenThemesRequest;
import ai.opencode.sdk.request.TuiShowToastRequest;
import ai.opencode.sdk.request.TuiSubmitPromptRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** 封装TUI HTTP 接口相关的 HTTP 调用。 */
public final class TuiApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建TUI HTTP 接口封装。
   *
   * @param transport 底层传输器。
   */
  public TuiApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 追加 TUI 输入。
   *
   * @param request 追加 TUI 输入所需的请求参数，其中 body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean appendPrompt(TuiAppendPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/tui/append-prompt", path, query, headers, body, Boolean.class);
  }

  /**
   * 打开 TUI 帮助。
   *
   * @return 操作是否成功。
   */
  public Boolean openHelp() {
    return openHelp(new TuiOpenHelpRequest(null));
  }

  /**
   * 打开 TUI 帮助。
   *
   * @param request 打开 TUI 帮助所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean openHelp(TuiOpenHelpRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/open-help", path, query, headers, body, Boolean.class);
  }

  /**
   * 打开 TUI 会话面板。
   *
   * @return 操作是否成功。
   */
  public Boolean openSessions() {
    return openSessions(new TuiOpenSessionsRequest(null));
  }

  /**
   * 打开 TUI 会话面板。
   *
   * @param request 打开 TUI 会话面板所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean openSessions(TuiOpenSessionsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/tui/open-sessions", path, query, headers, body, Boolean.class);
  }

  /**
   * 打开 TUI 主题面板。
   *
   * @return 操作是否成功。
   */
  public Boolean openThemes() {
    return openThemes(new TuiOpenThemesRequest(null));
  }

  /**
   * 打开 TUI 主题面板。
   *
   * @param request 打开 TUI 主题面板所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean openThemes(TuiOpenThemesRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/open-themes", path, query, headers, body, Boolean.class);
  }

  /**
   * 打开 TUI 模型面板。
   *
   * @return 操作是否成功。
   */
  public Boolean openModels() {
    return openModels(new TuiOpenModelsRequest(null));
  }

  /**
   * 打开 TUI 模型面板。
   *
   * @param request 打开 TUI 模型面板所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean openModels(TuiOpenModelsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/open-models", path, query, headers, body, Boolean.class);
  }

  /**
   * 提交 TUI 输入。
   *
   * @return 操作是否成功。
   */
  public Boolean submitPrompt() {
    return submitPrompt(new TuiSubmitPromptRequest(null));
  }

  /**
   * 提交 TUI 输入。
   *
   * @param request 提交 TUI 输入所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean submitPrompt(TuiSubmitPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/tui/submit-prompt", path, query, headers, body, Boolean.class);
  }

  /**
   * 清空 TUI 输入。
   *
   * @return 操作是否成功。
   */
  public Boolean clearPrompt() {
    return clearPrompt(new TuiClearPromptRequest(null));
  }

  /**
   * 清空 TUI 输入。
   *
   * @param request 清空 TUI 输入所需的请求参数。
   * @return 操作是否成功。
   */
  public Boolean clearPrompt(TuiClearPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/tui/clear-prompt", path, query, headers, body, Boolean.class);
  }

  /**
   * 执行 TUI 命令。
   *
   * @param request 执行 TUI 命令所需的请求参数，其中 body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean executeCommand(TuiExecuteCommandRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/tui/execute-command", path, query, headers, body, Boolean.class);
  }

  /**
   * 显示 TUI 提示。
   *
   * @param request 显示 TUI 提示所需的请求参数，其中 body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean showToast(TuiShowToastRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/show-toast", path, query, headers, body, Boolean.class);
  }
}
