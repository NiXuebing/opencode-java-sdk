package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.Command;
import ai.opencode.sdk.request.CommandListRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 命令接口的 HTTP 客户端封装。 */
public final class CommandApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建命令接口封装。
   *
   * @param transport 底层传输器。
   */
  public CommandApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 列出命令。
   *
   * @return 命令列表。
   */
  public List<Command> list() {
    return list(new CommandListRequest(null));
  }

  /**
   * 列出命令。
   *
   * @param request 列出命令所需的请求参数。
   * @return 命令列表。
   */
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
