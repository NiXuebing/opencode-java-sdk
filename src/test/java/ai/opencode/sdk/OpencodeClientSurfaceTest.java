package ai.opencode.sdk;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import ai.opencode.sdk.core.OpencodeClientConfig;
import java.time.Duration;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class OpencodeClientSurfaceTest {
  @Test
  void everyGetterReturnsStableApiInstance() throws Exception {
    var headers = new LinkedHashMap<String, String>();
    headers.put("x-test-header", "value");

    var client =
        new OpencodeClient(
            OpencodeClientConfig.builder()
                .baseUrl("http://localhost:4096/")
                .headers(headers)
                .timeout(Duration.ofSeconds(5))
                .directory("/workspace/sample")
                .build());

    for (var method : OpencodeClient.class.getDeclaredMethods()) {
      if (!java.lang.reflect.Modifier.isPublic(method.getModifiers())) continue;

      var first = method.invoke(client);
      var second = method.invoke(client);

      assertNotNull(first, method.getName());
      assertSame(first, second, method.getName());
    }

    assertSame(client.provider().oauth(), client.provider().oauth());
  }
}
