package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class SessionApi {
  private final ApiTransport transport;

  public SessionApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * List sessions
 * Get a list of all OpenCode sessions, sorted by most recently updated.
   */
  public List<Session> list() {
    return list(new SessionListRequest(null, null, null, null, null));
  }

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
    return transport.execute("GET", "/session", path, query, headers, body, new TypeReference<List<Session>>() {});
  }

  /**
 * Create session
 * Create a new OpenCode session for interacting with AI assistants and managing conversations.
   */
  public Session create(SessionCreateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session", path, query, headers, body, Session.class);
  }

  /**
 * Get session status
 * Retrieve the current status of all sessions, including active, idle, and completed states.
   */
  public Map<String, SessionStatus> status() {
    return status(new SessionStatusRequest(null));
  }

  public Map<String, SessionStatus> status(SessionStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/status", path, query, headers, body, new TypeReference<Map<String, SessionStatus>>() {});
  }

  /**
 * Get session
 * Retrieve detailed information about a specific OpenCode session.
   */
  public Session get(SessionGetRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}", path, query, headers, body, Session.class);
  }

  /**
 * Delete session
 * Delete a session and permanently remove all associated data, including messages and history.
   */
  public Boolean delete(SessionDeleteRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("DELETE", "/session/{sessionID}", path, query, headers, body, Boolean.class);
  }

  /**
 * Update session
 * Update properties of an existing session, such as title or other metadata.
   */
  public Session update(SessionUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PATCH", "/session/{sessionID}", path, query, headers, body, Session.class);
  }

  /**
 * Get session children
 * Retrieve all child sessions that were forked from the specified parent session.
   */
  public List<Session> children(SessionChildrenRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}/children", path, query, headers, body, new TypeReference<List<Session>>() {});
  }

  /**
 * Get session todos
 * Retrieve the todo list associated with a specific session, showing tasks and action items.
   */
  public List<Todo> todo(SessionTodoRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}/todo", path, query, headers, body, new TypeReference<List<Todo>>() {});
  }

  /**
 * Initialize session
 * Analyze the current application and create an AGENTS.md file with project-specific agent configurations.
   */
  public Boolean init(SessionInitRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/init", path, query, headers, body, Boolean.class);
  }

  /**
 * Fork session
 * Create a new session by forking an existing session at a specific message point.
   */
  public Session fork(SessionForkRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/fork", path, query, headers, body, Session.class);
  }

  /**
 * Abort session
 * Abort an active session and stop any ongoing AI processing or command execution.
   */
  public Boolean abort(SessionAbortRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/session/{sessionID}/abort", path, query, headers, body, Boolean.class);
  }

  /**
 * Share session
 * Create a shareable link for a session, allowing others to view the conversation.
   */
  public Session share(SessionShareRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/session/{sessionID}/share", path, query, headers, body, Session.class);
  }

  /**
 * Unshare session
 * Remove the shareable link for a session, making it private again.
   */
  public Session unshare(SessionUnshareRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("DELETE", "/session/{sessionID}/share", path, query, headers, body, Session.class);
  }

  /**
 * Get message diff
 * Get the file changes (diff) that resulted from a specific user message in the session.
   */
  public List<FileDiff> diff(SessionDiffRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.messageID() != null) query.put("messageID", request.messageID());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}/diff", path, query, headers, body, new TypeReference<List<FileDiff>>() {});
  }

  /**
 * Summarize session
 * Generate a concise summary of the session using AI compaction to preserve key information.
   */
  public Boolean summarize(SessionSummarizeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/summarize", path, query, headers, body, Boolean.class);
  }

  /**
 * Get session messages
 * Retrieve all messages in a session, including user prompts and AI responses.
   */
  public List<SessionMessagesResponseItem> messages(SessionMessagesRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    if (request.limit() != null) query.put("limit", request.limit());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}/message", path, query, headers, body, new TypeReference<List<SessionMessagesResponseItem>>() {});
  }

  /**
 * Send message
 * Create and send a new message to a session, streaming the AI response.
   */
  public SessionPromptResponse prompt(SessionPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/message", path, query, headers, body, SessionPromptResponse.class);
  }

  /**
 * Get message
 * Retrieve a specific message from a session by its message ID.
   */
  public SessionMessageResponse message(SessionMessageRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("messageID", request.messageID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/session/{sessionID}/message/{messageID}", path, query, headers, body, SessionMessageResponse.class);
  }

  /**
 * Send async message
 * Create and send a new message to a session asynchronously, starting the session if needed and returning immediately.
   */
  public Void promptAsync(SessionPromptAsyncRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/prompt_async", path, query, headers, body, Void.class);
  }

  /**
 * Send command
 * Send a new command to a session for execution by the AI assistant.
   */
  public SessionCommandResponse command(SessionCommandRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/command", path, query, headers, body, SessionCommandResponse.class);
  }

  /**
 * Run shell command
 * Execute a shell command within the session context and return the AI's response.
   */
  public AssistantMessage shell(SessionShellRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/shell", path, query, headers, body, AssistantMessage.class);
  }

  /**
 * Revert message
 * Revert a specific message in a session, undoing its effects and restoring the previous state.
   */
  public Session revert(SessionRevertRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/session/{sessionID}/revert", path, query, headers, body, Session.class);
  }

  /**
 * Restore reverted messages
 * Restore all previously reverted messages in a session.
   */
  public Session unrevert(SessionUnrevertRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/session/{sessionID}/unrevert", path, query, headers, body, Session.class);
  }

}
