package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ExperimentalApi {
  private final ApiTransport transport;
  private final ExperimentalResourceApi resource;

  public ExperimentalApi(ApiTransport transport) {
    this.transport = transport;
    this.resource = new ExperimentalResourceApi(transport);

  }

  public ExperimentalResourceApi resource() {
    return resource;
  }

}
