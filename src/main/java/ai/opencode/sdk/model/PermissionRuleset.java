package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRuleset(@JsonValue List<PermissionRule> value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public PermissionRuleset {}
}
