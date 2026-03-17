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

public final class FindApi {
  private final ApiTransport transport;

  public FindApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 执行文本检索。 可传入请求参数。 */
  public List<FindTextResponseItem> text(FindTextRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.pattern(), "request.pattern");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("pattern", request.pattern());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/find",
        path,
        query,
        headers,
        body,
        new TypeReference<List<FindTextResponseItem>>() {});
  }

  /** 检索文件。 可传入请求参数。 */
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
    return transport.execute(
        "GET", "/find/file", path, query, headers, body, new TypeReference<List<String>>() {});
  }

  /** 检索符号。 可传入请求参数。 */
  public List<Symbol> symbols(FindSymbolsRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.query(), "request.query");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("query", request.query());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/find/symbol", path, query, headers, body, new TypeReference<List<Symbol>>() {});
  }
}
