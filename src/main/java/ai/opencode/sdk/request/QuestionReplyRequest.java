package ai.opencode.sdk.request;

import ai.opencode.sdk.model.QuestionReplyBody;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * 回复问题请求接口请求参数。
 *
 * @param requestID 请求 ID。
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 回复问题请求的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuestionReplyRequest {
  @JsonProperty("requestID")
  private final String requestID;
  @JsonProperty("directory")
  private final String directory;
  @JsonProperty("body")
  private final QuestionReplyBody body;

  /** 创建问题回复请求。 */
  @JsonCreator
  public QuestionReplyRequest(
      @JsonProperty("requestID") String requestID,
      @JsonProperty("directory") String directory,
      @JsonProperty("body") QuestionReplyBody body
  ) {
    this.requestID = requestID;
    this.directory = directory;
    this.body = body;
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

  /**
   * 获取请求体。
   *
   * @return 请求体内容。
   */
  public QuestionReplyBody body() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof QuestionReplyRequest)) return false;
    QuestionReplyRequest that = (QuestionReplyRequest) other;
    return Objects.equals(requestID, that.requestID)
        && Objects.equals(directory, that.directory)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestID, directory, body);
  }

  @Override
  public String toString() {
    return "QuestionReplyRequest{" +
        "requestID=" + requestID + "," +
        "directory=" + directory + "," +
        "body=" + body +
        "}";
  }
}
