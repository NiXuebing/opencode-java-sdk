package ai.opencode.sdk.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取工具列表接口的请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param provider 提供商标识。
 * @param model 模型配置。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolListRequest(
    @JsonProperty("directory") String directory,
    @JsonProperty("provider") String provider,
    @JsonProperty("model") String model) {}
