package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 检索符号接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param query 检索关键字。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindSymbolsRequest(
    @JsonProperty("directory") String directory, @JsonProperty("query") String query) {}
