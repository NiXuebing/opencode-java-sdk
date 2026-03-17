package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PTY已退出事件数据。
 *
 * @param type 类型标识。
 * @param properties 附加属性。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventPtyExited(
    @JsonProperty("type") String type,
    @JsonProperty("properties") EventPtyExitedProperties properties)
    implements Event {}
