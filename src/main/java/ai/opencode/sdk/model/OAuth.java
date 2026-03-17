package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record OAuth(
    @JsonProperty("type") String type,
    @JsonProperty("refresh") String refresh,
    @JsonProperty("access") String access,
    @JsonProperty("expires") Double expires,
    @JsonProperty("accountId") String accountId,
    @JsonProperty("enterpriseUrl") String enterpriseUrl)
    implements Auth {}
