package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class JSONSchema extends LinkedHashMap<String, JsonNode> {
  public JSONSchema() {
    super();
  }
}
