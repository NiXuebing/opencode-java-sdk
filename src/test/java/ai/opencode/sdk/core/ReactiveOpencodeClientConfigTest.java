package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

class ReactiveOpencodeClientConfigTest {
  @Test
  void builderProvidesDocumentedDefaults() {
    var config = ReactiveOpencodeClientConfig.builder().build();

    assertEquals("http://localhost:4096", config.baseUrl());
    assertNotNull(config.webClient());
    assertNotNull(config.objectMapper());
    assertEquals(Duration.ofSeconds(30), config.timeout());
    assertTrue(config.headers().isEmpty());
  }

  @Test
  void builderCopiesAndOverridesCustomValues() {
    var headers = new LinkedHashMap<String, String>();
    headers.put("x-one", "1");
    var mapper = new ObjectMapper();
    var webClient = WebClient.builder().baseUrl("http://example.com").build();

    var config =
        ReactiveOpencodeClientConfig.builder()
            .baseUrl("http://example.com")
            .webClient(webClient)
            .objectMapper(mapper)
            .headers(headers)
            .header("x-two", "2")
            .timeout(Duration.ofSeconds(5))
            .directory("/workspace/sample")
            .build();

    headers.put("x-three", "3");

    assertEquals("http://example.com", config.baseUrl());
    assertEquals(webClient, config.webClient());
    assertEquals(mapper, config.objectMapper());
    assertEquals(Duration.ofSeconds(5), config.timeout());
    assertEquals("/workspace/sample", config.directory());
    assertEquals(Map.of("x-one", "1", "x-two", "2"), config.headers());
  }
}
