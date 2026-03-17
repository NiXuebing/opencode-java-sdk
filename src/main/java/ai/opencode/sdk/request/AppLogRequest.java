package ai.opencode.sdk.request;

import ai.opencode.sdk.model.AppLogBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 写入日志接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 写入日志的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppLogRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") AppLogBody body) {}
