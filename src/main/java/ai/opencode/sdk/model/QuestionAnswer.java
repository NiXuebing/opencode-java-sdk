package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionAnswer(@JsonValue List<String> value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public QuestionAnswer {
  }
}
