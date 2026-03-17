package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

/**
 * MCP远程配置。
 *
 * @param type 类型标识。
 * @param url 可访问的地址。
 * @param enabled 是否启用。
 * @param headers 自定义请求头集合。
 * @param oauth OAuth。
 * @param timeout 请求超时时间。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record McpRemoteConfig(
    @JsonProperty("type") String type,
    @JsonProperty("url") String url,
    @JsonProperty("enabled") Boolean enabled,
    @JsonProperty("headers") Map<String, String> headers,
    @JsonProperty("oauth") JsonNode oauth,
    @JsonProperty("timeout") Long timeout)
    implements McpAddBodyConfig {}
