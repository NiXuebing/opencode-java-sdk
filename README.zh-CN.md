# opencode Java SDK

面向官方 `opencode serve` HTTP 接口的 JDK 17 Java SDK。

[English README](./README.md)

这个项目基于官方 OpenAPI 快照生成，目标是提供稳定、清晰、可维护的 Java HTTP 调用层，而不是封装本地 CLI 启动流程。

## 项目定位

- 提供类型安全的 HTTP API 调用
- 提供生成的请求与响应模型
- 提供 `/event` 与 `/global/event` 的阻塞式 SSE 订阅能力
- 支持基础 URL、超时、自定义请求头和 `x-opencode-directory`

以下能力不在当前公开 Java 接口范围内：

- `mirror`
- `pty`
- `worktree`
- `question`
- `tui.control`
- 原始 OpenAPI 中存在但未纳入官方对外文档约束的内部路由

## 当前公开 API 分组

`OpencodeClient` 当前公开以下 API 分组：

- `global`
- `auth`
- `project`
- `config`
- `tool`
- `session`
- `permission`
- `provider`
- `find`
- `file`
- `mcp`
- `tui`
- `instance`
- `path`
- `vcs`
- `command`
- `app`
- `lsp`
- `formatter`
- `event`

## 构建与校验

```bash
mvn spotless:check test
```

CI 会在以下场景执行同样的校验：

- `main` 分支 push
- 所有 pull request

相关工作流位于：

- `.github/workflows/ci.yml`
- `.github/workflows/publish-package.yml`

## 重新生成代码

默认使用仓库中已提交的 `openapi.json` 快照重新生成：

```bash
node script/generate.mjs
```

当前仓库内的快照基于官方稳定版 `v1.2.27` 更新。

如果你需要使用其它下载好的 OpenAPI 快照重新生成，可以显式指定：

```bash
OPENCODE_OPENAPI_SOURCE=/path/to/openapi.json node script/generate.mjs
```

生成后建议执行：

```bash
mvn spotless:apply
```

## 接入方式

### 添加依赖

```xml
<dependency>
  <groupId>ai.opencode</groupId>
  <artifactId>opencode-java-sdk</artifactId>
  <version>0.1.0</version>
</dependency>
```

### 添加 GitHub Packages 仓库

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

### 配置 Maven 认证

本仓库通过 GitHub Packages 分发。一个最小可用的 `~/.m2/settings.xml` 示例：

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

安装依赖至少需要 `read:packages` 权限；本地发布则需要可写包权限的 classic PAT。

## 使用示例

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

## 适用场景

当前 SDK 更适合以下场景：

- 连接并控制已经运行中的 `opencode serve`
- 通过类型化接口访问 session、project、provider、file、find、event 等能力
- 在 Java 集成中订阅 SSE 事件流

它不负责：

- 本地启动 `opencode serve`
- 包装 TUI 进程生命周期
- 提供终端控制队列接口

## 发布说明

本仓库当前只配置了 GitHub Packages 发布，不包含 Maven Central 配置。

发布工作流支持两种触发方式：

- 手动触发 `workflow_dispatch`
- 发布 GitHub Release 时自动触发

发布命令使用：

```bash
mvn deploy
```

### 发布前检查清单

1. 更新 `pom.xml` 中的版本号。
2. 提交并推送版本改动。
3. 创建 GitHub Release。
4. 等待 `Publish Package` 工作流完成上传。
