package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ModelCapabilities(
    @JsonProperty("temperature") Boolean temperature,
    @JsonProperty("reasoning") Boolean reasoning,
    @JsonProperty("attachment") Boolean attachment,
    @JsonProperty("toolcall") Boolean toolcall,
    @JsonProperty("input") ModelCapabilitiesInput input,
    @JsonProperty("output") ModelCapabilitiesOutput output,
    @JsonProperty("interleaved") JsonNode interleaved) {}
