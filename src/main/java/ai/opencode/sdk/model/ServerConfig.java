package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 服务端配置。
 *
 * @param port port。
 * @param hostname hostname。
 * @param mdns mdns标记。
 * @param mdnsDomain mdnsDomain。
 * @param cors cors列表。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ServerConfig(
    @JsonProperty("port") Long port,
    @JsonProperty("hostname") String hostname,
    @JsonProperty("mdns") Boolean mdns,
    @JsonProperty("mdnsDomain") String mdnsDomain,
    @JsonProperty("cors") List<String> cors) {}
