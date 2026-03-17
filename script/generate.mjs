#!/usr/bin/env node

import { access, mkdir, readFile, rm, writeFile, copyFile } from "node:fs/promises"
import path from "node:path"
import { fileURLToPath } from "node:url"

const here = path.dirname(fileURLToPath(import.meta.url))
const root = path.resolve(here, "..")
const target = path.join(root, "openapi.json")
const javaRoot = path.join(root, "src/main/java")
const rootPackage = "ai.opencode.sdk"
const modelPackage = `${rootPackage}.model`
const apiPackage = `${rootPackage}.api`
const requestPackage = `${rootPackage}.request`
const corePackage = `${rootPackage}.core`

async function existing(candidates) {
  for (const candidate of candidates) {
    try {
      await access(candidate)
      return candidate
    } catch {
      // noop
    }
  }

  throw new Error(`No OpenAPI source found. Checked: ${candidates.join(", ")}`)
}

const source = process.env.OPENCODE_OPENAPI_SOURCE
  ? await existing([
      path.resolve(root, process.env.OPENCODE_OPENAPI_SOURCE),
      process.env.OPENCODE_OPENAPI_SOURCE,
    ])
  : target
const rawSpec = JSON.parse(await readFile(source, "utf8"))

if (source !== target) {
  await copyFile(source, target)
}
await rm(path.join(javaRoot, "ai"), { recursive: true, force: true })

const componentTypes = new Map()
const defs = new Map()
const inlineNames = new Map()
const namesInUse = new Set()
const variantInterfaces = new Map()
const operationTypes = new Map()

const preferredDiscriminators = ["type", "role", "name", "status", "kind", "mode"]
const documentedOperations = new Set([
  "GET /global/health",
  "GET /global/event",
  "GET /project",
  "GET /project/current",
  "GET /path",
  "GET /vcs",
  "POST /instance/dispose",
  "GET /config",
  "PATCH /config",
  "GET /config/providers",
  "GET /provider",
  "GET /provider/auth",
  "POST /provider/{providerID}/oauth/authorize",
  "POST /provider/{providerID}/oauth/callback",
  "GET /session",
  "POST /session",
  "GET /session/status",
  "GET /session/{sessionID}",
  "DELETE /session/{sessionID}",
  "PATCH /session/{sessionID}",
  "GET /session/{sessionID}/children",
  "GET /session/{sessionID}/todo",
  "POST /session/{sessionID}/init",
  "POST /session/{sessionID}/fork",
  "POST /session/{sessionID}/abort",
  "POST /session/{sessionID}/share",
  "DELETE /session/{sessionID}/share",
  "GET /session/{sessionID}/diff",
  "POST /session/{sessionID}/summarize",
  "POST /session/{sessionID}/revert",
  "POST /session/{sessionID}/unrevert",
  "POST /session/{sessionID}/permissions/{permissionID}",
  "GET /session/{sessionID}/message",
  "POST /session/{sessionID}/message",
  "GET /session/{sessionID}/message/{messageID}",
  "POST /session/{sessionID}/prompt_async",
  "POST /session/{sessionID}/command",
  "POST /session/{sessionID}/shell",
  "GET /command",
  "GET /find",
  "GET /find/file",
  "GET /find/symbol",
  "GET /file",
  "GET /file/content",
  "GET /file/status",
  "GET /experimental/tool/ids",
  "GET /experimental/tool",
  "GET /lsp",
  "GET /formatter",
  "GET /mcp",
  "POST /mcp",
  "GET /agent",
  "POST /log",
  "POST /tui/append-prompt",
  "POST /tui/open-help",
  "POST /tui/open-sessions",
  "POST /tui/open-themes",
  "POST /tui/open-models",
  "POST /tui/submit-prompt",
  "POST /tui/clear-prompt",
  "POST /tui/execute-command",
  "POST /tui/show-toast",
  "PUT /auth/{providerID}",
  "GET /event",
])
const zhOperationSummary = new Map([
  ["GET /global/health", "获取全局健康状态"],
  ["GET /global/event", "订阅全局事件"],
  ["GET /project", "列出项目"],
  ["GET /project/current", "获取当前项目"],
  ["GET /path", "获取路径信息"],
  ["GET /vcs", "获取版本控制信息"],
  ["POST /instance/dispose", "释放实例"],
  ["GET /config", "获取配置"],
  ["PATCH /config", "更新配置"],
  ["GET /config/providers", "获取提供商配置"],
  ["GET /provider", "列出提供商"],
  ["GET /provider/auth", "获取提供商认证信息"],
  ["POST /provider/{providerID}/oauth/authorize", "发起提供商 OAuth 授权"],
  ["POST /provider/{providerID}/oauth/callback", "处理提供商 OAuth 回调"],
  ["GET /session", "列出会话"],
  ["POST /session", "创建会话"],
  ["GET /session/status", "获取会话状态"],
  ["GET /session/{sessionID}", "获取会话"],
  ["DELETE /session/{sessionID}", "删除会话"],
  ["PATCH /session/{sessionID}", "更新会话"],
  ["GET /session/{sessionID}/children", "获取子会话"],
  ["GET /session/{sessionID}/todo", "获取会话待办"],
  ["POST /session/{sessionID}/init", "初始化会话"],
  ["POST /session/{sessionID}/fork", "派生会话"],
  ["POST /session/{sessionID}/abort", "中止会话"],
  ["POST /session/{sessionID}/share", "分享会话"],
  ["DELETE /session/{sessionID}/share", "取消分享会话"],
  ["GET /session/{sessionID}/diff", "获取会话差异"],
  ["POST /session/{sessionID}/summarize", "总结会话"],
  ["POST /session/{sessionID}/revert", "撤回消息"],
  ["POST /session/{sessionID}/unrevert", "恢复已撤回消息"],
  ["POST /session/{sessionID}/permissions/{permissionID}", "响应权限请求"],
  ["GET /session/{sessionID}/message", "列出会话消息"],
  ["POST /session/{sessionID}/message", "发送会话提示"],
  ["GET /session/{sessionID}/message/{messageID}", "获取消息详情"],
  ["POST /session/{sessionID}/prompt_async", "异步发送提示"],
  ["POST /session/{sessionID}/command", "发送会话命令"],
  ["POST /session/{sessionID}/shell", "执行会话 Shell 命令"],
  ["GET /command", "列出命令"],
  ["GET /find", "执行文本检索"],
  ["GET /find/file", "检索文件"],
  ["GET /find/symbol", "检索符号"],
  ["GET /file", "列出文件"],
  ["GET /file/content", "读取文件内容"],
  ["GET /file/status", "获取文件状态"],
  ["GET /experimental/tool/ids", "获取工具 ID 列表"],
  ["GET /experimental/tool", "获取工具列表"],
  ["GET /lsp", "获取 LSP 状态"],
  ["GET /formatter", "获取格式化器状态"],
  ["GET /mcp", "获取 MCP 状态"],
  ["POST /mcp", "添加 MCP 服务"],
  ["GET /agent", "列出代理"],
  ["POST /log", "写入日志"],
  ["POST /tui/append-prompt", "追加 TUI 输入"],
  ["POST /tui/open-help", "打开 TUI 帮助"],
  ["POST /tui/open-sessions", "打开 TUI 会话面板"],
  ["POST /tui/open-themes", "打开 TUI 主题面板"],
  ["POST /tui/open-models", "打开 TUI 模型面板"],
  ["POST /tui/submit-prompt", "提交 TUI 输入"],
  ["POST /tui/clear-prompt", "清空 TUI 输入"],
  ["POST /tui/execute-command", "执行 TUI 命令"],
  ["POST /tui/show-toast", "显示 TUI 提示"],
  ["PUT /auth/{providerID}", "设置提供商认证"],
  ["GET /event", "订阅服务事件"],
])
const zhApiAccessorSummary = new Map([
  ["global", "全局接口"],
  ["auth", "认证接口"],
  ["project", "项目接口"],
  ["config", "配置接口"],
  ["tool", "工具接口"],
  ["session", "会话接口"],
  ["permission", "权限接口"],
  ["provider", "提供商接口"],
  ["provider.oauth", "提供商 OAuth 子接口"],
  ["find", "检索接口"],
  ["file", "文件接口"],
  ["mcp", "MCP 接口"],
  ["tui", "TUI 接口"],
  ["instance", "实例接口"],
  ["path", "路径接口"],
  ["vcs", "版本控制接口"],
  ["command", "命令接口"],
  ["app", "应用接口"],
  ["lsp", "LSP 接口"],
  ["formatter", "格式化器接口"],
  ["event", "事件订阅接口"],
])
const zhTokenSummary = new Map([
  ["absolute", "绝对"],
  ["access", "访问"],
  ["account", "账户"],
  ["agent", "代理"],
  ["api", "API"],
  ["app", "应用"],
  ["append", "追加"],
  ["args", "参数"],
  ["assistant", "助手"],
  ["asked", "已请求"],
  ["auth", "认证"],
  ["authorization", "授权"],
  ["async", "异步"],
  ["auto", "自动"],
  ["attachment", "附件"],
  ["attachments", "附件"],
  ["audio", "音频"],
  ["available", "可用"],
  ["all", "所有"],
  ["batch", "批量"],
  ["body", "请求体"],
  ["browser", "浏览器"],
  ["build", "构建"],
  ["branch", "分支"],
  ["cache", "缓存"],
  ["call", "调用"],
  ["callback", "回调"],
  ["capabilities", "能力"],
  ["character", "字符"],
  ["changed", "已变更"],
  ["client", "客户端"],
  ["children", "子项"],
  ["clear", "清空"],
  ["code", "代码"],
  ["command", "命令"],
  ["commands", "命令"],
  ["completed", "已完成"],
  ["compacted", "已压缩"],
  ["compaction", "压缩"],
  ["config", "配置"],
  ["connected", "已连接"],
  ["connection", "连接"],
  ["continue", "继续"],
  ["content", "内容"],
  ["context", "上下文"],
  ["cost", "成本"],
  ["deletions", "删除行数"],
  ["cwd", "工作目录"],
  ["create", "创建"],
  ["created", "已创建"],
  ["current", "当前"],
  ["data", "数据"],
  ["default", "默认"],
  ["delta", "增量"],
  ["deny", "拒绝"],
  ["delete", "删除"],
  ["deleted", "已删除"],
  ["diagnostics", "诊断"],
  ["diff", "差异"],
  ["directory", "目录"],
  ["disabled", "已禁用"],
  ["doom", "死循环"],
  ["dispose", "释放"],
  ["disposed", "已释放"],
  ["edit", "编辑"],
  ["edited", "已编辑"],
  ["enabled", "启用"],
  ["enterprise", "企业版"],
  ["env", "环境变量"],
  ["environment", "环境变量"],
  ["error", "错误"],
  ["event", "事件"],
  ["execute", "执行"],
  ["executed", "已执行"],
  ["experimental", "实验性"],
  ["exit", "退出"],
  ["exited", "已退出"],
  ["extension", "扩展名"],
  ["extensions", "扩展名"],
  ["failed", "失败"],
  ["family", "家族"],
  ["field", "字段"],
  ["file", "文件"],
  ["files", "文件"],
  ["find", "检索"],
  ["fork", "派生"],
  ["format", "格式"],
  ["formatter", "格式化器"],
  ["general", "通用"],
  ["get", "获取"],
  ["global", "全局"],
  ["glob", "通配"],
  ["grep", "grep"],
  ["header", "标题头"],
  ["health", "健康状态"],
  ["help", "帮助"],
  ["hidden", "隐藏"],
  ["hints", "提示"],
  ["home", "主目录"],
  ["hunk", "代码块"],
  ["hunks", "代码块"],
  ["idle", "空闲"],
  ["ignore", "忽略"],
  ["ignored", "已忽略"],
  ["image", "图像"],
  ["info", "信息"],
  ["init", "初始化"],
  ["initialization", "初始化"],
  ["input", "输入"],
  ["installation", "安装"],
  ["instance", "实例"],
  ["instructions", "说明"],
  ["interleaved", "交错"],
  ["item", "项"],
  ["kind", "类型"],
  ["json", "JSON"],
  ["layout", "布局"],
  ["label", "标签"],
  ["line", "行"],
  ["lines", "行"],
  ["limit", "限制"],
  ["list", "列表"],
  ["local", "本地"],
  ["log", "日志"],
  ["lsp", "LSP"],
  ["max", "最大"],
  ["match", "匹配"],
  ["mcp", "MCP"],
  ["mdns", "mDNS"],
  ["message", "消息"],
  ["messages", "消息"],
  ["method", "方法"],
  ["mime", "MIME"],
  ["mode", "模式"],
  ["model", "模型"],
  ["models", "模型"],
  ["modalities", "模态"],
  ["multiple", "多选"],
  ["native", "原生"],
  ["needs", "需要"],
  ["next", "下一项"],
  ["npm", "npm"],
  ["oauth", "OAuth"],
  ["open", "打开"],
  ["options", "选项"],
  ["offset", "偏移"],
  ["output", "输出"],
  ["over", "超长"],
  ["overflow", "溢出"],
  ["old", "旧"],
  ["original", "原始"],
  ["part", "片段"],
  ["parts", "片段"],
  ["patch", "补丁"],
  ["path", "路径"],
  ["paths", "路径"],
  ["payload", "载荷"],
  ["pdf", "PDF"],
  ["pending", "等待中"],
  ["permission", "权限"],
  ["plan", "规划"],
  ["plugin", "插件"],
  ["port", "端口"],
  ["primary", "主要"],
  ["priority", "优先级"],
  ["project", "项目"],
  ["projects", "项目"],
  ["prune", "裁剪"],
  ["prompt", "提示词"],
  ["properties", "属性"],
  ["provider", "提供商"],
  ["providers", "提供商"],
  ["pty", "PTY"],
  ["question", "问题"],
  ["range", "范围"],
  ["ready", "就绪"],
  ["reasoning", "推理"],
  ["answers", "回答"],
  ["read", "读取"],
  ["registration", "注册"],
  ["remote", "远程"],
  ["remove", "移除"],
  ["removed", "已移除"],
  ["reply", "回复"],
  ["request", "请求"],
  ["respond", "响应"],
  ["response", "响应"],
  ["retry", "重试"],
  ["retries", "重试"],
  ["retryable", "可重试"],
  ["replied", "已响应"],
  ["rejected", "已拒绝"],
  ["release", "发布"],
  ["reserved", "预留"],
  ["root", "根目录"],
  ["revert", "撤回"],
  ["role", "角色"],
  ["running", "运行中"],
  ["sandbox", "沙箱"],
  ["sandboxes", "沙箱"],
  ["schema", "结构"],
  ["scope", "范围"],
  ["secret", "密钥"],
  ["select", "选择"],
  ["server", "服务端"],
  ["session", "会话"],
  ["sessions", "会话"],
  ["service", "服务"],
  ["set", "设置"],
  ["share", "分享"],
  ["shell", "Shell"],
  ["show", "显示"],
  ["skill", "技能"],
  ["skills", "技能"],
  ["small", "轻量"],
  ["source", "来源"],
  ["state", "状态"],
  ["status", "状态"],
  ["stream", "流"],
  ["structured", "结构化"],
  ["subtask", "子任务"],
  ["submatches", "子匹配"],
  ["submit", "提交"],
  ["summary", "摘要"],
  ["synthetic", "合成"],
  ["summarize", "总结"],
  ["symbol", "符号"],
  ["symbols", "符号"],
  ["task", "任务"],
  ["telemetry", "遥测"],
  ["temperature", "温度"],
  ["text", "文本"],
  ["theme", "主题"],
  ["themes", "主题"],
  ["time", "时间"],
  ["todo", "待办"],
  ["todos", "待办"],
  ["toast", "提示"],
  ["token", "令牌"],
  ["tokens", "令牌"],
  ["tool", "工具"],
  ["tools", "工具"],
  ["top", "Top"],
  ["tui", "TUI"],
  ["type", "类型"],
  ["unknown", "未知"],
  ["unrevert", "恢复撤回"],
  ["unshare", "取消分享"],
  ["update", "更新"],
  ["updated", "已更新"],
  ["uri", "URI"],
  ["url", "地址"],
  ["urls", "地址"],
  ["user", "用户"],
  ["username", "用户名"],
  ["value", "值"],
  ["variant", "变体"],
  ["variants", "变体"],
  ["vcs", "版本控制"],
  ["video", "视频"],
  ["version", "版本"],
  ["watcher", "监听器"],
  ["web", "Web"],
  ["workspace", "工作区"],
  ["whitelist", "白名单"],
  ["worktree", "工作树"],
  ["write", "写入"],
])
const zhFieldSummary = new Map([
  ["access", "访问令牌。"],
  ["accountId", "账户 ID。"],
  ["agent", "代理名称或代理配置。"],
  ["apiKey", "API 密钥。"],
  ["args", "参数列表。"],
  ["autoshare", "是否自动分享。"],
  ["autoupdate", "自动更新配置。"],
  ["additions", "新增行数。"],
  ["after", "变更后内容。"],
  ["archived", "归档时间。"],
  ["arguments", "参数内容。"],
  ["attempt", "尝试次数。"],
  ["baseUrl", "服务端基础地址。"],
  ["baseURL", "服务端基础地址。"],
  ["before", "变更前内容。"],
  ["body", "请求体内容。"],
  ["callID", "调用 ID。"],
  ["cacheRead", "缓存读取量。"],
  ["cacheWrite", "缓存写入量。"],
  ["cache_read", "缓存读取量。"],
  ["cache_write", "缓存写入量。"],
  ["character", "字符位置。"],
  ["chunkTimeout", "分块超时时间。"],
  ["clientId", "客户端 ID。"],
  ["clientName", "客户端名称。"],
  ["clientSecret", "客户端密钥。"],
  ["code", "授权码或标识代码。"],
  ["color", "颜色标识。"],
  ["command", "命令内容。"],
  ["compacted", "压缩完成时间。"],
  ["config", "配置内容。"],
  ["contextOver200k", "超长上下文成本。"],
  ["context_over_200k", "超长上下文成本。"],
  ["content", "正文内容。"],
  ["cwd", "当前工作目录。"],
  ["data", "数据内容。"],
  ["default_agent", "默认代理名称。"],
  ["disabled_providers", "已禁用的提供商列表。"],
  ["description", "描述信息。"],
  ["directory", "可选的工作目录，会作为查询参数传给服务端。"],
  ["disable", "是否禁用。"],
  ["disable_paste_summary", "是否禁用粘贴摘要。"],
  ["diffs", "差异列表。"],
  ["dirs", "参与检索的目录列表。"],
  ["doom_loop", "是否允许死循环。"],
  ["duration", "持续时间。"],
  ["enabled", "是否启用。"],
  ["enabled_providers", "已启用的提供商列表。"],
  ["end", "结束位置。"],
  ["encoding", "内容编码。"],
  ["error", "错误信息。"],
  ["event", "事件名称。"],
  ["exitCode", "退出码。"],
  ["extra", "附加信息映射。"],
  ["expires", "过期时间。"],
  ["explore", "探索模式配置。"],
  ["extensions", "扩展名列表。"],
  ["external_directory", "外部目录权限。"],
  ["file", "文件信息。"],
  ["filename", "文件名。"],
  ["finish", "结束原因。"],
  ["format", "输出格式配置。"],
  ["formatter", "格式化器配置。"],
  ["grep", "Grep 权限配置。"],
  ["headers", "自定义请求头集合。"],
  ["header", "标题。"],
  ["healthy", "服务端是否健康。"],
  ["hidden", "是否隐藏。"],
  ["hints", "提示列表。"],
  ["home", "主目录路径。"],
  ["hostname", "主机名。"],
  ["httpClient", "底层 HTTP 客户端。"],
  ["id", "唯一标识。"],
  ["info", "元信息。"],
  ["initialized", "初始化时间。"],
  ["initialization", "初始化参数映射。"],
  ["index", "索引。"],
  ["instructions", "操作说明。"],
  ["isRetryable", "是否可重试。"],
  ["icon", "图标配置。"],
  ["kind", "类型值。"],
  ["key", "密钥。"],
  ["label", "显示标签。"],
  ["layout", "布局配置。"],
  ["level", "日志级别。"],
  ["limit", "返回结果数量上限。"],
  ["lineNumber", "行号。"],
  ["line_number", "行号。"],
  ["location", "位置信息。"],
  ["logLevel", "日志级别。"],
  ["lsp", "LSP 配置。"],
  ["maxSteps", "最大步骤数。"],
  ["message", "消息内容。"],
  ["messageID", "目标消息 ID。"],
  ["metadata", "元数据映射。"],
  ["mcp", "MCP 配置。"],
  ["mcpName", "MCP 服务名称。"],
  ["mcpTimeout", "MCP 请求超时时间。"],
  ["mcp_timeout", "MCP 请求超时时间。"],
  ["mdnsDomain", "mDNS 域名。"],
  ["mime", "MIME 类型。"],
  ["mimeType", "MIME 类型。"],
  ["mode", "运行模式。"],
  ["name", "名称。"],
  ["native", "是否使用原生能力。"],
  ["noReply", "是否不等待助手回复。"],
  ["npm", "npm 包名。"],
  ["objectMapper", "用于序列化和反序列化的 Jackson 对象映射器。"],
  ["originalKeys", "原始键列表。"],
  ["__originalKeys", "原始键列表。"],
  ["options", "扩展选项映射。"],
  ["override", "覆盖配置。"],
  ["parentID", "父级消息 ID。"],
  ["parts", "片段列表。"],
  ["parameters", "参数结构定义。"],
  ["path", "目标文件或目录路径。"],
  ["pattern", "匹配模式。"],
  ["permission", "权限配置。"],
  ["permissionID", "待响应的权限请求 ID。"],
  ["pid", "进程 ID。"],
  ["plugin", "插件列表。"],
  ["priority", "优先级。"],
  ["projectID", "项目 ID。"],
  ["properties", "附加属性。"],
  ["provider", "提供商标识。"],
  ["providerID", "目标提供商 ID。"],
  ["query", "检索关键字。"],
  ["range", "范围信息。"],
  ["raw", "原始状态值。"],
  ["reasoning", "推理信息。"],
  ["reason", "原因说明。"],
  ["read", "读取信息。"],
  ["refresh", "刷新令牌。"],
  ["requestID", "请求 ID。"],
  ["responseBody", "服务端返回的原始响应体。"],
  ["responseHeaders", "服务端返回的响应头。"],
  ["retryCount", "重试次数。"],
  ["retry", "建议的重试间隔，单位为毫秒。"],
  ["roots", "是否仅返回根会话。"],
  ["root", "根目录路径。"],
  ["role", "消息角色。"],
  ["cors", "跨域来源列表。"],
  ["scope", "授权范围。"],
  ["search", "搜索关键字。"],
  ["serverID", "服务端 ID。"],
  ["service", "服务名称。"],
  ["sessionID", "目标会话 ID。"],
  ["slug", "短标识。"],
  ["skills", "技能配置。"],
  ["small_model", "轻量模型 ID 或名称。"],
  ["snapshot", "是否启用快照。"],
  ["start", "分页起始位置或游标。"],
  ["status", "当前状态。"],
  ["steps", "步骤数上限。"],
  ["structured", "结构化输出内容。"],
  ["summary", "摘要内容。"],
  ["system", "系统提示词。"],
  ["temperature", "采样温度。"],
  ["template", "模板内容。"],
  ["text", "文本内容。"],
  ["todoread", "待办读取权限配置。"],
  ["todowrite", "待办写入权限配置。"],
  ["timeout", "请求超时时间。"],
  ["title", "标题。"],
  ["todos", "待办列表。"],
  ["topP", "Top P 采样参数。"],
  ["top_p", "Top P 采样参数。"],
  ["total", "总量。"],
  ["tools", "工具开关配置。"],
  ["oldStart", "旧起始位置。"],
  ["oldLines", "旧行数。"],
  ["newStart", "新起始位置。"],
  ["newLines", "新行数。"],
  ["absolute_offset", "绝对偏移量。"],
  ["uri", "URI 地址。"],
  ["type", "类型标识。"],
  ["url", "可访问的地址。"],
  ["username", "用户名。"],
  ["value", "实际值。"],
  ["variant", "变体名称。"],
  ["variants", "变体映射。"],
  ["version", "版本号。"],
  ["webfetch", "WebFetch 权限配置。"],
  ["websearch", "WebSearch 权限配置。"],
  ["codesearch", "CodeSearch 权限配置。"],
  ["write", "写入信息。"],
  ["workspaceID", "工作区 ID。"],
  ["bash", "Bash 权限配置。"],
])
const zhBooleanFieldLabel = new Map([
  ["attachment", "支持附件"],
  ["audio", "支持音频"],
  ["auto", "自动执行"],
  ["autoshare", "自动分享"],
  ["batch_tool", "启用批量工具"],
  ["continue_loop_on_deny", "在拒绝后继续循环"],
  ["disable", "禁用"],
  ["disable_paste_summary", "禁用粘贴摘要"],
  ["doom_loop", "允许死循环"],
  ["enabled", "启用"],
  ["hidden", "隐藏"],
  ["ignored", "忽略"],
  ["image", "支持图像"],
  ["multiple", "允许多选"],
  ["native", "使用原生能力"],
  ["custom", "允许自定义输入"],
  ["mdns", "启用 mDNS"],
  ["openTelemetry", "启用 OpenTelemetry"],
  ["reasoning", "支持推理"],
  ["snapshot", "启用快照"],
  ["setCacheKey", "设置缓存键"],
  ["structured", "返回结构化内容"],
  ["success", "执行成功"],
  ["summary", "为摘要内容"],
  ["tool_call", "支持工具调用"],
  ["toolCall", "支持工具调用"],
  ["toolcall", "支持工具调用"],
  ["video", "支持视频"],
  ["pdf", "支持 PDF"],
  ["prune", "执行裁剪"],
])
for (const item of documentedOperations) {
  if (!zhOperationSummary.has(item)) {
    throw new Error(`Missing Chinese summary for documented operation: ${item}`)
  }
}
const undocumentedQueryParams = new Set(["workspace", "cursor", "archived", "before"])
const javaKeywords = new Set([
  "abstract",
  "assert",
  "boolean",
  "break",
  "byte",
  "case",
  "catch",
  "char",
  "class",
  "const",
  "continue",
  "default",
  "do",
  "double",
  "else",
  "enum",
  "extends",
  "final",
  "finally",
  "float",
  "for",
  "goto",
  "if",
  "implements",
  "import",
  "instanceof",
  "int",
  "interface",
  "long",
  "native",
  "new",
  "package",
  "private",
  "protected",
  "public",
  "return",
  "short",
  "static",
  "strictfp",
  "super",
  "switch",
  "synchronized",
  "this",
  "throw",
  "throws",
  "transient",
  "try",
  "void",
  "volatile",
  "while",
  "record",
  "sealed",
  "permits",
  "var",
  "yield",
])

function cloneJson(value) {
  return JSON.parse(JSON.stringify(value))
}

function sanitizeSpec(input) {
  const spec = cloneJson(input)
  spec.paths = Object.fromEntries(
    Object.entries(spec.paths).flatMap(([route, methods]) => {
      const kept = Object.fromEntries(
        Object.entries(methods)
          .filter(([method]) => documentedOperations.has(`${method.toUpperCase()} ${route}`))
          .map(([method, operation]) => {
            const next = cloneJson(operation)
            next.parameters = (next.parameters ?? []).filter(
              (parameter) => !(parameter.in === "query" && undocumentedQueryParams.has(parameter.name)),
            )
            return [method, next]
          }),
      )
      if (Object.keys(kept).length === 0) return []
      return [[route, kept]]
    }),
  )

  // The stable server returns a user message for noReply=true, so the prompt
  // response must allow both user and assistant payloads.
  const promptResponse =
    spec.paths["/session/{sessionID}/message"]?.post?.responses?.["200"]?.content?.[
      "application/json"
    ]?.schema
  if (promptResponse?.properties?.info) {
    promptResponse.properties.info = {
      $ref: "#/components/schemas/Message",
    }
  }

  return spec
}

const spec = sanitizeSpec(rawSpec)

function words(value) {
  return value
    .replace(/([A-Z]+)([A-Z][a-z])/g, "$1 $2")
    .replace(/([a-z0-9])([A-Z])/g, "$1 $2")
    .replace(/[^A-Za-z0-9]+/g, " ")
    .trim()
    .split(/\s+/)
    .filter(Boolean)
}

function pascal(value) {
  const out = words(value)
    .map((part) => {
      if (part === part.toUpperCase()) return part
      return `${part.slice(0, 1).toUpperCase()}${part.slice(1)}`
    })
    .join("")
  return out || "Value"
}

function camel(value) {
  const out = pascal(value)
  if (!out) return "value"
  const name = `${out.slice(0, 1).toLowerCase()}${out.slice(1)}`
  return javaKeywords.has(name) ? `${name}Value` : name
}

function sanitizeTypeName(value) {
  const out = pascal(value)
  const safe = /^[0-9]/.test(out) ? `V${out}` : out
  return javaKeywords.has(safe) ? `${safe}Value` : safe
}

function uniqueName(base) {
  let name = sanitizeTypeName(base)
  if (!namesInUse.has(name)) {
    namesInUse.add(name)
    return name
  }

  let count = 2
  while (namesInUse.has(`${name}${count}`)) count += 1
  const out = `${name}${count}`
  namesInUse.add(out)
  return out
}

function escape(value) {
  return value.replace(/\\/g, "\\\\").replace(/"/g, '\\"')
}

function refName(ref) {
  return ref.split("/").at(-1)
}

function deref(schema) {
  if (!schema?.$ref) return schema
  return spec.components.schemas[refName(schema.$ref)]
}

function constValue(schema, key) {
  const prop = deref(schema)?.properties?.[key]
  if (!prop) return undefined
  if (prop.const !== undefined) return prop.const
  if (Array.isArray(prop.enum) && prop.enum.length === 1) return prop.enum[0]
  return undefined
}

function objectLike(schema) {
  const value = deref(schema)
  return Boolean(value && (value.type === "object" || value.properties))
}

function scalarType(schema, suggestedName, trail) {
  const value = deref(schema)
  if (!value) return "JsonNode"
  if (value.const !== undefined) return primitiveType(typeof value.const)
  if (value.type === "string") return "String"
  if (value.type === "boolean") return "Boolean"
  if (value.type === "integer") return "Long"
  if (value.type === "number") return "Double"
  if (value.type === "array") return `List<${resolveType(value.items ?? {}, `${suggestedName}Item`, `${trail}/items`)}>`
  if (value.type === "object" || value.properties || value.additionalProperties !== undefined) {
    if (value.properties) return ensureInlineType(suggestedName, value, trail)
    if (value.additionalProperties !== undefined) {
      return `Map<String, ${resolveType(value.additionalProperties === true ? {} : value.additionalProperties, `${suggestedName}Value`, `${trail}/additionalProperties`)}>`
    }
    return "JsonNode"
  }
  if (value.anyOf || value.oneOf) {
    const options = value.anyOf ?? value.oneOf
    const types = new Set(options.map((item, index) => scalarType(item, `${suggestedName}${index + 1}`, `${trail}/${index}`)))
    return types.size === 1 ? [...types][0] : "JsonNode"
  }
  return "JsonNode"
}

function primitiveType(kind) {
  if (kind === "string") return "String"
  if (kind === "boolean") return "Boolean"
  if (kind === "number") return "Double"
  return "JsonNode"
}

function inlineKey(trail, name) {
  return `${trail}:${name}`
}

function ensureInlineType(name, schema, trail) {
  const key = inlineKey(trail, name)
  if (inlineNames.has(key)) return inlineNames.get(key)
  const typeName = ensureType(name, schema)
  inlineNames.set(key, typeName)
  return typeName
}

function enumValues(schema) {
  if (schema.const !== undefined) return [schema.const]
  return schema.enum ?? []
}

function canBeUnion(schema) {
  const variants = schema.anyOf ?? schema.oneOf
  if (!variants || variants.length === 0) return false
  return variants.every((variant) => objectLike(variant))
}

function unionDiscriminator(schema) {
  const variants = (schema.anyOf ?? schema.oneOf).map(deref)
  const keys = variants.map((variant) => {
    const props = variant?.properties ?? {}
    return Object.keys(props).filter((key) => constValue(variant, key) !== undefined)
  })
  const common = keys.reduce((all, current) => all.filter((item) => current.includes(item)))
  for (const preferred of preferredDiscriminators) {
    if (common.includes(preferred)) {
      const values = variants.map((variant) => constValue(variant, preferred))
      if (new Set(values).size === variants.length) return preferred
    }
  }
  for (const candidate of common) {
    const values = variants.map((variant) => constValue(variant, candidate))
    if (new Set(values).size === variants.length) return candidate
  }
}

function isMapLike(schema) {
  const value = deref(schema)
  return Boolean(value && value.type === "object" && !value.properties && value.additionalProperties !== undefined)
}

function ensureType(name, schema) {
  const typeName = componentTypes.get(name) ?? uniqueName(name)
  componentTypes.set(name, typeName)
  if (defs.has(typeName)) return typeName

  const value = deref(schema)

  if (value?.enum || value?.const !== undefined) {
    defs.set(typeName, {
      kind: "enum",
      name: typeName,
      values: enumValues(value).map((item) => String(item)),
    })
    return typeName
  }

  if (value?.anyOf || value?.oneOf) {
    if (canBeUnion(value)) {
      const discriminator = unionDiscriminator(value)
      if (discriminator) {
        const variants = (value.anyOf ?? value.oneOf).map((variant, index) => {
          const expanded = deref(variant)
          const label = String(constValue(expanded, discriminator))
          const variantName = variant.$ref
            ? ensureType(refName(variant.$ref), expanded)
            : ensureInlineType(`${typeName}${pascal(label)}`, expanded, `union/${typeName}/${index}`)
          const list = variantInterfaces.get(variantName) ?? []
          if (!list.includes(typeName)) list.push(typeName)
          variantInterfaces.set(variantName, list)
          return {
            label,
            name: variantName,
          }
        })
        defs.set(typeName, {
          kind: "union",
          name: typeName,
          discriminator,
          variants,
        })
        return typeName
      }
    }

    const scalar = scalarType(value, typeName, `scalar/${typeName}`)
    if (scalar !== "JsonNode") {
      defs.set(typeName, {
        kind: "wrapper",
        name: typeName,
        valueType: scalar,
      })
      return typeName
    }

    defs.set(typeName, {
      kind: "wrapper",
      name: typeName,
      valueType: "JsonNode",
    })
    return typeName
  }

  if (isMapLike(value)) {
    defs.set(typeName, {
      kind: "map",
      name: typeName,
      valueType: resolveType(value.additionalProperties === true ? {} : value.additionalProperties, `${typeName}Value`, `map/${typeName}`),
    })
    return typeName
  }

  if (value?.type === "object" || value?.properties) {
    defs.set(typeName, {
      kind: "record",
      name: typeName,
      schema: value,
      fields: [],
    })
    defs.get(typeName).fields = fieldsFor(typeName, value, `record/${typeName}`)
    return typeName
  }

  defs.set(typeName, {
    kind: "wrapper",
    name: typeName,
    valueType: resolveType(value, `${typeName}Value`, `wrapper/${typeName}`),
  })
  return typeName
}

function fieldsFor(parentName, schema, trail) {
  const required = new Set(schema.required ?? [])
  return Object.entries(schema.properties ?? {}).map(([jsonName, value]) => ({
    jsonName,
    name: camel(jsonName.replace(/^_+/, "")),
    type: resolveType(value, `${parentName}${pascal(jsonName)}`, `${trail}/${jsonName}`),
    required: required.has(jsonName),
  }))
}

function resolveType(schema, suggestedName, trail) {
  if (!schema) return "JsonNode"
  if (schema.$ref) return ensureType(refName(schema.$ref), deref(schema))

  if (schema.enum || schema.const !== undefined) {
    if (suggestedName.startsWith("Inline")) {
      return "String"
    }
    if (schema.const !== undefined) return primitiveType(typeof schema.const)
    return schema.type === "string" ? "String" : "JsonNode"
  }

  if (schema.anyOf || schema.oneOf) {
    if (canBeUnion(schema)) {
      return ensureInlineType(suggestedName, schema, trail)
    }
    return scalarType(schema, suggestedName, trail)
  }

  if (schema.type === "array") {
    return `List<${resolveType(schema.items ?? {}, `${suggestedName}Item`, `${trail}/items`)}>`
  }

  if (schema.type === "object" || schema.properties) {
    if (schema.properties) return ensureInlineType(suggestedName, schema, trail)
    if (schema.additionalProperties !== undefined) {
      return `Map<String, ${resolveType(schema.additionalProperties === true ? {} : schema.additionalProperties, `${suggestedName}Value`, `${trail}/additionalProperties`)}>`
    }
    return "JsonNode"
  }

  if (schema.additionalProperties !== undefined) {
    return `Map<String, ${resolveType(schema.additionalProperties === true ? {} : schema.additionalProperties, `${suggestedName}Value`, `${trail}/additionalProperties`)}>`
  }

  if (schema.type === "string") return "String"
  if (schema.type === "boolean") return "Boolean"
  if (schema.type === "integer") return "Long"
  if (schema.type === "number") return "Double"
  return "JsonNode"
}

function responseSchema(operation) {
  const entries = Object.entries(operation.responses ?? {})
  const success = entries.find(([status]) => status.startsWith("2"))
  if (!success) return
  const content = success[1].content ?? {}
  if (content["application/json"]) return { schema: content["application/json"].schema, sse: false }
  if (content["text/event-stream"]) return { schema: content["text/event-stream"].schema, sse: true }
}

function requestBodySchema(operation) {
  return operation.requestBody?.content?.["application/json"]?.schema
}

function simpleTypeReference(type) {
  return !type.includes("<")
}

const javaLangTypes = new Set([
  "Boolean",
  "Class",
  "Double",
  "Integer",
  "Long",
  "Object",
  "Override",
  "RuntimeException",
  "String",
  "Thread",
  "Throwable",
  "Void",
])
const namedImports = new Map([
  ["ArrayList", "java.util.ArrayList"],
  ["BufferedReader", "java.io.BufferedReader"],
  ["DeserializationFeature", "com.fasterxml.jackson.databind.DeserializationFeature"],
  ["Duration", "java.time.Duration"],
  ["HttpClient", "java.net.http.HttpClient"],
  ["HttpHeaders", "java.net.http.HttpHeaders"],
  ["HttpRequest", "java.net.http.HttpRequest"],
  ["HttpResponse", "java.net.http.HttpResponse"],
  ["IOException", "java.io.IOException"],
  ["InputStreamReader", "java.io.InputStreamReader"],
  ["InputStream", "java.io.InputStream"],
  ["Iterator", "java.util.Iterator"],
  ["JavaType", "com.fasterxml.jackson.databind.JavaType"],
  ["JsonCreator", "com.fasterxml.jackson.annotation.JsonCreator"],
  ["JsonIgnoreProperties", "com.fasterxml.jackson.annotation.JsonIgnoreProperties"],
  ["JsonInclude", "com.fasterxml.jackson.annotation.JsonInclude"],
  ["JsonNode", "com.fasterxml.jackson.databind.JsonNode"],
  ["JsonProperty", "com.fasterxml.jackson.annotation.JsonProperty"],
  ["JsonSubTypes", "com.fasterxml.jackson.annotation.JsonSubTypes"],
  ["JsonTypeInfo", "com.fasterxml.jackson.annotation.JsonTypeInfo"],
  ["JsonValue", "com.fasterxml.jackson.annotation.JsonValue"],
  ["LinkedHashMap", "java.util.LinkedHashMap"],
  ["List", "java.util.List"],
  ["Map", "java.util.Map"],
  ["NoSuchElementException", "java.util.NoSuchElementException"],
  ["ObjectMapper", "com.fasterxml.jackson.databind.ObjectMapper"],
  ["Objects", "java.util.Objects"],
  ["StandardCharsets", "java.nio.charset.StandardCharsets"],
  ["TypeReference", "com.fasterxml.jackson.core.type.TypeReference"],
  ["URI", "java.net.URI"],
  ["URLEncoder", "java.net.URLEncoder"],
])

function knownImport(name) {
  if (javaLangTypes.has(name)) return null
  if (namedImports.has(name)) return namedImports.get(name)
  if (defs.has(name)) return `${modelPackage}.${name}`
  if (operationTypes.has(name)) return `${requestPackage}.${name}`
  if (name.endsWith("Api")) return `${apiPackage}.${name}`
  if (["ApiException", "ApiTransport", "OpencodeClientConfig", "SseEvent", "SseEventStream"].includes(name)) {
    return `${corePackage}.${name}`
  }
  return null
}

function importsForTypes(values, currentPackage) {
  const imports = new Set()
  for (const value of values.filter(Boolean)) {
    for (const token of value.match(/\b[A-Z][A-Za-z0-9_]*\b/g) ?? []) {
      const item = knownImport(token)
      if (!item) continue
      const itemPackage = item.slice(0, item.lastIndexOf("."))
      if (itemPackage !== currentPackage) imports.add(item)
    }
  }
  return imports
}

function mergeImports(...groups) {
  const imports = new Set()
  for (const group of groups) {
    for (const item of group ?? []) imports.add(item)
  }
  return imports
}

function renderImports(currentPackage, imports) {
  const lines = [...imports]
    .filter(Boolean)
    .filter((item) => item.slice(0, item.lastIndexOf(".")) !== currentPackage)
    .sort()
    .map((item) => `import ${item};`)
  return lines.length === 0 ? "" : `${lines.join("\n")}\n\n`
}

function docBlock(lines, indent = "  ") {
  const content = lines.filter((line) => line !== undefined && line !== null)
  if (content.length === 0) return ""
  if (content.length === 1 && content[0] !== "" && !content[0].startsWith("@")) {
    return `${indent}/** ${content[0]} */\n`
  }
  return `${indent}/**\n${content.map((line) => (line === "" ? `${indent} *` : `${indent} * ${line}`)).join("\n")}\n${indent} */\n`
}

function sentence(value) {
  const text = String(value ?? "")
    .replace(/\s+/g, " ")
    .trim()
    .replace(/[。！？!?]+$/u, "")
  return text ? `${text}。` : ""
}

function leadingSpaceIfAscii(value) {
  return /^[A-Za-z]/.test(String(value ?? "")) ? " " : ""
}

function translatedLabel(value) {
  if (String(value ?? "") === "OAuth") return "OAuth"
  const text = String(value ?? "").replace(/\d+/g, " ")
  const items = words(text).map((item) => {
    const translated = zhTokenSummary.get(item.toLowerCase())
    if (translated) return translated
    return item === item.toUpperCase() ? item : item
  })
  let out = ""
  for (const item of items) {
    if (
      out &&
      /^[A-Za-z0-9]+$/.test(out.slice(-1)) &&
      /^[A-Za-z0-9]+$/.test(item)
    ) {
      out += ` ${item}`
    } else {
      out += item
    }
  }
  return out || String(value ?? "")
}

function stripSuffix(value, suffix) {
  return value.endsWith(suffix) ? value.slice(0, -suffix.length) : value
}

function stripPrefix(value, prefix) {
  return value.startsWith(prefix) ? value.slice(prefix.length) : value
}

function innerType(type) {
  const match = String(type).match(/^List<(.+)>$/)
  return match ? match[1] : type
}

function typeDocLabel(type) {
  return typeReferenceSummary(String(type).replace(/\? extends /g, "").trim())
}

function propertyDescription(field, ownerName) {
  const key = field.jsonName ?? field.name
  if (key === "body" && operationTypes.has(ownerName)) {
    return `${operationSummary(operationTypes.get(ownerName).operation)}的请求体。`
  }
  if (key === "agent") {
    return field.type === "String" ? "代理名称。" : "代理配置。"
  }
  if (key === "model") {
    return field.type === "String" ? "模型 ID 或名称。" : "模型配置。"
  }
  if (key === "provider") {
    return field.type === "String" ? "提供商 ID 或名称。" : "提供商配置。"
  }
  if (key === "options") {
    if (String(field.type).startsWith("List<")) return "选项列表。"
    if (String(field.type).startsWith("Map<")) return "扩展选项映射。"
  }
  if (key === "files") {
    if (field.type === "Long" || field.type === "Double") return "文件数量。"
    if (String(field.type).startsWith("List<")) return "文件列表。"
  }
  if (key === "summary" && field.type !== "Boolean") {
    return field.type.endsWith("Config") ? "摘要相关配置。" : "摘要内容。"
  }
  if (field.type === "Boolean" && zhBooleanFieldLabel.has(key)) {
    return `是否${zhBooleanFieldLabel.get(key)}。`
  }
  if (zhFieldSummary.has(key)) return zhFieldSummary.get(key)
  if (key.endsWith("IDs")) return `${translatedLabel(key.slice(0, -3))} ID 列表。`
  if (key.endsWith("ID")) return `${translatedLabel(key.slice(0, -2))} ID。`
  if (field.type === "Boolean") return `${translatedLabel(key)}标记。`
  if (String(field.type).startsWith("List<")) {
    return `${translatedLabel(key)}列表。`
  }
  if (String(field.type).startsWith("Map<")) {
    return `${translatedLabel(key)}映射。`
  }
  return `${translatedLabel(key)}。`
}

function typeLabel(name, kind) {
  if (name === "JSONSchema" && kind === "map") return "JSON Schema 映射"
  if (name === "JSONSchema") return "JSON Schema"
  if (name === "OAuth") return "OAuth"
  if (name === "EventSessionErrorPropertiesError") return "会话错误事件中的错误"
  if (name.endsWith("ContextOver200k")) {
    return `${translatedLabel(stripSuffix(name, "ContextOver200k"))}超长上下文`
  }
  if (operationTypes.has(name)) {
    return `${operationSummary(operationTypes.get(name).operation)}接口请求参数`
  }
  if (kind === "wrapper") return `${translatedLabel(stripSuffix(name, "Value"))}值对象`
  if (kind === "map") return `${translatedLabel(name)}映射`
  if (name.endsWith("Response")) return `${translatedLabel(stripSuffix(name, "Response"))}响应`
  if (name.endsWith("Body")) return `${translatedLabel(stripSuffix(name, "Body"))}请求体`
  if (name.endsWith("ErrorData")) return `${translatedLabel(stripSuffix(name, "ErrorData"))}错误详情`
  if (name.startsWith("Event") && !name.includes("Properties") && name.endsWith("Error")) {
    return `${translatedLabel(stripPrefix(stripSuffix(name, "Error"), "Event"))}错误事件`
  }
  if (name.endsWith("Error")) return `${translatedLabel(stripSuffix(name, "Error"))}错误`
  if (name.startsWith("Event") && name.endsWith("Properties")) {
    return `${translatedLabel(stripSuffix(stripPrefix(name, "Event"), "Properties"))}事件属性`
  }
  if (name.startsWith("Event") && !name.includes("Properties") && name.endsWith("Status")) {
    return `${translatedLabel(stripPrefix(stripSuffix(name, "Status"), "Event"))}状态事件`
  }
  if (name.endsWith("Properties")) return `${translatedLabel(stripSuffix(name, "Properties"))}属性`
  if (name.endsWith("Config")) return `${translatedLabel(stripSuffix(name, "Config"))}配置`
  if (name.endsWith("Status")) return `${translatedLabel(stripSuffix(name, "Status"))}状态`
  if (name.startsWith("Event")) return `${translatedLabel(stripPrefix(name, "Event"))}事件`
  return translatedLabel(name)
}

function typeSummary(name, kind) {
  const label = typeLabel(name, kind)
  if (operationTypes.has(name)) return label
  if (kind === "enum") return `${label}枚举`
  if (kind === "union") return `${label}联合类型`
  if (kind === "map") return `${label}`
  if (kind === "wrapper") return label
  if (name.endsWith("ErrorData")) return label
  if (name.startsWith("Event") && !name.includes("Properties") && name.endsWith("Error")) {
    return `${label}数据`
  }
  if (name.endsWith("Error")) return `${label}信息`
  if (name.endsWith("Properties")) return label
  if (name.endsWith("Config")) return label
  if (name.endsWith("Status")) return label
  if (name.startsWith("Event")) return `${label}数据`
  if (name.endsWith("Body")) return label
  if (name.endsWith("Response")) return `${label}数据`
  return `${label}数据模型`
}

function typeReferenceSummary(type) {
  const value = String(type)
  if (value.startsWith("List<") && value.endsWith(">")) {
    return `${typeReferenceSummary(innerType(value))}列表`
  }
  if (value.startsWith("Map<String, ") && value.endsWith(">")) {
    return `${typeReferenceSummary(value.slice("Map<String, ".length, -1))}映射`
  }
  if (value === "String") return "字符串"
  if (value === "Boolean") return "布尔值"
  if (value === "JsonNode") return "JSON 节点"
  if (defs.has(value)) return typeLabel(value, defs.get(value).kind)
  return translatedLabel(value)
}

function recordDoc(name, fields, kind = "record") {
  return docBlock(
    fields.length === 0
      ? [sentence(typeSummary(name, kind))]
      : [
          sentence(typeSummary(name, kind)),
          "",
          ...fields.map((field) => `@param ${field.name} ${propertyDescription(field, name)}`),
        ],
    "",
  )
}

function enumDoc(name) {
  return docBlock([sentence(typeSummary(name, "enum"))], "")
}

function wrapperDoc(name) {
  return docBlock([
    sentence(typeSummary(name, "wrapper")),
    "",
    "@param value 实际值。",
  ], "")
}

function mapDoc(name, valueType) {
  return docBlock([
    sentence(typeSummary(name, "map")),
    `映射值类型为 ${typeDocLabel(valueType)}。`,
  ], "")
}

function unionDoc(def) {
  return docBlock([
    sentence(typeSummary(def.name, "union")),
    `实际实现类型由 ${def.discriminator} 字段判别。`,
  ], "")
}

function accessorGetterDoc(label) {
  const prefix = /^[A-Za-z]/.test(label) ? " " : ""
  return docBlock([
    sentence(`获取${prefix}${label}`),
    "",
    `@return ${label}实例。`,
  ])
}

function operationRequestDoc(operation) {
  if (operation.requestFields.length === 0) return ""
  const required = operation.requestFields.filter((field) => field.required).map((field) => field.name)
  const suffix =
    required.length === 0 ? "。" : `，其中 ${required.join("、")} 为必填项。`
  return `@param request ${operationSummary(operation)}所需的请求参数${suffix}`
}

function operationReturnDoc(operation) {
  const summary = operationSummary(operation)
  if (operation.sse) return "@return 服务端持续推送的事件流。"
  if (operation.responseType === "Void") return "@return 无返回值。"
  if (operation.responseType === "Boolean") return "@return 操作是否成功。"
  if (summary.startsWith("获取")) return `@return ${summary.slice(2).trim()}。`
  if (summary.startsWith("读取")) return `@return ${summary.slice(2).trim()}。`
  if (summary.startsWith("列出")) return `@return ${summary.slice(2).trim()}列表。`
  if (summary === "执行文本检索") return "@return 匹配的文本片段列表。"
  if (summary === "检索文件") return "@return 匹配的文件路径列表。"
  if (summary === "检索符号") return "@return 匹配的符号列表。"
  if (summary.startsWith("执行")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("发送")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("异步发送")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("发起")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("处理")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("创建")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("更新")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  if (summary.startsWith("添加")) return `@return ${typeReferenceSummary(operation.responseType)}。`
  return `@return ${typeReferenceSummary(operation.responseType)}。`
}

function operationSummary(operation) {
  return zhOperationSummary.get(`${operation.method} ${operation.route}`)
}

function accessorSummary(parts) {
  return zhApiAccessorSummary.get(parts.join("."))
}

const operations = []
for (const [route, methods] of Object.entries(spec.paths)) {
  for (const [method, operation] of Object.entries(methods)) {
    if (!["get", "put", "post", "delete", "patch"].includes(method)) continue
    const parts = operation.operationId.split(".")
    const baseName = parts.map(pascal).join("")
    const requestName = `${baseName}Request`
    const pathParams = []
    const queryParams = []
    const headerParams = []

    for (const parameter of operation.parameters ?? []) {
      const item = {
        jsonName: parameter.name,
        name: camel(parameter.name),
        type: resolveType(parameter.schema ?? {}, `${baseName}${pascal(parameter.name)}`, `parameter/${baseName}/${parameter.in}/${parameter.name}`),
        required: Boolean(parameter.required),
      }
      if (parameter.in === "path") pathParams.push(item)
      if (parameter.in === "query") queryParams.push(item)
      if (parameter.in === "header") headerParams.push(item)
    }

    const bodySchema = requestBodySchema(operation)
    const bodyType = bodySchema
      ? resolveType(bodySchema, `${baseName}Body`, `body/${baseName}`)
      : undefined
    const bodyRequired = Boolean(bodyType)

    const response = responseSchema(operation)
    const responseType = response
      ? resolveType(response.schema, `${baseName}${response.sse ? "Event" : "Response"}`, `response/${baseName}`)
      : "Void"

    const requestFields = [
      ...pathParams,
      ...queryParams,
      ...headerParams,
      ...(bodyType
        ? [
            {
              jsonName: "body",
              name: "body",
              type: bodyType,
              required: bodyRequired,
            },
          ]
        : []),
    ]

    if (requestFields.length > 0) {
      operationTypes.set(requestName, {
        name: requestName,
        fields: requestFields,
        operation: null,
      })
    }

    const operationItem = {
      id: operation.operationId,
      parts,
      method: method.toUpperCase(),
      route,
      summary: operation.summary,
      description: operation.description,
      pathParams,
      queryParams,
      headerParams,
      bodyType,
      requestName,
      requestFields,
      responseType,
      sse: Boolean(response?.sse),
    }
    operations.push(operationItem)

    if (requestFields.length > 0) {
      operationTypes.get(requestName).operation = operationItem
    }
  }
}

function packagePath(name) {
  return path.join(javaRoot, ...name.split("."))
}

async function emitJava(pkg, name, body) {
  const dir = packagePath(pkg)
  await mkdir(dir, { recursive: true })
  await writeFile(path.join(dir, `${name}.java`), `${body.trim()}\n`)
}

function recordFile(def) {
  const imports = mergeImports(
    [
      "com.fasterxml.jackson.annotation.JsonIgnoreProperties",
      "com.fasterxml.jackson.annotation.JsonInclude",
    ],
    def.fields.length > 0 ? ["com.fasterxml.jackson.annotation.JsonProperty"] : [],
    importsForTypes(def.fields.map((field) => field.type), modelPackage),
  )
  const interfaces = variantInterfaces.get(def.name) ?? []
  const impl = interfaces.length ? ` implements ${interfaces.join(", ")}` : ""
  const fields = def.fields
    .map(
      (field) =>
        `    @JsonProperty("${escape(field.jsonName)}") ${field.type} ${field.name}`,
    )
    .join(",\n")
  return `
package ${modelPackage};

${renderImports(modelPackage, imports)}${recordDoc(def.name, def.fields)}@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(
${fields}
)${impl} {
}
`
}

function mapFile(def) {
  const imports = mergeImports(
    ["com.fasterxml.jackson.annotation.JsonInclude", "java.util.LinkedHashMap"],
    importsForTypes([def.valueType], modelPackage),
  )
  return `
package ${modelPackage};

${renderImports(modelPackage, imports)}${mapDoc(def.name, def.valueType)}@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ${def.name} extends LinkedHashMap<String, ${def.valueType}> {
${docBlock([sentence("创建空映射对象")])}  public ${def.name}() {
    super();
  }
}
`
}

function wrapperFile(def) {
  const imports = mergeImports(
    [
      "com.fasterxml.jackson.annotation.JsonCreator",
      "com.fasterxml.jackson.annotation.JsonInclude",
      "com.fasterxml.jackson.annotation.JsonValue",
    ],
    importsForTypes([def.valueType], modelPackage),
  )
  return `
package ${modelPackage};

${renderImports(modelPackage, imports)}${wrapperDoc(def.name)}@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(@JsonValue ${def.valueType} value) {
${docBlock([sentence("使用实际值创建对象"), "", "@param value 实际值。"])}  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ${def.name} {
  }
}
`
}

function enumConstant(value) {
  const base = value
    .replace(/[^A-Za-z0-9]+/g, "_")
    .replace(/([a-z0-9])([A-Z])/g, "$1_$2")
    .toUpperCase()
  const out = base.replace(/^_+|_+$/g, "") || "VALUE"
  return /^[0-9]/.test(out) ? `VALUE_${out}` : out
}

function enumFile(def) {
  const imports = ["com.fasterxml.jackson.annotation.JsonCreator", "com.fasterxml.jackson.annotation.JsonValue"]
  const values = def.values
    .map((value) => `  ${enumConstant(value)}("${escape(value)}")`)
    .join(",\n")
  return `
package ${modelPackage};

${renderImports(modelPackage, imports)}${enumDoc(def.name)}public enum ${def.name} {
${values};

  private final String value;

  ${def.name}(String value) {
    this.value = value;
  }

${docBlock([sentence("获取枚举对应的原始值"), "", "@return 原始值。"])}  @JsonValue
  public String value() {
    return value;
  }

${docBlock([sentence("根据原始值解析枚举"), "", "@param value 原始值。", `@return 对应的 ${def.name} 枚举值。`])}  @JsonCreator
  public static ${def.name} fromValue(String value) {
    for (${def.name} item : values()) {
      if (item.value.equals(value)) return item;
    }
    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
`
}

function unionFile(def) {
  const imports = [
    "com.fasterxml.jackson.annotation.JsonSubTypes",
    "com.fasterxml.jackson.annotation.JsonTypeInfo",
  ]
  const permits = def.variants.map((variant) => variant.name).join(", ")
  const subTypes = def.variants
    .map((variant) => `    @JsonSubTypes.Type(value = ${variant.name}.class, name = "${escape(variant.label)}")`)
    .join(",\n")
  return `
package ${modelPackage};

${renderImports(modelPackage, imports)}${unionDoc(def)}@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "${escape(def.discriminator)}", visible = true)
@JsonSubTypes({
${subTypes}
})
public sealed interface ${def.name} permits ${permits} {
}
`
}

function requestFile(def) {
  const imports = mergeImports(
    ["com.fasterxml.jackson.annotation.JsonInclude"],
    def.fields.length > 0 ? ["com.fasterxml.jackson.annotation.JsonProperty"] : [],
    importsForTypes(def.fields.map((field) => field.type), requestPackage),
  )
  const fields = def.fields
    .map(
      (field) =>
        `    @JsonProperty("${escape(field.jsonName)}") ${field.type} ${field.name}`,
    )
    .join(",\n")
  return `
package ${requestPackage};

${renderImports(requestPackage, imports)}${recordDoc(def.name, def.fields, "request")}@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(
${fields}
) {
}
`
}

function responseRef(operation) {
  if (operation.responseType === "Void") return { kind: "class", value: "Void.class" }
  if (simpleTypeReference(operation.responseType) && !operation.responseType.startsWith("List<") && !operation.responseType.startsWith("Map<")) {
    return { kind: "class", value: `${operation.responseType}.class` }
  }
  return {
    kind: "typeRef",
    value: `new TypeReference<${operation.responseType}>() {}`,
  }
}

function requestArg(operation) {
  if (operation.requestFields.length === 0) return ""
  return `${operation.requestName} request`
}

function requireRequest(operation) {
  if (operation.requestFields.length === 0) return ""
  return `    Objects.requireNonNull(request, "request");\n`
}

function requireFields(operation) {
  const lines = operation.requestFields
    .filter((field) => field.required)
    .map((field) => `    Objects.requireNonNull(request.${field.name}(), "request.${field.name}");`)
  if (lines.length === 0) return ""
  return `${lines.join("\n")}\n`
}

function mapLines(items, source) {
  if (items.length === 0) return `    Map<String, Object> ${source} = Map.of();\n`
  const lines = [`    Map<String, Object> ${source} = new LinkedHashMap<>();`]
  for (const item of items) {
    if (item.required) {
      lines.push(`    ${source}.put("${escape(item.jsonName)}", request.${item.name}());`)
    } else {
      lines.push(`    if (request.${item.name}() != null) ${source}.put("${escape(item.jsonName)}", request.${item.name}());`)
    }
  }
  return `${lines.join("\n")}\n`
}

function headerLines(operation) {
  if (operation.headerParams.length === 0) return `    Map<String, String> headers = Map.of();\n`
  const lines = [`    Map<String, String> headers = new LinkedHashMap<>();`]
  for (const item of operation.headerParams) {
    if (item.required) {
      lines.push(`    headers.put("${escape(item.jsonName)}", String.valueOf(request.${item.name}()));`)
    } else {
      lines.push(`    if (request.${item.name}() != null) headers.put("${escape(item.jsonName)}", String.valueOf(request.${item.name}()));`)
    }
  }
  return `${lines.join("\n")}\n`
}

function bodyLine(operation) {
  if (!operation.bodyType) return `    Object body = null;\n`
  return `    Object body = request.body();\n`
}

function operationMethod(operation) {
  const name = camel(operation.parts.at(-1))
  const summary = operationSummary(operation)
  const ref = responseRef(operation)
  const request = requestArg(operation)
  const optionalOnly = operation.requestFields.length > 0 && operation.requestFields.every((field) => !field.required)
  const call = operation.sse
    ? ref.kind === "class"
      ? `    return transport.stream("${operation.method}", "${operation.route}", path, query, headers, body, ${ref.value});`
      : `    return transport.stream("${operation.method}", "${operation.route}", path, query, headers, body, ${ref.value});`
    : ref.kind === "class"
      ? `    return transport.execute("${operation.method}", "${operation.route}", path, query, headers, body, ${ref.value});`
      : `    return transport.execute("${operation.method}", "${operation.route}", path, query, headers, body, ${ref.value});`
  const returnType = operation.sse ? `SseEventStream<${operation.responseType}>` : operation.responseType
  const overload = optionalOnly
    ? `${docBlock([sentence(summary), "", operationReturnDoc(operation)])}  public ${returnType} ${name}() {\n    return ${name}(new ${operation.requestName}(${operation.requestFields.map(() => "null").join(", ")}));\n  }\n\n`
    : ""
  const requestDoc = [sentence(summary)]
  if (operation.requestFields.length > 0) {
    requestDoc.push("")
    requestDoc.push(operationRequestDoc(operation))
  }
  requestDoc.push(operationReturnDoc(operation))
  return `${overload}${docBlock(requestDoc)}  public ${returnType} ${name}(${request}) {
${requireRequest(operation)}${requireFields(operation)}${mapLines(operation.pathParams, "path")}${mapLines(operation.queryParams, "query")}${headerLines(operation)}${bodyLine(operation)}${call}
  }
`
}

function classNameFor(parts) {
  return `${parts.map(pascal).join("")}Api`
}

function buildTree(items) {
  const root = { children: new Map(), operations: [] }
  for (const operation of items) {
    let node = root
    for (const part of operation.parts.slice(0, -1)) {
      if (!node.children.has(part)) node.children.set(part, { part, children: new Map(), operations: [] })
      node = node.children.get(part)
    }
    node.operations.push(operation)
  }
  return root
}

const tree = buildTree(operations)

function apiFile(parts, node) {
  const className = classNameFor(parts)
  const children = [...node.children.entries()]
  const fields = children.map(([part]) => `  private final ${classNameFor([...parts, part])} ${camel(part)};`).join("\n")
  const init = children.map(([part]) => `    this.${camel(part)} = new ${classNameFor([...parts, part])}(transport);`).join("\n")
  const initBlock = init ? `\n${init}` : ""
  const getters = children
    .map(([part]) => `${accessorGetterDoc(accessorSummary([...parts, part]) ?? classNameFor([...parts, part]))}  public ${classNameFor([...parts, part])} ${camel(part)}() {\n    return ${camel(part)};\n  }\n`)
    .join("\n")
  const methods = node.operations.map(operationMethod).join("\n")
  const needsTypeReference = node.operations.some(
    (operation) => responseRef(operation).kind === "typeRef",
  )
  const needsObjects = node.operations.some((operation) => operation.requestFields.length > 0)
  const needsLinkedHashMap = node.operations.some(
    (operation) =>
      operation.pathParams.length > 0 ||
      operation.queryParams.length > 0 ||
      operation.headerParams.length > 0,
  )
  const imports = mergeImports(
    ["java.util.Map"],
    needsObjects ? ["java.util.Objects"] : [],
    needsLinkedHashMap ? ["java.util.LinkedHashMap"] : [],
    needsTypeReference ? ["com.fasterxml.jackson.core.type.TypeReference"] : [],
    node.operations.some((operation) => operation.sse) ? [`${corePackage}.SseEventStream`] : [],
    [`${corePackage}.ApiTransport`],
    importsForTypes(
      [
        ...node.operations
          .filter((operation) => operation.requestFields.length > 0)
          .map((operation) => operation.requestName),
        ...node.operations.map((operation) => operation.responseType),
      ],
      apiPackage,
    ),
  )
  const label = accessorSummary(parts) ?? translatedLabel(className)
  return `
package ${apiPackage};

${renderImports(apiPackage, imports)}${docBlock([sentence(`${label}的 HTTP 客户端封装`)], "")}public final class ${className} {
  private final ApiTransport transport;
${fields ? `${fields}\n` : ""}
${docBlock([sentence(`使用底层传输器创建${leadingSpaceIfAscii(label)}${label}封装`), "", "@param transport 底层传输器。"])}  public ${className}(ApiTransport transport) {
    this.transport = transport;${initBlock}
  }
${getters}${methods ? `\n${methods}` : ""}
}
`
}

async function emitApi(parts, node) {
  if (parts.length > 0) {
    await emitJava(apiPackage, classNameFor(parts), apiFile(parts, node))
  }
  for (const [part, child] of node.children.entries()) {
    await emitApi([...parts, part], child)
  }
}

function rootClientFile(children) {
  const imports = mergeImports(
    [`${corePackage}.ApiTransport`, `${corePackage}.OpencodeClientConfig`],
    children.map((part) => `${apiPackage}.${classNameFor([part])}`),
  )
  const fields = children.map((part) => `  private final ${classNameFor([part])} ${camel(part)};`).join("\n")
  const init = children.map((part) => `    this.${camel(part)} = new ${classNameFor([part])}(transport);`).join("\n")
  const getters = children
    .map((part) => `${accessorGetterDoc(accessorSummary([part]) ?? classNameFor([part]))}  public ${classNameFor([part])} ${camel(part)}() {\n    return ${camel(part)};\n  }\n`)
    .join("\n")
  return `
package ${rootPackage};

${renderImports(rootPackage, imports)}${docBlock([sentence("用于访问 OpenCode serve HTTP 接口的 Java 客户端")], "")}public final class OpencodeClient {
  private final ApiTransport transport;
${fields}

${docBlock([sentence("使用默认配置创建客户端")])}  public OpencodeClient() {
    this(OpencodeClientConfig.builder().build());
  }

${docBlock([sentence("使用指定配置创建客户端"), "", "@param config 客户端配置。"])}  public OpencodeClient(OpencodeClientConfig config) {
    this.transport = new ApiTransport(config);
${init}
  }

${getters}}
`
}

function transportFile() {
  return `
package ${corePackage};

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

${docBlock([sentence("底层 HTTP 传输器，负责请求构造、序列化、响应解析以及 SSE 事件流的打开")], "")}public class ApiTransport {
  private final OpencodeClientConfig config;
  private final HttpClient client;
  private final ObjectMapper mapper;

${docBlock([sentence("根据客户端配置创建传输器"), "", "@param config 客户端配置。"])}  public ApiTransport(OpencodeClientConfig config) {
    this.config = config;
    this.client = config.httpClient();
    this.mapper =
        config
            .objectMapper()
            .copy()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

${docBlock([
    sentence("发送普通 HTTP 请求，并按具体类型解析 JSON 响应"),
    "",
    "@param method HTTP 方法。",
    "@param route 接口路径模板。",
    "@param path 路径参数映射。",
    "@param query 查询参数映射。",
    "@param headers 额外请求头。",
    "@param body 请求体对象，为 null 时不发送请求体。",
    "@param type 目标响应类型。",
    "@return 解析后的响应对象；若接口无返回体则返回 null。",
    "@throws ApiException 当请求失败、序列化失败或响应无法解析时抛出。",
  ])}  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type
  ) {
    try {
      return parseResponse(
          send(method, route, path, query, headers, body, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)),
          type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

${docBlock([
    sentence("发送普通 HTTP 请求，并按泛型类型解析 JSON 响应"),
    "",
    "@param method HTTP 方法。",
    "@param route 接口路径模板。",
    "@param path 路径参数映射。",
    "@param query 查询参数映射。",
    "@param headers 额外请求头。",
    "@param body 请求体对象，为 null 时不发送请求体。",
    "@param type 目标响应泛型类型。",
    "@return 解析后的响应对象；若接口无返回体则返回 null。",
    "@throws ApiException 当请求失败、序列化失败或响应无法解析时抛出。",
  ])}  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type
  ) {
    try {
      return parseResponse(
          send(method, route, path, query, headers, body, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)),
          type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

${docBlock([
    sentence("打开 SSE 事件流，并按具体类型解析事件数据"),
    "",
    "@param method HTTP 方法。",
    "@param route 接口路径模板。",
    "@param path 路径参数映射。",
    "@param query 查询参数映射。",
    "@param headers 额外请求头。",
    "@param body 请求体对象，为 null 时不发送请求体。",
    "@param type 事件数据类型。",
    "@return 可迭代读取的 SSE 事件流。",
    "@throws ApiException 当事件流无法建立时抛出。",
  ])}  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type
  ) {
    return openStream(method, route, path, query, headers, body, mapper.constructType(type));
  }

${docBlock([
    sentence("打开 SSE 事件流，并按泛型类型解析事件数据"),
    "",
    "@param method HTTP 方法。",
    "@param route 接口路径模板。",
    "@param path 路径参数映射。",
    "@param query 查询参数映射。",
    "@param headers 额外请求头。",
    "@param body 请求体对象，为 null 时不发送请求体。",
    "@param type 事件数据泛型类型。",
    "@return 可迭代读取的 SSE 事件流。",
    "@throws ApiException 当事件流无法建立时抛出。",
  ])}  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type
  ) {
    return openStream(method, route, path, query, headers, body, mapper.constructType(type));
  }

  private <T> T parseResponse(HttpResponse<String> response, Class<T> type) throws IOException {
    ensureSuccess(response);
    if (type == Void.class) return null;
    return readBody(response.body(), type);
  }

  private <T> T parseResponse(HttpResponse<String> response, TypeReference<T> type)
      throws IOException {
    ensureSuccess(response);
    return readBody(response.body(), type);
  }

  private void ensureSuccess(HttpResponse<String> response) {
    if (response.statusCode() < 200 || response.statusCode() >= 300) {
      throw ApiException.from(response);
    }
  }

  private <T> T readBody(String body, Class<T> type) throws IOException {
    if (body == null || body.isBlank()) return null;
    return mapper.readValue(body, type);
  }

  private <T> T readBody(String body, TypeReference<T> type) throws IOException {
    if (body == null || body.isBlank()) return null;
    return mapper.readValue(body, type);
  }

  private <T> SseEventStream<T> openStream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      JavaType type
  ) {
    return new SseEventStream<>(
        client,
        mapper,
        buildRequest(method, route, path, query, headers, body, "text/event-stream"),
        type);
  }

  private <T> HttpResponse<T> send(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      HttpResponse.BodyHandler<T> handler
  ) throws IOException, InterruptedException {
    return client.send(buildRequest(method, route, path, query, headers, body, "application/json"), handler);
  }

  private HttpRequest buildRequest(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      String accept
  ) {
    var builder =
        HttpRequest.newBuilder(buildUri(route, path, query))
            .timeout(config.timeout())
            .header("Accept", accept);

    for (var entry : config.headers().entrySet()) {
      builder.header(entry.getKey(), entry.getValue());
    }
    for (var entry : headers.entrySet()) {
      builder.header(entry.getKey(), entry.getValue());
    }

    if (config.directory() != null && !config.directory().isBlank()) {
      builder.header("x-opencode-directory", encodeDirectory(config.directory()));
    }

    if (body == null) {
      builder.method(method, HttpRequest.BodyPublishers.noBody());
      return builder.build();
    }

    try {
      var json = mapper.writeValueAsString(body);
      builder.header("Content-Type", "application/json");
      builder.method(method, HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8));
      return builder.build();
    } catch (IOException error) {
      throw new ApiException("Failed to serialize request body", error);
    }
  }

  private URI buildUri(String route, Map<String, Object> path, Map<String, Object> query) {
    var resolved = route;
    for (var entry : path.entrySet()) {
      resolved = resolved.replace("{" + entry.getKey() + "}", encode(String.valueOf(entry.getValue())));
    }

    var base = config.baseUrl();
    var join = resolved.startsWith("/") ? resolved.substring(1) : resolved;
    var uri = base.endsWith("/") ? base + join : base + resolved;
    if (query.isEmpty()) return URI.create(uri);

    var parts = new ArrayList<String>();
    for (var entry : query.entrySet()) {
      if (entry.getValue() instanceof Iterable<?> items) {
        for (var item : items) {
          if (item != null) parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
        }
        continue;
      }
      if (entry.getValue() != null && entry.getValue().getClass().isArray()) {
        var array = (Object[]) entry.getValue();
        for (var item : array) {
          if (item != null) parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(item)));
        }
        continue;
      }
      if (entry.getValue() != null) {
        parts.add(encode(entry.getKey()) + "=" + encode(String.valueOf(entry.getValue())));
      }
    }

    if (parts.isEmpty()) return URI.create(uri);
    return URI.create(uri + "?" + String.join("&", parts));
  }

  private String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private String encodeDirectory(String value) {
    var ascii = value.chars().allMatch(ch -> ch <= 0x7F);
    return ascii ? value : encode(value);
  }
}
`
}

function configFile() {
  return `
package ${corePackage};

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

${docBlock([
    sentence("OpenCode 客户端配置"),
    "",
    "@param baseUrl 服务端基础地址。",
    "@param httpClient 底层 HTTP 客户端。",
    "@param objectMapper 用于序列化和反序列化的 Jackson 对象映射器。",
    "@param headers 默认请求头。",
    "@param timeout 请求超时时间。",
    "@param directory 默认工作目录。",
  ], "")}public record OpencodeClientConfig(
    String baseUrl,
    HttpClient httpClient,
    ObjectMapper objectMapper,
    Map<String, String> headers,
    Duration timeout,
    String directory
) {
${docBlock([sentence("创建配置构建器")])}  public static Builder builder() {
    return new Builder();
  }

${docBlock([sentence("用于构建客户端配置的构建器")])}  public static final class Builder {
    private String baseUrl = "http://localhost:4096";
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, String> headers = new LinkedHashMap<>();
    private Duration timeout = Duration.ofSeconds(30);
    private String directory;

${docBlock([sentence("设置服务端基础地址"), "", "@param baseUrl 服务端基础地址。", "@return 当前构建器。"])}    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

${docBlock([sentence("设置底层 HTTP 客户端"), "", "@param httpClient 底层 HTTP 客户端。", "@return 当前构建器。"])}    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
      return this;
    }

${docBlock([sentence("设置 Jackson 对象映射器"), "", "@param objectMapper Jackson 对象映射器。", "@return 当前构建器。"])}    public Builder objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      return this;
    }

${docBlock([sentence("批量设置默认请求头"), "", "@param headers 默认请求头。", "@return 当前构建器。"])}    public Builder headers(Map<String, String> headers) {
      this.headers = new LinkedHashMap<>(headers);
      return this;
    }

${docBlock([sentence("追加单个默认请求头"), "", "@param key 请求头名称。", "@param value 请求头值。", "@return 当前构建器。"])}    public Builder header(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

${docBlock([sentence("设置请求超时时间"), "", "@param timeout 请求超时时间。", "@return 当前构建器。"])}    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

${docBlock([sentence("设置默认工作目录"), "", "@param directory 默认工作目录。", "@return 当前构建器。"])}    public Builder directory(String directory) {
      this.directory = directory;
      return this;
    }

${docBlock([sentence("构建客户端配置"), "", "@return 构建完成的客户端配置。"])}    public OpencodeClientConfig build() {
      return new OpencodeClientConfig(baseUrl, httpClient, objectMapper, Map.copyOf(headers), timeout, directory);
    }
  }
}
`
}

function exceptionFile() {
  return `
package ${corePackage};

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serial;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

${docBlock([sentence("表示 OpenCode HTTP 调用过程中抛出的运行时异常")], "")}public class ApiException extends RuntimeException {
  @Serial private static final long serialVersionUID = 1L;
  private static final ObjectMapper RESPONSE_MAPPER = new ObjectMapper();

  private final Integer statusCode;
  private final String responseBody;
  private final Map<String, List<String>> responseHeaders;

${docBlock([sentence("使用普通异常信息和根因创建异常"), "", "@param message 异常消息。", "@param cause 根因异常。"])}  public ApiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = null;
    this.responseBody = null;
    this.responseHeaders = Map.of();
  }

${docBlock([
    sentence("使用 HTTP 响应信息创建异常"),
    "",
    "@param statusCode HTTP 状态码。",
    "@param responseBody 原始响应体。",
    "@param headers 原始响应头。",
  ])}  public ApiException(Integer statusCode, String responseBody, HttpHeaders headers) {
    super("API request failed with status " + statusCode);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
    this.responseHeaders = headers.map();
  }

${docBlock([sentence("获取 HTTP 状态码"), "", "@return HTTP 状态码；若异常并非由 HTTP 响应产生则返回 null。"])}  public Integer statusCode() {
    return statusCode;
  }

${docBlock([sentence("获取原始响应体"), "", "@return 原始响应体；若不存在则返回 null。"])}  public String responseBody() {
    return responseBody;
  }

${docBlock([sentence("获取原始响应头"), "", "@return 原始响应头映射。"])}  public Map<String, List<String>> responseHeaders() {
    return responseHeaders;
  }

${docBlock([sentence("将原始响应体解析为 JSON"), "", "@return 解析后的 JSON 节点；若响应体为空或不是合法 JSON 则返回 null。"])}  public JsonNode responseJson() {
    if (responseBody == null || responseBody.isBlank()) return null;
    try {
      return RESPONSE_MAPPER.readTree(responseBody);
    } catch (IOException error) {
      return null;
    }
  }

${docBlock([sentence("根据字符串响应对象创建异常"), "", "@param response HTTP 响应对象。", "@return 包含状态码、响应体和响应头的异常对象。"])}  public static ApiException from(HttpResponse<String> response) {
    return new ApiException(response.statusCode(), response.body(), response.headers());
  }
}
`
}

function sseEventFile() {
  return `
package ${corePackage};

${docBlock([
    sentence("单条 SSE 事件"),
    "",
    "@param data 事件数据。",
    "@param event 事件名称。",
    "@param id 事件 ID。",
    "@param retry 服务端建议的重试间隔，单位为毫秒。",
  ], "")}public record SseEvent<T>(
    T data,
    String event,
    String id,
    Integer retry
) {
}
`
}

function sseStreamFile() {
  return `
package ${corePackage};

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.NoSuchElementException;

${docBlock([sentence("按需读取服务端 SSE 响应的事件流")], "")}public final class SseEventStream<T> implements AutoCloseable, Iterable<SseEvent<T>> {
  private final BufferedReader reader;
  private final ObjectMapper mapper;
  private final JavaType type;

${docBlock([
    sentence("发送请求并建立 SSE 事件流"),
    "",
    "@param client HTTP 客户端。",
    "@param mapper JSON 反序列化器。",
    "@param request 已构造好的 HTTP 请求。",
    "@param type 事件数据类型。",
    "@throws ApiException 当请求失败或事件流无法建立时抛出。",
  ])}  public SseEventStream(HttpClient client, ObjectMapper mapper, HttpRequest request, JavaType type) {
    try {
      var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
      if (response.statusCode() < 200 || response.statusCode() >= 300) {
        var body = new String(response.body().readAllBytes(), StandardCharsets.UTF_8);
        throw new ApiException(response.statusCode(), body, response.headers());
      }
      this.reader = new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8));
      this.mapper = mapper;
      this.type = type;
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Failed to open SSE stream", error);
    } catch (IOException error) {
      throw new ApiException("Failed to open SSE stream", error);
    }
  }

${docBlock([sentence("返回用于顺序读取事件的迭代器"), "", "@return SSE 事件迭代器。"])}  @Override
  public Iterator<SseEvent<T>> iterator() {
    return new Iterator<>() {
      private SseEvent<T> next;
      private boolean loaded;

      @Override
      public boolean hasNext() {
        if (!loaded) {
          next = readNext();
          loaded = true;
        }
        return next != null;
      }

      @Override
      public SseEvent<T> next() {
        if (!hasNext()) throw new NoSuchElementException();
        loaded = false;
        return next;
      }
    };
  }

  private SseEvent<T> readNext() {
    try {
      String line;
      var data = new StringBuilder();
      String event = null;
      String id = null;
      Integer retry = null;

      while ((line = reader.readLine()) != null) {
        if (line.isEmpty()) {
          var value = toEvent(data, event, id, retry);
          if (value == null) continue;
          return value;
        }
        if (line.startsWith("data:")) {
          if (data.length() > 0) data.append("\\n");
          data.append(line.substring(5).stripLeading());
          continue;
        }
        if (line.startsWith("event:")) {
          event = line.substring(6).stripLeading();
          continue;
        }
        if (line.startsWith("id:")) {
          id = line.substring(3).stripLeading();
          continue;
        }
        if (line.startsWith("retry:")) {
          retry = Integer.parseInt(line.substring(6).stripLeading());
        }
      }
      return toEvent(data, event, id, retry);
    } catch (IOException error) {
      throw new ApiException("Failed to read SSE stream", error);
    }
  }

  private SseEvent<T> toEvent(StringBuilder data, String event, String id, Integer retry)
      throws IOException {
    if (data.length() == 0 && event == null && id == null && retry == null) return null;
    var raw = data.length() == 0 ? null : data.toString();
    T value = raw == null ? null : mapper.readValue(raw, type);
    return new SseEvent<>(value, event, id, retry);
  }

${docBlock([sentence("关闭底层响应流并释放资源"), "", "@throws IOException 当关闭流失败时抛出。"])}  @Override
  public void close() throws IOException {
    reader.close();
  }
}
`
}


for (const def of defs.values()) {
  if (def.kind === "record") {
    await emitJava(modelPackage, def.name, recordFile(def))
    continue
  }
  if (def.kind === "enum") {
    await emitJava(modelPackage, def.name, enumFile(def))
    continue
  }
  if (def.kind === "union") {
    await emitJava(modelPackage, def.name, unionFile(def))
    continue
  }
  if (def.kind === "map") {
    await emitJava(modelPackage, def.name, mapFile(def))
    continue
  }
  if (def.kind === "wrapper") {
    await emitJava(modelPackage, def.name, wrapperFile(def))
  }
}

for (const def of operationTypes.values()) {
  await emitJava(requestPackage, def.name, requestFile(def))
}

await emitApi([], tree)
await emitJava(rootPackage, "OpencodeClient", rootClientFile([...tree.children.keys()]))
await emitJava(corePackage, "OpencodeClientConfig", configFile())
await emitJava(corePackage, "ApiTransport", transportFile())
await emitJava(corePackage, "ApiException", exceptionFile())
await emitJava(corePackage, "SseEvent", sseEventFile())
await emitJava(corePackage, "SseEventStream", sseStreamFile())
