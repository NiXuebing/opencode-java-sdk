package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 执行文本检索接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param pattern 匹配模式。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindTextRequest(
    @JsonProperty("directory") String directory, @JsonProperty("pattern") String pattern) {}
