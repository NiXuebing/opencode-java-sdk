package ai.opencode.sdk.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.core.ApiTransport;
import ai.opencode.sdk.core.OpencodeClientConfig;
import ai.opencode.sdk.testutil.SampleFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiInvocationCoverageTest {
  private final SampleFactory sampleFactory = new SampleFactory();

  @Test
  void everyApiMethodEitherInvokesTransportOrReturnsNestedAccessor() throws Exception {
    var transport = new RecordingTransport();
    var apis =
        List.of(
            new AppApi(transport),
            new AuthApi(transport),
            new CommandApi(transport),
            new ConfigApi(transport),
            new EventApi(transport),
            new FileApi(transport),
            new FindApi(transport),
            new FormatterApi(transport),
            new GlobalApi(transport),
            new InstanceApi(transport),
            new LspApi(transport),
            new McpApi(transport),
            new PathApi(transport),
            new PermissionApi(transport),
            new ProjectApi(transport),
            new ProviderApi(transport),
            new ProviderOauthApi(transport),
            new SessionApi(transport),
            new ToolApi(transport),
            new TuiApi(transport),
            new VcsApi(transport));

    int expectedTransportCalls = 0;
    for (var api : apis) {
      for (var method : publicMethods(api.getClass())) {
        int before = transport.invocations.size();
        var result = method.invoke(api, argumentsFor(method));

        if (api instanceof ProviderApi && method.getName().equals("oauth")) {
          assertNotNull(result);
          assertTrue(result instanceof ProviderOauthApi);
          assertEquals(before, transport.invocations.size());
          continue;
        }

        expectedTransportCalls++;
        assertEquals(before + 1, transport.invocations.size(), api.getClass().getSimpleName());
      }
    }

    assertEquals(expectedTransportCalls, transport.invocations.size());
    assertTrue(
        transport.invocations.stream()
            .allMatch(
                invocation ->
                    invocation.method() != null
                        && !invocation.method().isBlank()
                        && invocation.route() != null
                        && invocation.route().startsWith("/")));
  }

  private Object[] argumentsFor(Method method) {
    var parameterTypes = method.getGenericParameterTypes();
    var arguments = new Object[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++) {
      arguments[i] = sampleFactory.sample(parameterTypes[i]);
    }
    return arguments;
  }

  private List<Method> publicMethods(Class<?> type) {
    var methods = new ArrayList<Method>();
    for (var method : type.getDeclaredMethods()) {
      if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
        methods.add(method);
      }
    }
    methods.sort(java.util.Comparator.comparing(Method::getName));
    return methods;
  }

  private static final class RecordingTransport extends ApiTransport {
    private final List<Invocation> invocations = new ArrayList<>();

    private RecordingTransport() {
      super(OpencodeClientConfig.builder().build());
    }

    @Override
    public <T> T execute(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        Class<T> type) {
      invocations.add(
          new Invocation("execute-class", method, route, path, query, headers, body, type));
      return null;
    }

    @Override
    public <T> T execute(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        TypeReference<T> type) {
      invocations.add(
          new Invocation(
              "execute-type", method, route, path, query, headers, body, type.getType()));
      return null;
    }

    @Override
    public <T> ai.opencode.sdk.core.SseEventStream<T> stream(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        Class<T> type) {
      invocations.add(
          new Invocation("stream-class", method, route, path, query, headers, body, type));
      return null;
    }

    @Override
    public <T> ai.opencode.sdk.core.SseEventStream<T> stream(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        TypeReference<T> type) {
      invocations.add(
          new Invocation("stream-type", method, route, path, query, headers, body, type.getType()));
      return null;
    }
  }

  private record Invocation(
      String kind,
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Type responseType) {}
}
