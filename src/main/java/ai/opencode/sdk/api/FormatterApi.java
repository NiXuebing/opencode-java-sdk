package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.FormatterStatus;
import ai.opencode.sdk.request.FormatterStatusRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class FormatterApi {
  private final ApiTransport transport;

  public FormatterApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 获取格式化器状态。 */
  public List<FormatterStatus> status() {
    return status(new FormatterStatusRequest(null));
  }

  /** 获取格式化器状态。 可传入请求参数。 */
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
