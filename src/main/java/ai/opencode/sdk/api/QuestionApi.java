package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class QuestionApi {
  private final ApiTransport transport;

  public QuestionApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * List pending questions
 * Get all pending question requests across all sessions.
   */
  public List<QuestionRequest> list() {
    return list(new QuestionListRequest(null));
  }

  public List<QuestionRequest> list(QuestionListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/question", path, query, headers, body, new TypeReference<List<QuestionRequest>>() {});
  }

  /**
 * Reply to question request
 * Provide answers to a question request from the AI assistant.
   */
  public Boolean reply(QuestionReplyRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/question/{requestID}/reply", path, query, headers, body, Boolean.class);
  }

  /**
 * Reject question request
 * Reject a question request from the AI assistant.
   */
  public Boolean reject(QuestionRejectRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/question/{requestID}/reject", path, query, headers, body, Boolean.class);
  }

}
