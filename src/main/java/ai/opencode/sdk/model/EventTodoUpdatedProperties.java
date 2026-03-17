package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventTodoUpdatedProperties(
    @JsonProperty("sessionID") String sessionID, @JsonProperty("todos") List<Todo> todos) {}
