package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 拒绝问题请求接口请求参数。
 *
 * @param requestID 请求 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionRejectRequest {
  @JsonProperty("requestID")
  private final String requestID;
  @JsonProperty("directory")
  private final String directory;

  /** 创建问题Reject请求。 */
  @JsonCreator
  public QuestionRejectRequest(
      @JsonProperty("requestID") String requestID,
      @JsonProperty("directory") String directory
  ) {
    this.requestID = requestID;
    this.directory = directory;
  }

  /**
   * 获取请求ID。
   *
   * @return 请求 ID。
   */
  public String requestID() {
    return requestID;
  }

  /**
   * 获取目录。
   *
   * @return 可选的工作目录，会作为查询参数传给服务端。
   */
  public String directory() {
    return directory;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionRejectRequest)) return false;
    QuestionRejectRequest that = (QuestionRejectRequest) other;
    return Objects.equals(requestID, that.requestID)
        && Objects.equals(directory, that.directory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestID, directory);
  }

  @Override
  public String toString() {
    return "QuestionRejectRequest{" +
        "requestID=" + requestID + "," +
        "directory=" + directory +
        "}";
  }
}
