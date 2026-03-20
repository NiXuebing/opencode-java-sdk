package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.QuestionRequest;
import ai.opencode.sdk.request.QuestionListRequest;
import ai.opencode.sdk.request.QuestionRejectRequest;
import ai.opencode.sdk.request.QuestionReplyRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 问题接口的 HTTP 客户端封装。 */
public final class QuestionApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建问题接口封装。
   *
   * @param transport 底层传输器。
   */
  public QuestionApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 列出待处理问题。
   *
   * @return 待处理问题列表。
   */
  public List<QuestionRequest> list() {
    return list(new QuestionListRequest(null));
  }

  /**
   * 列出待处理问题。
   *
   * @param request 列出待处理问题所需的请求参数。
   * @return 待处理问题列表。
   */
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
   * 回复问题请求。
   *
   * @param request 回复问题请求所需的请求参数，其中 requestID、body 为必填项。
   * @return 操作是否成功。
   */
  public Boolean reply(QuestionReplyRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.requestID(), "request.requestID");
    Objects.requireNonNull(request.body(), "request.body");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/question/{requestID}/reply", path, query, headers, body, Boolean.class);
  }

  /**
   * 拒绝问题请求。
   *
   * @param request 拒绝问题请求所需的请求参数，其中 requestID 为必填项。
   * @return 操作是否成功。
   */
  public Boolean reject(QuestionRejectRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.requestID(), "request.requestID");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("requestID", request.requestID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("POST", "/question/{requestID}/reject", path, query, headers, body, Boolean.class);
  }

}
