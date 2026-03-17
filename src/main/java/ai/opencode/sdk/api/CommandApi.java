package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Command;
import ai.opencode.sdk.request.CommandListRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class CommandApi {
  private final ApiTransport transport;

  public CommandApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 列出命令。 */
  public List<Command> list() {
    return list(new CommandListRequest(null));
  }

  /** 列出命令。 可传入请求参数。 */
  public List<Command> list(CommandListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/command", path, query, headers, body, new TypeReference<List<Command>>() {});
  }
}
