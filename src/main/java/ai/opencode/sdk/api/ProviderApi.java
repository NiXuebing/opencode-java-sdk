package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ProviderApi {
  private final ApiTransport transport;
  private final ProviderOauthApi oauth;

  public ProviderApi(ApiTransport transport) {
    this.transport = transport;
    this.oauth = new ProviderOauthApi(transport);

  }

  public ProviderOauthApi oauth() {
    return oauth;
  }

  /**
 * List providers
 * Get a list of all available AI providers, including both available and connected ones.
   */
  public ProviderListResponse list() {
    return list(new ProviderListRequest(null));
  }

  public ProviderListResponse list(ProviderListRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/provider", path, query, headers, body, ProviderListResponse.class);
  }

  /**
 * Get provider auth methods
 * Retrieve available authentication methods for all AI providers.
   */
  public Map<String, List<ProviderAuthMethod>> auth() {
    return auth(new ProviderAuthRequest(null));
  }

  public Map<String, List<ProviderAuthMethod>> auth(ProviderAuthRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = Map.of();
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = null;
    return transport.execute("GET", "/provider/auth", path, query, headers, body, new TypeReference<Map<String, List<ProviderAuthMethod>>>() {});
  }

}
