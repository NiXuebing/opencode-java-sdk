package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 列出会话接口的请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param roots 是否仅返回根会话。
 * @param start 分页起始位置或游标。
 * @param search 搜索关键字。
 * @param limit 返回结果数量上限。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessionListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("roots") Boolean roots,
    @JsonProperty("start") Double start,
    @JsonProperty("search") String search,
    @JsonProperty("limit") Double limit) {}
