package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionObjectConfig extends LinkedHashMap<String, PermissionActionConfig> {
  public PermissionObjectConfig() {
    super();
  }
}
