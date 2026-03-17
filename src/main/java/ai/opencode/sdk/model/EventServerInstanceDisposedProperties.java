package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 服务端实例已释放事件属性。
 *
 * @param directory 可选的工作目录，会作为查询参数传给服务端。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventServerInstanceDisposedProperties(@JsonProperty("directory") String directory) {}
