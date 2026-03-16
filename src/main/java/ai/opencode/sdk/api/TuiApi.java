package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class TuiApi {
  private final ApiTransport transport;
  private final TuiControlApi control;

  public TuiApi(ApiTransport transport) {
    this.transport = transport;
    this.control = new TuiControlApi(transport);

  }

  public TuiControlApi control() {
    return control;
  }

  /**
 * Append TUI prompt
 * Append prompt to the TUI
   */
  public Boolean appendPrompt(TuiAppendPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/append-prompt", path, query, headers, body, Boolean.class);
  }

  /**
 * Open help dialog
 * Open the help dialog in the TUI to display user assistance information.
   */
  public Boolean openHelp() {
    return openHelp(new TuiOpenHelpRequest(null));
  }

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
 * Open sessions dialog
 * Open the session dialog
   */
  public Boolean openSessions() {
    return openSessions(new TuiOpenSessionsRequest(null));
  }

  public Boolean openSessions(TuiOpenSessionsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/open-sessions", path, query, headers, body, Boolean.class);
  }

  /**
 * Open themes dialog
 * Open the theme dialog
   */
  public Boolean openThemes() {
    return openThemes(new TuiOpenThemesRequest(null));
  }

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
 * Open models dialog
 * Open the model dialog
   */
  public Boolean openModels() {
    return openModels(new TuiOpenModelsRequest(null));
  }

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
 * Submit TUI prompt
 * Submit the prompt
   */
  public Boolean submitPrompt() {
    return submitPrompt(new TuiSubmitPromptRequest(null));
  }

  public Boolean submitPrompt(TuiSubmitPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/submit-prompt", path, query, headers, body, Boolean.class);
  }

  /**
 * Clear TUI prompt
 * Clear the prompt
   */
  public Boolean clearPrompt() {
    return clearPrompt(new TuiClearPromptRequest(null));
  }

  public Boolean clearPrompt(TuiClearPromptRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/tui/clear-prompt", path, query, headers, body, Boolean.class);
  }

  /**
 * Execute TUI command
 * Execute a TUI command (e.g. agent_cycle)
   */
  public Boolean executeCommand(TuiExecuteCommandRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/execute-command", path, query, headers, body, Boolean.class);
  }

  /**
 * Show TUI toast
 * Show a toast notification in the TUI
   */
  public Boolean showToast(TuiShowToastRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/show-toast", path, query, headers, body, Boolean.class);
  }

  /**
 * Publish TUI event
 * Publish a TUI event
   */
  public Boolean publish(TuiPublishRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/publish", path, query, headers, body, Boolean.class);
  }

  /**
 * Select session
 * Navigate the TUI to display the specified session.
   */
  public Boolean selectSession(TuiSelectSessionRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/tui/select-session", path, query, headers, body, Boolean.class);
  }

}
