package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRuleset(@JsonValue List<PermissionRule> value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public PermissionRuleset {}
}
