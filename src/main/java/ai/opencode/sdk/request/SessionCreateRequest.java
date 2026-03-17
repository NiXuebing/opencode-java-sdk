package ai.opencode.sdk.request;

import ai.opencode.sdk.model.SessionCreateBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建会话接口的请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 创建会话对应的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionCreateRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") SessionCreateBody body) {}
