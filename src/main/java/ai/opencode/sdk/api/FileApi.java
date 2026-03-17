package ai.opencode.sdk.api;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.model.File;
import ai.opencode.sdk.model.FileContent;
import ai.opencode.sdk.model.FileNode;
import ai.opencode.sdk.request.FileListRequest;
import ai.opencode.sdk.request.FileReadRequest;
import ai.opencode.sdk.request.FileStatusRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class FileApi {
  private final ApiTransport transport;

  public FileApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** 列出文件。 可传入请求参数。 */
  public List<FileNode> list(FileListRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.path(), "request.path");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("path", request.path());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/file", path, query, headers, body, new TypeReference<List<FileNode>>() {});
  }

  /** 读取文件内容。 可传入请求参数。 */
  public FileContent read(FileReadRequest request) {
    Objects.requireNonNull(request, "request");
    Objects.requireNonNull(request.path(), "request.path");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    query.put("path", request.path());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/file/content", path, query, headers, body, FileContent.class);
  }

  /** 获取文件状态。 */
  public List<File> status() {
    return status(new FileStatusRequest(null));
  }

  /** 获取文件状态。 可传入请求参数。 */
  public List<File> status(FileStatusRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute(
        "GET", "/file/status", path, query, headers, body, new TypeReference<List<File>>() {});
  }
}
