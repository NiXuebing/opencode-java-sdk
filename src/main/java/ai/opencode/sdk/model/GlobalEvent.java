package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 全局事件数据模型。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 * @param payload payload。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record GlobalEvent(
    @JsonProperty("directory") String directory, @JsonProperty("payload") Event payload) {}
