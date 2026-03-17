package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 事件PtyExited属性。
 *
 * @param id 唯一标识。
 * @param exitCode exit代码。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventPtyExitedProperties(
    @JsonProperty("id") String id, @JsonProperty("exitCode") Double exitCode) {}
