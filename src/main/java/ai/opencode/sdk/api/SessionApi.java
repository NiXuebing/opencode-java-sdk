package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.AssistantMessage;
import ai.opencode.sdk.model.FileDiff;
import ai.opencode.sdk.model.Session;
import ai.opencode.sdk.model.SessionCommandResponse;
import ai.opencode.sdk.model.SessionMessageResponse;
import ai.opencode.sdk.model.SessionMessagesResponseItem;
import ai.opencode.sdk.model.SessionPromptResponse;
import ai.opencode.sdk.model.SessionStatus;
import ai.opencode.sdk.model.Todo;
import ai.opencode.sdk.request.SessionAbortRequest;
import ai.opencode.sdk.request.SessionChildrenRequest;
import ai.opencode.sdk.request.SessionCommandRequest;
import ai.opencode.sdk.request.SessionCreateRequest;
import ai.opencode.sdk.request.SessionDeleteRequest;
import ai.opencode.sdk.request.SessionDiffRequest;
import ai.opencode.sdk.request.SessionForkRequest;
import ai.opencode.sdk.request.SessionGetRequest;
import ai.opencode.sdk.request.SessionInitRequest;
import ai.opencode.sdk.request.SessionListRequest;
import ai.opencode.sdk.request.SessionMessageRequest;
import ai.opencode.sdk.request.SessionMessagesRequest;
import ai.opencode.sdk.request.SessionPromptAsyncRequest;
import ai.opencode.sdk.request.SessionPromptRequest;
import ai.opencode.sdk.request.SessionRevertRequest;
import ai.opencode.sdk.request.SessionShareRequest;
import ai.opencode.sdk.request.SessionShellRequest;
import ai.opencode.sdk.request.SessionStatusRequest;
import ai.opencode.sdk.request.SessionSummarizeRequest;
import ai.opencode.sdk.request.SessionTodoRequest;
import ai.opencode.sdk.request.SessionUnrevertRequest;
import ai.opencode.sdk.request.SessionUnshareRequest;
import ai.opencode.sdk.request.SessionUpdateRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class SessionApi {
  private final ApiTransport transport;

  public SessionApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 列出会话。 */
  public List<Session> list() {
    return list(new SessionListRequest(null, null, null, null, null));
  }

  /** 列出会话。 可传入请求参数。 */
  public List<Session> list(SessionListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.roots() != null) query.put("roots", request.roots());
    if (request.start() != null) query.put("start", request.start());
    if (request.search() != null) query.put("search", request.search());
    if (request.limit() != null) query.put("limit", request.limit());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/session", path, query, headers, body, new TypeReference<List<Session>>() {});
  }

  /** 创建会话。 可传入请求参数。 */
  public Session create(SessionCreateRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session", path, query, headers, body, Session.class);
  }

  /** 获取会话状态。 */
  public Map<String, SessionStatus> status() {
    return status(new SessionStatusRequest(null));
  }

  /** 获取会话状态。 可传入请求参数。 */
  public Map<String, SessionStatus> status(SessionStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/status",
        path,
        query,
        headers,
        body,
        new TypeReference<Map<String, SessionStatus>>() {});
  }

  /** 获取会话。 可传入请求参数。 */
  public Session get(SessionGetRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/session/{sessionID}", path, query, headers, body, Session.class);
  }

  /** 删除会话。 可传入请求参数。 */
  public Boolean delete(SessionDeleteRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "DELETE", "/session/{sessionID}", path, query, headers, body, Boolean.class);
  }

  /** 更新会话。 可传入请求参数。 */
  public Session update(SessionUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "PATCH", "/session/{sessionID}", path, query, headers, body, Session.class);
  }

  /** 获取子会话。 可传入请求参数。 */
  public List<Session> children(SessionChildrenRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/{sessionID}/children",
        path,
        query,
        headers,
        body,
        new TypeReference<List<Session>>() {});
  }

  /** 获取会话待办。 可传入请求参数。 */
  public List<Todo> todo(SessionTodoRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/{sessionID}/todo",
        path,
        query,
        headers,
        body,
        new TypeReference<List<Todo>>() {});
  }

  /** 初始化会话。 可传入请求参数。 */
  public Boolean init(SessionInitRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/init", path, query, headers, body, Boolean.class);
  }

  /** 派生会话。 可传入请求参数。 */
  public Session fork(SessionForkRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/fork", path, query, headers, body, Session.class);
  }

  /** 中止会话。 可传入请求参数。 */
  public Boolean abort(SessionAbortRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/session/{sessionID}/abort", path, query, headers, body, Boolean.class);
  }

  /** 分享会话。 可传入请求参数。 */
  public Session share(SessionShareRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/session/{sessionID}/share", path, query, headers, body, Session.class);
  }

  /** 取消分享会话。 可传入请求参数。 */
  public Session unshare(SessionUnshareRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "DELETE", "/session/{sessionID}/share", path, query, headers, body, Session.class);
  }

  /** 获取会话差异。 可传入请求参数。 */
  public List<FileDiff> diff(SessionDiffRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.messageID() != null) query.put("messageID", request.messageID());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/{sessionID}/diff",
        path,
        query,
        headers,
        body,
        new TypeReference<List<FileDiff>>() {});
  }

  /** 总结会话。 可传入请求参数。 */
  public Boolean summarize(SessionSummarizeRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/summarize", path, query, headers, body, Boolean.class);
  }

  /** 列出会话消息。 可传入请求参数。 */
  public List<SessionMessagesResponseItem> messages(SessionMessagesRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.limit() != null) query.put("limit", request.limit());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/{sessionID}/message",
        path,
        query,
        headers,
        body,
        new TypeReference<List<SessionMessagesResponseItem>>() {});
  }

  /** 发送会话提示。 可传入请求参数。 */
  public SessionPromptResponse prompt(SessionPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST",
        "/session/{sessionID}/message",
        path,
        query,
        headers,
        body,
        SessionPromptResponse.class);
  }

  /** 获取消息详情。 可传入请求参数。 */
  public SessionMessageResponse message(SessionMessageRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.messageID(), "request.messageID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("messageID", request.messageID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/session/{sessionID}/message/{messageID}",
        path,
        query,
        headers,
        body,
        SessionMessageResponse.class);
  }

  /** 异步发送提示。 可传入请求参数。 */
  public Void promptAsync(SessionPromptAsyncRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/prompt_async", path, query, headers, body, Void.class);
  }

  /** 发送会话命令。 可传入请求参数。 */
  public SessionCommandResponse command(SessionCommandRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST",
        "/session/{sessionID}/command",
        path,
        query,
        headers,
        body,
        SessionCommandResponse.class);
  }

  /** 执行会话 Shell 命令。 可传入请求参数。 */
  public AssistantMessage shell(SessionShellRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/shell", path, query, headers, body, AssistantMessage.class);
  }

  /** 撤回消息。 可传入请求参数。 */
  public Session revert(SessionRevertRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute(
        "POST", "/session/{sessionID}/revert", path, query, headers, body, Session.class);
  }

  /** 恢复已撤回消息。 可传入请求参数。 */
  public Session unrevert(SessionUnrevertRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "POST", "/session/{sessionID}/unrevert", path, query, headers, body, Session.class);
  }
}
