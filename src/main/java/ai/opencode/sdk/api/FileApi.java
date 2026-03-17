package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

public final class FileApi {
  private final ApiTransport transport;

  public FileApi(ApiTransport transport) {
    this.transport = transport;
  }

  /** List files List files and directories in a specified path. */
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

  /** Read file Read the content of a specified file. */
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

  /** Get file status Get the git status of all files in the project. */
  public List<File> status() {
    return status(new FileStatusRequest(null));
  }

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
