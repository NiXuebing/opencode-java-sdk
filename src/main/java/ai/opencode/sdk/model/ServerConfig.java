package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 服务端配置。
 *
 * @param port 端口。
 * @param hostname 主机名。
 * @param mdns 是否启用 mDNS。
 * @param mdnsDomain mDNS 域名。
 * @param cors 跨域来源列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ServerConfig(
    @JsonProperty("port") Long port,
    @JsonProperty("hostname") String hostname,
    @JsonProperty("mdns") Boolean mdns,
    @JsonProperty("mdnsDomain") String mdnsDomain,
    @JsonProperty("cors") List<String> cors) {}
