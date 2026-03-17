package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 工作树就绪事件属性。
 *
 * @param name 名称。
 * @param branch 分支。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventWorktreeReadyProperties(
    @JsonProperty("name") String name, @JsonProperty("branch") String branch) {}
