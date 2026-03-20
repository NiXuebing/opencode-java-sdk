package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ReactiveApiTransport;
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
import reactor.core.publisher.Mono;

/** 会话接口的 Reactive HTTP 客户端封装。 */
public final class ReactiveSessionApi {
  private final ReactiveApiTransport transport;

  public ReactiveSessionApi(ReactiveApiTransport transport) {
    this.transport = transport;
  }

  public Mono<List<Session>> list() {
    return list(new SessionListRequest(null, null, null, null, null));
  }

  public Mono<List<Session>> list(SessionListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.roots() != null) query.put("roots", request.roots());
    if (request.start() != null) query.put("start", request.start());
    if (request.search() != null) query.put("search", request.search());
    if (request.limit() != null) query.put("limit", request.limit());
    return transport.execute(
        "GET", "/session", Map.of(), query, Map.of(), null, new TypeReference<List<Session>>() {});
  }

  public Mono<Session> create(SessionCreateRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.body(), "request.body");
    return transport.execute(
        "POST", "/session", Map.of(), directoryQuery(request.directory()), Map.of(), request.body(), Session.class);
  }

  public Mono<Map<String, SessionStatus>> status() {
    return status(new SessionStatusRequest(null));
  }

  public Mono<Map<String, SessionStatus>> status(SessionStatusRequest request) {
    Objects.requireNonNull(request, "request");
    return transport.execute(
        "GET",
        "/session/status",
        Map.of(),
        directoryQuery(request.directory()),
        Map.of(),
        null,
        new TypeReference<Map<String, SessionStatus>>() {});
  }

  public Mono<Session> get(SessionGetRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "GET", "/session/{sessionID}", path, directoryQuery(request.directory()), Map.of(), null, Session.class);
  }

  public Mono<Boolean> delete(SessionDeleteRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "DELETE", "/session/{sessionID}", path, directoryQuery(request.directory()), Map.of(), null, Boolean.class);
  }

  public Mono<Session> update(SessionUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "PATCH",
        "/session/{sessionID}",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Session.class);
  }

  public Mono<List<Session>> children(SessionChildrenRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "GET",
        "/session/{sessionID}/children",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        new TypeReference<List<Session>>() {});
  }

  public Mono<List<Todo>> todo(SessionTodoRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "GET",
        "/session/{sessionID}/todo",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        new TypeReference<List<Todo>>() {});
  }

  public Mono<Boolean> init(SessionInitRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/init",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Boolean.class);
  }

  public Mono<Session> fork(SessionForkRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/fork",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Session.class);
  }

  public Mono<Boolean> abort(SessionAbortRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/abort",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        Boolean.class);
  }

  public Mono<Session> share(SessionShareRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/share",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        Session.class);
  }

  public Mono<Session> unshare(SessionUnshareRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "DELETE",
        "/session/{sessionID}/share",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        Session.class);
  }

  public Mono<List<FileDiff>> diff(SessionDiffRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = directoryQuery(request.directory());
    if (request.messageID() != null) query.put("messageID", request.messageID());
    return transport.execute(
        "GET",
        "/session/{sessionID}/diff",
        path,
        query,
        Map.of(),
        null,
        new TypeReference<List<FileDiff>>() {});
  }

  public Mono<Boolean> summarize(SessionSummarizeRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/summarize",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Boolean.class);
  }

  public Mono<List<SessionMessagesResponseItem>> messages(SessionMessagesRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = directoryQuery(request.directory());
    if (request.limit() != null) query.put("limit", request.limit());
    return transport.execute(
        "GET",
        "/session/{sessionID}/message",
        path,
        query,
        Map.of(),
        null,
        new TypeReference<List<SessionMessagesResponseItem>>() {});
  }

  public Mono<SessionPromptResponse> prompt(SessionPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/message",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        SessionPromptResponse.class);
  }

  public Mono<SessionMessageResponse> message(SessionMessageRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.messageID(), "request.messageID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    path.put("messageID", request.messageID());
    return transport.execute(
        "GET",
        "/session/{sessionID}/message/{messageID}",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        SessionMessageResponse.class);
  }

  public Mono<Void> promptAsync(SessionPromptAsyncRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/prompt_async",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Void.class);
  }

  public Mono<SessionCommandResponse> command(SessionCommandRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/command",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        SessionCommandResponse.class);
  }

  public Mono<AssistantMessage> shell(SessionShellRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/shell",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        AssistantMessage.class);
  }

  public Mono<Session> revert(SessionRevertRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/revert",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        request.body(),
        Session.class);
  }

  public Mono<Session> unrevert(SessionUnrevertRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.sessionID(), "request.sessionID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("sessionID", request.sessionID());
    return transport.execute(
        "POST",
        "/session/{sessionID}/unrevert",
        path,
        directoryQuery(request.directory()),
        Map.of(),
        null,
        Session.class);
  }

  private Map<String, Object> directoryQuery(String directory) {
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (directory != null) {
      query.put("directory", directory);
    }
    return query;
  }
}
