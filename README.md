# opencode Java SDK

JDK 17 Java SDK for the documented `opencode serve` HTTP API.

This project is generated from the official OpenAPI schema snapshot and intentionally focuses on API access only:

- Typed HTTP API calls
- Generated request and response models
- Blocking SSE event stream support
- Request configuration for base URL, timeout, headers, and working directory header

It does not include local `opencode serve` startup helpers, TUI process wrappers, or TUI control queue APIs.

The generated Java surface intentionally follows the endpoints documented in the official SDK and Server docs. Internal or undocumented routes that may still appear in the raw OpenAPI are not exposed through `OpencodeClient`.

The SDK also intentionally omits `tui.control` endpoints to keep the public surface focused on direct HTTP API calls instead of terminal control queue coordination.

## What is included

- Typed API groups exposed from `OpencodeClient`
- Generated request and response models from `openapi.json`
- Blocking SSE event stream support for `/event` and `/global/event`
- Configurable base URL, timeouts, headers, and `x-opencode-directory`

## Build and test

```bash
mvn spotless:check test
```

## CI

GitHub Actions is set up to run `mvn spotless:check test` on:

- pushes to `main`
- all pull requests

The workflow lives in `.github/workflows/ci.yml`.

## Regenerate

```bash
node script/generate.mjs
```

`script/generate.mjs` regenerates from this repository's checked-in `openapi.json` snapshot by default.

The checked-in snapshot is updated from the official `opencode` stable release. The current snapshot was refreshed from `v1.2.27` on March 16, 2026.

If you want to regenerate from another downloaded snapshot, pass it explicitly:

```bash
OPENCODE_OPENAPI_SOURCE=/path/to/openapi.json node script/generate.mjs
```

After regeneration, format the generated sources before committing:

```bash
mvn spotless:apply
```

## Use the SDK

### Add the dependency

```xml
<dependency>
  <groupId>ai.opencode</groupId>
  <artifactId>opencode-java-sdk</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Add the GitHub Packages repository

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/nixuebing/opencode-java-sdk</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

### Authenticate Maven

GitHub Packages Maven auth uses a personal access token (classic) for local development and installs. A minimal `~/.m2/settings.xml` looks like this:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_CLASSIC_PAT</password>
    </server>
  </servers>
</settings>
```

For this private repository, the token should include at least `read:packages` for installs. For local publishing, use a classic PAT that can write packages.

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

## Publish to GitHub Packages

Publishing is wired to GitHub Packages only. Maven Central is not configured in this repository.

The publish workflow lives in `.github/workflows/publish-package.yml` and can run in two ways:

- manually through `workflow_dispatch`
- automatically when a GitHub Release is published

The workflow uses `GITHUB_TOKEN` and the `distributionManagement` entry in `pom.xml` to run:

```bash
mvn deploy
```

### Release checklist

1. Update `pom.xml` to the version you want to publish.
2. Commit and push the version change.
3. Create a GitHub Release.
4. Let the `Publish Package` workflow upload the artifact to GitHub Packages.

For the first stable release in this repository, use `0.1.0` and create the GitHub Release with tag `v0.1.0`.
