package ai.opencode.sdk.api;

import ai.opencode.sdk.core.*;
import ai.opencode.sdk.model.*;
import ai.opencode.sdk.request.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ProviderOauthApi {
  private final ApiTransport transport;

  public ProviderOauthApi(ApiTransport transport) {
    this.transport = transport;

  }


  /**
 * OAuth authorize
 * Initiate OAuth authorization for a specific AI provider to get an authorization URL.
   */
  public ProviderAuthAuthorization authorize(ProviderOauthAuthorizeRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/provider/{providerID}/oauth/authorize", path, query, headers, body, ProviderAuthAuthorization.class);
  }

  /**
 * OAuth callback
 * Handle the OAuth callback from a provider after user authorization.
   */
  public Boolean callback(ProviderOauthCallbackRequest request) {
    Objects.requireNonNull(request, "request");
    Map<String, Object> path = new LinkedHashMap<>();
    path.put("providerID", request.providerID());
    Map<String, Object> query = new LinkedHashMap<>();
    if (request.directory() != null) query.put("directory", request.directory());
    Map<String, String> headers = Map.of();
    Object body = request.body();
    return transport.execute("POST", "/provider/{providerID}/oauth/callback", path, query, headers, body, Boolean.class);
  }

}
