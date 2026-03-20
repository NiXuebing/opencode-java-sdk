# opencode Java SDK

JDK 11+ Java SDK for the server-side `opencode serve` HTTP API.

[中文说明](./README.zh-CN.md)

This project is generated from the official OpenAPI schema snapshot and intentionally focuses on server-side API access:

- Typed HTTP API calls
- Generated request and response models compatible with JDK 11
- Blocking SSE event stream support
- Reactive WebFlux client support via `ReactiveOpencodeClient`
- Request configuration for base URL, timeout, headers, and working directory header

It does not include local `opencode serve` startup helpers, TUI wrappers, VCS helpers, provider auth flows, or terminal control APIs.

The generated Java surface intentionally follows the endpoints documented in the official SDK and Server docs. Internal or undocumented routes that may still appear in the raw OpenAPI are not exposed through `OpencodeClient`.

The SDK keeps the public surface focused on server-side coding workflows instead of desktop-side controls.

## API groups

The current public surface exposed by `OpencodeClient` includes these API groups:

- `global`
- `project`
- `config`
- `tool`
- `session`
- `permission`
- `question`
- `find`
- `file`
- `mcp`
- `instance`
- `path`
- `command`
- `app`
- `lsp`
- `formatter`
- `event`

`ReactiveOpencodeClient` currently provides reactive access for:

- `session`
- `question`
- `event`

Notable exclusions from the public Java surface:

- `mirror`
- `pty`
- `worktree`
- `auth`
- `provider`
- `tui`
- `vcs`
- `tui.control`
- undocumented internal route groups from the raw OpenAPI snapshot

## What is included

- Typed API groups exposed from `OpencodeClient`
- Reactive session/question/event APIs exposed from `ReactiveOpencodeClient`
- Generated request and response models from `openapi.json`
- Blocking SSE event stream support for `/event` and `/global/event`
- Reactive SSE event stream support for `/event`
- Configurable base URL, timeouts, headers, and `x-opencode-directory`

## Build and test

```bash
mvn spotless:check test
```

Run the full unit-test + coverage gate locally with:

```bash
mvn verify
```

## Integration tests

The repository now includes a dedicated Maven integration-test profile that boots a real
`opencode serve` process in an isolated temporary HOME and workspace, then runs `*IT.java`
against the live HTTP/SSE endpoints.

Prerequisites:

- `opencode` must be available on `PATH`, or provide `OPENCODE_BIN=/absolute/path/to/opencode`
- `git` must be available on `PATH`

Run the full integration suite with:

```bash
mvn verify -P integration
```

What the integration profile does:

- creates a temporary git workspace with sample files
- starts an isolated `opencode serve` instance on a random localhost port
- points `OpencodeClient` at that live server using `x-opencode-directory`
- validates real `/doc`, core HTTP APIs, SSE streams, session lifecycle, file/VCS endpoints, and safe TUI/app endpoints

Helpful environment variables:

- `OPENCODE_BIN`: path to a specific `opencode` binary
- `OPENCODE_IT_KEEP_TMP=true`: keep the temporary HOME/workspace/log directory for debugging

The default `mvn test` / `mvn verify` flow is unchanged. Integration tests only run when the
`integration` profile is explicitly enabled.

Note: the documented `/find` routes are currently left out of the default stable integration suite.
Against the official `opencode serve` process we observed search requests occasionally blocking past
the 90-second client timeout in a clean-room test environment, so they are better treated as
exploratory/manual verification until the upstream behavior is consistently deterministic.

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

## Supported workflows

This SDK is best suited for:

- remote control of an already running `opencode serve` instance
- typed session, project, provider, file, search, and event operations
- integrations that need SSE subscription support for `/event` and `/global/event`

It is intentionally not a wrapper for local CLI process orchestration.

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
