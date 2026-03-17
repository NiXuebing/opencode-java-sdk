package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

public final class LspApi {
  private final ApiTransport transport;

  public LspApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** Get LSP status Get LSP server status */
  public List<LSPStatus> status() {
    return status(new LspStatusRequest(null));
  }

  public List<LSPStatus> status(LspStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/lsp", path, query, headers, body, new TypeReference<List<LSPStatus>>() {});
  }
}
