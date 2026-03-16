package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ServerConfig(
    @JsonProperty("port") Long port,
    @JsonProperty("hostname") String hostname,
    @JsonProperty("mdns") Boolean mdns,
    @JsonProperty("mdnsDomain") String mdnsDomain,
    @JsonProperty("cors") List<String> cors
) {
}
