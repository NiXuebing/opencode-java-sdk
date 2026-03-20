package ai.opencode.sdk.testutil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.function.BiPredicate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

public final class TestHttpSupport {
  private TestHttpSupport() {}

  public static HttpHeaders headers(java.util.Map<String, List<String>> values) {
    return HttpHeaders.of(values, alwaysTrue());
  }

  public static String readBody(HttpRequest request) {
    var publisher = request.bodyPublisher();
    if (publisher.isEmpty()) return "";

    var output = new ByteArrayOutputStream();
    var completed = new CompletableFuture<Void>();
    publisher
        .orElseThrow()
        .subscribe(
            new Flow.Subscriber<>() {
              private Flow.Subscription subscription;

              @Override
              public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
              }

              @Override
              public void onNext(ByteBuffer item) {
                var copy = item.slice();
                var bytes = new byte[copy.remaining()];
                copy.get(bytes);
                output.writeBytes(bytes);
              }

              @Override
              public void onError(Throwable throwable) {
                completed.completeExceptionally(throwable);
              }

              @Override
              public void onComplete() {
                completed.complete(null);
              }
            });

    completed.join();
    return output.toString(StandardCharsets.UTF_8);
  }

  public static final class StubHttpClient extends HttpClient {
    @FunctionalInterface
    public interface Sender {
      HttpResponse<?> send(HttpRequest request, HttpResponse.BodyHandler<?> handler)
          throws IOException, InterruptedException;
    }

    private final Sender sender;

    public StubHttpClient(Sender sender) {
      this.sender = sender;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> handler)
        throws IOException, InterruptedException {
      return (HttpResponse<T>) sender.send(request, handler);
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) {
      return CompletableFuture.failedFuture(new UnsupportedOperationException());
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendAsync(
        HttpRequest request,
        HttpResponse.BodyHandler<T> responseBodyHandler,
        HttpResponse.PushPromiseHandler<T> pushPromiseHandler) {
      return CompletableFuture.failedFuture(new UnsupportedOperationException());
    }

    @Override
    public Optional<CookieHandler> cookieHandler() {
      return Optional.empty();
    }

    @Override
    public Optional<Duration> connectTimeout() {
      return Optional.empty();
    }

    @Override
    public Redirect followRedirects() {
      return Redirect.NEVER;
    }

    @Override
    public Optional<ProxySelector> proxy() {
      return Optional.empty();
    }

    @Override
    public SSLContext sslContext() {
      try {
        return SSLContext.getDefault();
      } catch (NoSuchAlgorithmException error) {
        throw new IllegalStateException(error);
      }
    }

    @Override
    public SSLParameters sslParameters() {
      return new SSLParameters();
    }

    @Override
    public Optional<Authenticator> authenticator() {
      return Optional.empty();
    }

    @Override
    public Version version() {
      return Version.HTTP_1_1;
    }

    @Override
    public Optional<Executor> executor() {
      return Optional.empty();
    }

    @Override
    public WebSocket.Builder newWebSocketBuilder() {
      throw new UnsupportedOperationException();
    }
  }

  public static final class StubHttpResponse<T> implements HttpResponse<T> {
    private final int statusCode;
    private final T body;
    private final HttpHeaders headers;
    private final HttpRequest request;

    public StubHttpResponse(int statusCode, T body, HttpHeaders headers, HttpRequest request) {
      this.statusCode = statusCode;
      this.body = body;
      this.headers = headers;
      this.request = request;
    }

    @Override
    public int statusCode() {
      return statusCode;
    }

    @Override
    public HttpRequest request() {
      return request;
    }

    @Override
    public Optional<HttpResponse<T>> previousResponse() {
      return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
      return headers;
    }

    @Override
    public T body() {
      return body;
    }

    @Override
    public Optional<SSLSession> sslSession() {
      return Optional.empty();
    }

    @Override
    public URI uri() {
      return request.uri();
    }

    @Override
    public HttpClient.Version version() {
      return HttpClient.Version.HTTP_1_1;
    }
  }

  private static BiPredicate<String, String> alwaysTrue() {
    return (left, right) -> true;
  }
}
