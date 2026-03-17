package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ConfigLsp2Value(@JsonValue JsonNode value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ConfigLsp2Value {}
}
