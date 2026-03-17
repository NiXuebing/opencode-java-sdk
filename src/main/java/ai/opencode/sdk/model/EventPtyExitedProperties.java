package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PTY已退出事件属性。
 *
 * @param id 唯一标识。
 * @param exitCode 退出码。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventPtyExitedProperties(
    @JsonProperty("id") String id, @JsonProperty("exitCode") Double exitCode) {}
