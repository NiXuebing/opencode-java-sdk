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

/** 文件接口的 HTTP 客户端封装。 */
public final class FileApi {
  private final ApiTransport transport;

  /**
   * 使用底层传输器创建文件接口封装。
   *
   * @param transport 底层传输器。
   */
  public FileApi(ApiTransport transport) {
    this.transport = transport;
  }

  /**
   * 列出文件。
   *
   * @param request 列出文件所需的请求参数，其中 path 为必填项。
   * @return 文件列表。
   */
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

  /**
   * 读取文件内容。
   *
   * @param request 读取文件内容所需的请求参数，其中 path 为必填项。
   * @return 文件内容。
   */
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

  /**
   * 获取文件状态。
   *
   * @return 文件状态。
   */
  public List<File> status() {
    return status(new FileStatusRequest(null));
  }

  /**
   * 获取文件状态。
   *
   * @param request 获取文件状态所需的请求参数。
   * @return 文件状态。
   */
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
