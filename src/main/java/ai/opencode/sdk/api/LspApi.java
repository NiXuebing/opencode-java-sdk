package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.LSPStatus;
import ai.opencode.sdk.request.LspStatusRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 封装LSP 接口相关的 HTTP 调用。 */
public final class LspApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建LSP 接口封装。
   *
   * @param transport 底层传输器。
   */
  public LspApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取 LSP 状态。
   *
   * @return LSP 状态。
   */
  public List<LSPStatus> status() {
    return status(new LspStatusRequest(null));
  }

  /**
   * 获取 LSP 状态。
   *
   * @param request 获取 LSP 状态所需的请求参数。
   * @return LSP 状态。
   */
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
