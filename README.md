# opencode Java SDK

JDK 17 Java SDK for the `opencode` HTTP API.

This project is generated from the repository OpenAPI schema and intentionally focuses on API access only:

- Typed HTTP API calls
- Generated request and response models
- Blocking SSE event stream support
- Request configuration for base URL, timeout, headers, and working directory header

It does not include local `opencode serve` startup helpers or TUI process wrappers.

## What is included

- Typed API groups exposed from `OpencodeClient`
- Generated request and response models from `openapi.json`
- Blocking SSE event stream support for `/event`, `/global/event`, and `/mirror/event`
- Configurable base URL, timeouts, headers, and `x-opencode-directory`

## Build and test

```bash
mvn test
```

## CI

GitHub Actions is set up to run `mvn test` on:

- pushes to `main`
- all pull requests

The workflow lives in `.github/workflows/ci.yml`.

## Regenerate

```bash
node script/generate.mjs
```

`script/generate.mjs` prefers the sibling `../opencode/packages/sdk/openapi.json` file when it exists, and falls back to this repository's checked-in `openapi.json` snapshot everywhere else, including GitHub Actions.

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
