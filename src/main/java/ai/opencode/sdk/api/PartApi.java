package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class PartApi {
  private final ApiTransport transport;

  public PartApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * Delete a part from a message
   */
  public Boolean delete(PartDeleteRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("messageID", request.messageID());
    path.put("partID", request.partID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("DELETE", "/session/{sessionID}/message/{messageID}/part/{partID}", path, query, headers, body, Boolean.class);
  }

  /**
 * Update a part in a message
   */
  public Part update(PartUpdateRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("sessionID", request.sessionID());
    path.put("messageID", request.messageID());
    path.put("partID", request.partID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("PATCH", "/session/{sessionID}/message/{messageID}/part/{partID}", path, query, headers, body, Part.class);
  }

}
