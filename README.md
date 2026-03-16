# opencode Java SDK

JDK 17 Java SDK for the `opencode` HTTP API.

This project is generated from the repository OpenAPI schema and intentionally focuses on API access only:

- Typed HTTP API calls
- Generated request and response models
- Blocking SSE event stream support
- Request configuration for base URL, timeout, headers, and working directory header

It does not include local `opencode serve` startup helpers or TUI process wrappers.

## Regenerate

```bash
node script/generate.mjs
```

## Build

```bash
mvn test
```

## Example

```java
import ai.opencode.sdk.OpencodeClient;
import ai.opencode.sdk.core.OpencodeClientConfig;

var client = new OpencodeClient(
    OpencodeClientConfig.builder()
        .baseUrl("http://localhost:4096")
        .build()
);

var health = client.global().health();
System.out.println(health.version());
```
