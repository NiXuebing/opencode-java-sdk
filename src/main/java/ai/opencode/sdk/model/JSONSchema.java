package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class JSONSchema extends LinkedHashMap<String, JsonNode> {
  public JSONSchema() {
    super();
  }
}
