package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.FormatterStatus;
import ai.opencode.sdk.request.FormatterStatusRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** 格式化器接口的 HTTP 客户端封装。 */
public final class FormatterApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建格式化器接口封装。
   *
   * @param transport 底层传输器。
   */
  public FormatterApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 获取格式化器状态。
   *
   * @return 格式化器状态。
   */
  public List<FormatterStatus> status() {
    return status(new FormatterStatusRequest(null));
  }

  /**
   * 获取格式化器状态。
   *
   * @param request 获取格式化器状态所需的请求参数。
   * @return 格式化器状态。
   */
  public List<FormatterStatus> status(FormatterStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET",
        "/formatter",
        path,
        query,
        headers,
        body,
        new TypeReference<List<FormatterStatus>>() {});
  }
}
