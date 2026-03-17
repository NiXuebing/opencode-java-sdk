package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MCP浏览器打开失败事件属性。
 *
 * @param mcpName MCP 服务名称。
 * @param url 可访问的地址。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventMcpBrowserOpenFailedProperties(
    @JsonProperty("mcpName") String mcpName, @JsonProperty("url") String url) {}
