package ai.opencode.sdk.request;

import ai.opencode.sdk.model.Config;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 更新配置接口请求参数。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param body 更新配置的请求体。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigUpdateRequest(
    @JsonProperty("directory") String directory, @JsonProperty("body") Config body) {}
