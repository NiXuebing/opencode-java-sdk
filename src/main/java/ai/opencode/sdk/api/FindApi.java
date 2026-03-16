package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class FindApi {
  private final ApiTransport transport;

  public FindApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Find text
 * Search for text patterns across files in the project using ripgrep.
   */
  public List<FindTextResponseItem> text(FindTextRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("pattern", request.pattern());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/find", path, query, headers, body, new TypeReference<List<FindTextResponseItem>>() {});
  }

  /**
 * Find files
 * Search for files or directories by name or pattern in the project directory.
   */
  public List<String> files(FindFilesRequest request) {
    Objects.requireNonNull(request, "request");
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
 * Find symbols
 * Search for workspace symbols like functions, classes, and variables using LSP.
   */
  public List<Symbol> symbols(FindSymbolsRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("query", request.query());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/find/symbol", path, query, headers, body, new TypeReference<List<Symbol>>() {});
  }

}
