package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class FormatterApi {
  private final ApiTransport transport;

  public FormatterApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Get formatter status
 * Get formatter status
   */
  public List<FormatterStatus> status() {
    return status(new FormatterStatusRequest(null));
  }

  public List<FormatterStatus> status(FormatterStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/formatter", path, query, headers, body, new TypeReference<List<FormatterStatus>>() {});
  }

}
