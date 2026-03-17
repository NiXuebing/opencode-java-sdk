package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolIDs(@JsonValue List<String> value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ToolIDs {}
}
