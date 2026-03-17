package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MCP Add请求体。
 *
 * @param name 名称。
 * @param config 配置内容。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpAddBody(
    @JsonProperty("name") String name, @JsonProperty("config") McpAddBodyConfig config) {}
