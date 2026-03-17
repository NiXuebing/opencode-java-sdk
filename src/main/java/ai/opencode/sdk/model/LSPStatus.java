package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LSP状态。
 *
 * @param id 唯一标识。
 * @param name 名称。
 * @param root root。
 * @param status 当前状态。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record LSPStatus(
    @JsonProperty("id") String id,
    @JsonProperty("name") String name,
    @JsonProperty("root") String root,
    @JsonProperty("status") String status) {}
