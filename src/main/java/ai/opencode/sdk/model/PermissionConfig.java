package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionConfig(@JsonValue JsonNode value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public PermissionConfig {}
}
