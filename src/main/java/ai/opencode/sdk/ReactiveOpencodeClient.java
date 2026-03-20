package ai.opencode.sdk;

import ai.opencode.sdk.api.ReactiveEventApi;
import ai.opencode.sdk.api.ReactiveQuestionApi;
import ai.opencode.sdk.api.ReactiveSessionApi;
import ai.opencode.sdk.core.ReactiveApiTransport;
import ai.opencode.sdk.core.ReactiveOpencodeClientConfig;

/** 用于在 WebFlux 中访问 OpenCode serve HTTP 接口的 Reactive 客户端。 */
public final class ReactiveOpencodeClient {
  private final ReactiveApiTransport transport;
  private final ReactiveSessionApi session;
  private final ReactiveQuestionApi question;
  private final ReactiveEventApi event;

  public ReactiveOpencodeClient() {
    this(ReactiveOpencodeClientConfig.builder().build());
  }

  public ReactiveOpencodeClient(ReactiveOpencodeClientConfig config) {
    this.transport = new ReactiveApiTransport(config);
    this.session = new ReactiveSessionApi(transport);
    this.question = new ReactiveQuestionApi(transport);
    this.event = new ReactiveEventApi(transport);
  }

  public ReactiveSessionApi session() {
    return session;
  }

  public ReactiveQuestionApi question() {
    return question;
  }

  public ReactiveEventApi event() {
    return event;
  }
}
