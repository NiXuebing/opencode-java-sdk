package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 全局健康状态响应数据。
 *
 * @param healthy 服务端是否健康。
 * @param version 版本号。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GlobalHealthResponse(
    @JsonProperty("healthy") Boolean healthy, @JsonProperty("version") String version) {}
