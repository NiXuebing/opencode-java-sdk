package ai.opencode.sdk.integration;

import ai.opencode.sdk.OpencodeClient;

/** 集成测试基类，复用同一个隔离 serve 环境。 */
abstract class AbstractIntegrationTest {
  protected final OpencodeIntegrationEnvironment environment =
      OpencodeIntegrationEnvironment.shared();
  protected final OpencodeClient client = environment.client();
}
