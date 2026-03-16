package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class CommandApi {
  private final ApiTransport transport;

  public CommandApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * List commands
 * Get a list of all available commands in the OpenCode system.
   */
  public List<Command> list() {
    return list(new CommandListRequest(null));
  }

  public List<Command> list(CommandListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/command", path, query, headers, body, new TypeReference<List<Command>>() {});
  }

}
