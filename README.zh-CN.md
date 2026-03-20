# opencode Java SDK

面向服务端 `opencode serve` HTTP 接口的 JDK 11+ Java SDK。

[English README](./README.md)

这个项目基于官方 OpenAPI 快照生成，目标是提供稳定、清晰、可维护的服务端 Java HTTP 调用层，而不是封装本地 CLI 或桌面侧流程。

## 项目定位

- 提供类型安全的 HTTP API 调用
- 提供兼容 JDK 11 的生成请求与响应模型
- 提供 `/event` 与 `/global/event` 的阻塞式 SSE 订阅能力
- 提供基于 `ReactiveOpencodeClient` 的 WebFlux / Reactive 调用能力
- 支持基础 URL、超时、自定义请求头和 `x-opencode-directory`

以下能力不在当前公开 Java 接口范围内：

- `mirror`
- `pty`
- `worktree`
- `auth`
- `provider`
- `tui`
- `vcs`
- `tui.control`
- 原始 OpenAPI 中存在但未纳入官方对外文档约束的内部路由

## 当前公开 API 分组

`OpencodeClient` 当前公开以下 API 分组：

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

`ReactiveOpencodeClient` 当前提供以下 reactive API：

- `session`
- `question`
- `event`

## 构建与校验

```bash
mvn spotless:check test
```

如果你想执行完整的单测、覆盖率和格式校验，可以直接运行：

```bash
mvn verify
```

## 集成测试

仓库已经落地独立的 Maven 集成测试方案。启用 `integration` profile 后，测试会自动：

- 创建隔离的临时 HOME 和临时 git 工作区
- 启动一个真实的 `opencode serve`
- 使用真实 HTTP 和 SSE 接口执行 `*IT.java`
- 校验 `/doc`、基础只读接口、文件/VCS、会话生命周期、事件流，以及安全的 TUI / app 接口

前置条件：

- 系统中可直接执行 `opencode`，或者通过 `OPENCODE_BIN=/绝对路径/opencode` 指定
- 系统中可直接执行 `git`

执行命令：

```bash
mvn verify -P integration
```

可选调试环境变量：

- `OPENCODE_BIN`：指定测试时使用的 `opencode` 可执行文件
- `OPENCODE_IT_KEEP_TMP=true`：保留临时 HOME、工作区和服务日志目录，便于排查问题

默认的 `mvn test` / `mvn verify` 行为保持不变；只有显式开启 `integration` profile 时，
这些集成测试才会运行。

补充说明：文档中的 `/find` 路由目前没有纳入默认稳定集成测试。我们在官方
`opencode serve` 的隔离环境下观察到搜索请求偶发会阻塞超过 90 秒客户端超时，因此更适合作为
人工联调或探索性验证项，待上游行为稳定后再纳入必跑集。

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
