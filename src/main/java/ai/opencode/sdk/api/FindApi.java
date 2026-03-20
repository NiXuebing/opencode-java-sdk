package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.FindTextResponseItem;
import ai.opencode.sdk.model.Symbol;
import ai.opencode.sdk.request.FindFilesRequest;
import ai.opencode.sdk.request.FindSymbolsRequest;
import ai.opencode.sdk.request.FindTextRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 检索接口的 HTTP 客户端封装。 */
public final class FindApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建检索接口封装。
   *
   * @param transport 底层传输器。
   */
  public FindApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 执行文本检索。
   *
   * @param request 执行文本检索所需的请求参数，其中 pattern 为必填项。
   * @return 匹配的文本片段列表。
   */
  public List<FindTextResponseItem> text(FindTextRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.pattern(), "request.pattern");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("pattern", request.pattern());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/find", path, query, headers, body, new TypeReference<List<FindTextResponseItem>>() {});
  }

  /**
   * 检索文件。
   *
   * @param request 检索文件所需的请求参数，其中 query 为必填项。
   * @return 匹配的文件路径列表。
   */
  public List<String> files(FindFilesRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.query(), "request.query");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("query", request.query());
    if (request.dirs() != null) query.put("dirs", request.dirs());
    if (request.type() != null) query.put("type", request.type());
    if (request.limit() != null) query.put("limit", request.limit());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/find/file", path, query, headers, body, new TypeReference<List<String>>() {});
  }

  /**
   * 检索符号。
   *
   * @param request 检索符号所需的请求参数，其中 query 为必填项。
   * @return 匹配的符号列表。
   */
  public List<Symbol> symbols(FindSymbolsRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.query(), "request.query");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("query", request.query());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/find/symbol", path, query, headers, body, new TypeReference<List<Symbol>>() {});
  }

}
