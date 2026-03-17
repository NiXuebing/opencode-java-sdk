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

/** 会话接口的 HTTP 客户端封装。 */
public final class SessionApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建会话接口封装。
   *
   * @param transport 底层传输器。
   */
  public SessionApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 列出会话。
   *
   * @return 会话列表。
   */
  public List<Session> list() {
    return list(new SessionListRequest(null, null, null, null, null));
  }

  /**
   * 列出会话。
   *
   * @param request 列出会话所需的请求参数。
   * @return 会话列表。
   */
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

  /**
   * 创建会话。
   *
   * @param request 创建会话所需的请求参数，其中 body 为必填项。
   * @return 会话。
   */
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

  /**
   * 获取会话状态。
   *
   * @return 会话状态。
   */
  public Map<String, SessionStatus> status() {
    return status(new SessionStatusRequest(null));
  }

  /**
   * 获取会话状态。
   *
   * @param request 获取会话状态所需的请求参数。
   * @return 会话状态。
   */
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

  /**
   * 获取会话。
   *
   * @param request 获取会话所需的请求参数，其中 sessionID 为必填项。
   * @return 会话。
   */
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

  /**
   * 删除会话。
   *
   * @param request 删除会话所需的请求参数，其中 sessionID 为必填项。
   * @return 操作是否成功。
   */
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

  /**
   * 更新会话。
   *
   * @param request 更新会话所需的请求参数，其中 sessionID、body 为必填项。
   * @return 会话。
   */
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

  /**
   * 获取子会话。
   *
   * @param request 获取子会话所需的请求参数，其中 sessionID 为必填项。
   * @return 子会话。
   */
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

  /**
   * 获取会话待办。
   *
   * @param request 获取会话待办所需的请求参数，其中 sessionID 为必填项。
   * @return 会话待办。
   */
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

  /**
   * 初始化会话。
   *
   * @param request 初始化会话所需的请求参数，其中 sessionID、body 为必填项。
   * @return 操作是否成功。
   */
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

  /**
   * 派生会话。
   *
   * @param request 派生会话所需的请求参数，其中 sessionID、body 为必填项。
   * @return 会话。
   */
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

  /**
   * 中止会话。
   *
   * @param request 中止会话所需的请求参数，其中 sessionID 为必填项。
   * @return 操作是否成功。
   */
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

  /**
   * 分享会话。
   *
   * @param request 分享会话所需的请求参数，其中 sessionID 为必填项。
   * @return 会话。
   */
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

  /**
   * 取消分享会话。
   *
   * @param request 取消分享会话所需的请求参数，其中 sessionID 为必填项。
   * @return 会话。
   */
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

  /**
   * 获取会话差异。
   *
   * @param request 获取会话差异所需的请求参数，其中 sessionID 为必填项。
   * @return 会话差异。
   */
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

  /**
   * 总结会话。
   *
   * @param request 总结会话所需的请求参数，其中 sessionID、body 为必填项。
   * @return 操作是否成功。
   */
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

  /**
   * 列出会话消息。
   *
   * @param request 列出会话消息所需的请求参数，其中 sessionID 为必填项。
   * @return 会话消息列表。
   */
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

  /**
   * 发送会话提示。
   *
   * @param request 发送会话提示所需的请求参数，其中 sessionID、body 为必填项。
   * @return 会话提示词响应。
   */
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

  /**
   * 获取消息详情。
   *
   * @param request 获取消息详情所需的请求参数，其中 sessionID、messageID 为必填项。
   * @return 消息详情。
   */
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

  /**
   * 异步发送提示。
   *
   * @param request 异步发送提示所需的请求参数，其中 sessionID、body 为必填项。
   * @return 无返回值。
   */
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

  /**
   * 发送会话命令。
   *
   * @param request 发送会话命令所需的请求参数，其中 sessionID、body 为必填项。
   * @return 会话命令响应。
   */
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

  /**
   * 执行会话 Shell 命令。
   *
   * @param request 执行会话 Shell 命令所需的请求参数，其中 sessionID、body 为必填项。
   * @return 助手消息。
   */
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

  /**
   * 撤回消息。
   *
   * @param request 撤回消息所需的请求参数，其中 sessionID、body 为必填项。
   * @return 会话。
   */
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

  /**
   * 恢复已撤回消息。
   *
   * @param request 恢复已撤回消息所需的请求参数，其中 sessionID 为必填项。
   * @return 会话。
   */
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
