package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 检索文件接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param query 检索关键字。
 * @param dirs 参与检索的目录列表。
 * @param type 类型标识。
 * @param limit 返回结果数量上限。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FindFilesRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("query") String query,
    @JsonProperty("dirs") String dirs,
    @JsonProperty("type") String type,
    @JsonProperty("limit") Long limit) {}
