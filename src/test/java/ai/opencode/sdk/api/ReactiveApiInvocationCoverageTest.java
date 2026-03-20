package ai.opencode.sdk.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.core.ReactiveApiTransport;
import ai.opencode.sdk.core.ReactiveOpencodeClientConfig;
import ai.opencode.sdk.core.SseEvent;
import ai.opencode.sdk.testutil.SampleFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class ReactiveApiInvocationCoverageTest {
  private final SampleFactory sampleFactory = new SampleFactory();

  @Test
  void everyReactiveApiMethodInvokesTransport() throws Exception {
    var transport = new RecordingReactiveTransport();
    var apis =
        List.of(
            new ReactiveEventApi(transport),
            new ReactiveQuestionApi(transport),
            new ReactiveSessionApi(transport));

    int expectedTransportCalls = 0;
    for (Object api : apis) {
      for (Method method : publicMethods(api.getClass())) {
        int before = transport.invocations.size();
        Object result = method.invoke(api, argumentsFor(method));

        assertNotNull(result, method.getName());
        assertTrue(result instanceof Mono || result instanceof Flux, method.getName());
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
    Type[] parameterTypes = method.getGenericParameterTypes();
    Object[] arguments = new Object[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++) {
      arguments[i] = sampleFactory.sample(parameterTypes[i]);
    }
    return arguments;
  }

  private List<Method> publicMethods(Class<?> type) {
    var methods = new ArrayList<Method>();
    for (Method method : type.getDeclaredMethods()) {
      if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
        methods.add(method);
      }
    }
    methods.sort(java.util.Comparator.comparing(Method::getName));
    return methods;
  }

  private static final class RecordingReactiveTransport extends ReactiveApiTransport {
    private final List<Invocation> invocations = new ArrayList<Invocation>();

    private RecordingReactiveTransport() {
      super(ReactiveOpencodeClientConfig.builder().build());
    }

    @Override
    public <T> Mono<T> execute(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        Class<T> type) {
      invocations.add(
          new Invocation("execute-class", method, route, path, query, headers, body, type));
      return Mono.empty();
    }

    @Override
    public <T> Mono<T> execute(
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
      return Mono.empty();
    }

    @Override
    public <T> Flux<SseEvent<T>> stream(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        Class<T> type) {
      invocations.add(
          new Invocation("stream-class", method, route, path, query, headers, body, type));
      return Flux.empty();
    }

    @Override
    public <T> Flux<SseEvent<T>> stream(
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        TypeReference<T> type) {
      invocations.add(
          new Invocation("stream-type", method, route, path, query, headers, body, type.getType()));
      return Flux.empty();
    }
  }

  private static final class Invocation {
    private final String kind;
    private final String method;
    private final String route;
    private final Map<String, Object> path;
    private final Map<String, Object> query;
    private final Map<String, String> headers;
    private final Object body;
    private final Type responseType;

    private Invocation(
        String kind,
        String method,
        String route,
        Map<String, Object> path,
        Map<String, Object> query,
        Map<String, String> headers,
        Object body,
        Type responseType) {
      this.kind = kind;
      this.method = method;
      this.route = route;
      this.path = path;
      this.query = query;
      this.headers = headers;
      this.body = body;
      this.responseType = responseType;
    }

    private String kind() {
      return kind;
    }

    private String method() {
      return method;
    }

    private String route() {
      return route;
    }

    private Map<String, Object> path() {
      return path;
    }

    private Map<String, Object> query() {
      return query;
    }

    private Map<String, String> headers() {
      return headers;
    }

    private Object body() {
      return body;
    }

    private Type responseType() {
      return responseType;
    }
  }
}
