package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ReactiveApiTransport;
import ai.opencode.sdk.model.QuestionRequest;
import ai.opencode.sdk.request.QuestionListRequest;
import ai.opencode.sdk.request.QuestionRejectRequest;
import ai.opencode.sdk.request.QuestionReplyRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import reactor.core.publisher.Mono;

/** 问题接口的 Reactive HTTP 客户端封装。 */
public final class ReactiveQuestionApi {
  private final ReactiveApiTransport transport;

  public ReactiveQuestionApi(ReactiveApiTransport transport) {
    this.transport = transport;
  }

  public Mono<List<QuestionRequest>> list() {
    return list(new QuestionListRequest(null));
  }

  public Mono<List<QuestionRequest>> list(QuestionListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (request.directory() != null) query.put("directory", request.directory());
    return transport.execute(
        "GET",
        "/question",
        path,
        query,
        Map.of(),
        null,
        new TypeReference<List<QuestionRequest>>() {});
  }

  public Mono<Boolean> reply(QuestionReplyRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.requestID(), "request.requestID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (request.directory() != null) query.put("directory", request.directory());
    return transport.execute(
        "POST", "/question/{requestID}/reply", path, query, Map.of(), request.body(), Boolean.class);
  }

  public Mono<Boolean> reject(QuestionRejectRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.requestID(), "request.requestID");
    Map<String, Object> path = new LinkedHashMap<String, Object>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<String, Object>();
    if (request.directory() != null) query.put("directory", request.directory());
    return transport.execute(
        "POST", "/question/{requestID}/reject", path, query, Map.of(), null, Boolean.class);
  }
}
