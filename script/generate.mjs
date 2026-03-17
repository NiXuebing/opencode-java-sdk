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
  "GET /tui/control/next",
  "POST /tui/control/response",
  "PUT /auth/{providerID}",
  "GET /event",
])
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
      })
    }

    operations.push({
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
    })
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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(
${fields}
)${impl} {
}
`
}

function mapFile(def) {
  return `
package ${modelPackage};

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ${def.name} extends LinkedHashMap<String, ${def.valueType}> {
  public ${def.name}() {
    super();
  }
}
`
}

function wrapperFile(def) {
  return `
package ${modelPackage};

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(@JsonValue ${def.valueType} value) {
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
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
  const values = def.values
    .map((value) => `  ${enumConstant(value)}("${escape(value)}")`)
    .join(",\n")
  return `
package ${modelPackage};

import com.fasterxml.jackson.annotation.*;

public enum ${def.name} {
${values};

  private final String value;

  ${def.name}(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
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
  const permits = def.variants.map((variant) => variant.name).join(", ")
  const subTypes = def.variants
    .map((variant) => `    @JsonSubTypes.Type(value = ${variant.name}.class, name = "${escape(variant.label)}")`)
    .join(",\n")
  return `
package ${modelPackage};

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "${escape(def.discriminator)}", visible = true)
@JsonSubTypes({
${subTypes}
})
public sealed interface ${def.name} permits ${permits} {
}
`
}

function requestFile(def) {
  const fields = def.fields
    .map(
      (field) =>
        `    @JsonProperty("${escape(field.jsonName)}") ${field.type} ${field.name}`,
    )
    .join(",\n")
  return `
package ${requestPackage};

import ${modelPackage}.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ${def.name}(
${fields}
) {
}
`
}

function javadoc(operation) {
  const lines = [operation.summary, operation.description].filter(Boolean)
  if (lines.length === 0) return ""
  const body = lines.map((line) => ` * ${line}`).join("\n")
  return `  /**\n${body}\n   */\n`
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
    ? `  public ${returnType} ${name}() {\n    return ${name}(new ${operation.requestName}(${operation.requestFields.map(() => "null").join(", ")}));\n  }\n\n`
    : ""
  return `${javadoc(operation)}${overload}  public ${returnType} ${name}(${request}) {
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
  const getters = children
    .map(([part]) => `  public ${classNameFor([...parts, part])} ${camel(part)}() {\n    return ${camel(part)};\n  }\n`)
    .join("\n")
  const methods = node.operations.map(operationMethod).join("\n")
  return `
package ${apiPackage};

import ${corePackage}.*;
import ${modelPackage}.*;
import ${requestPackage}.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public final class ${className} {
  private final ApiTransport transport;
${fields ? `${fields}\n` : ""}
  public ${className}(ApiTransport transport) {
    this.transport = transport;
${init ? `${init}\n` : ""}
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
  const fields = children.map((part) => `  private final ${classNameFor([part])} ${camel(part)};`).join("\n")
  const init = children.map((part) => `    this.${camel(part)} = new ${classNameFor([part])}(transport);`).join("\n")
  const getters = children
    .map((part) => `  public ${classNameFor([part])} ${camel(part)}() {\n    return ${camel(part)};\n  }\n`)
    .join("\n")
  return `
package ${rootPackage};

import ${apiPackage}.*;
import ${corePackage}.*;

public final class OpencodeClient {
  private final ApiTransport transport;
${fields}

  public OpencodeClient() {
    this(OpencodeClientConfig.builder().build());
  }

  public OpencodeClient(OpencodeClientConfig config) {
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

public final class ApiTransport {
  private final OpencodeClientConfig config;
  private final HttpClient client;
  private final ObjectMapper mapper;

  public ApiTransport(OpencodeClientConfig config) {
    this.config = config;
    this.client = config.httpClient();
    this.mapper = config.objectMapper()
        .copy()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type
  ) {
    try {
      var response = send(method, route, path, query, headers, body, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() < 200 || response.statusCode() >= 300) throw ApiException.from(response);
      if (type == Void.class) return null;
      if (response.body() == null || response.body().isBlank()) return null;
      return mapper.readValue(response.body(), type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  public <T> T execute(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type
  ) {
    try {
      var response = send(method, route, path, query, headers, body, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() < 200 || response.statusCode() >= 300) throw ApiException.from(response);
      if (response.body() == null || response.body().isBlank()) return null;
      return mapper.readValue(response.body(), type);
    } catch (InterruptedException error) {
      Thread.currentThread().interrupt();
      throw new ApiException("Request interrupted", error);
    } catch (IOException error) {
      throw new ApiException("Request failed", error);
    }
  }

  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      Class<T> type
  ) {
    return new SseEventStream<>(client, mapper, buildRequest(method, route, path, query, headers, body, "text/event-stream"), mapper.constructType(type));
  }

  public <T> SseEventStream<T> stream(
      String method,
      String route,
      Map<String, Object> path,
      Map<String, Object> query,
      Map<String, String> headers,
      Object body,
      TypeReference<T> type
  ) {
    return new SseEventStream<>(client, mapper, buildRequest(method, route, path, query, headers, body, "text/event-stream"), mapper.constructType(type));
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
    var builder = HttpRequest.newBuilder(buildUri(route, path, query))
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

public record OpencodeClientConfig(
    String baseUrl,
    HttpClient httpClient,
    ObjectMapper objectMapper,
    Map<String, String> headers,
    Duration timeout,
    String directory
) {
  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String baseUrl = "http://localhost:4096";
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, String> headers = new LinkedHashMap<>();
    private Duration timeout = Duration.ofSeconds(30);
    private String directory;

    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder httpClient(HttpClient httpClient) {
      this.httpClient = httpClient;
      return this;
    }

    public Builder objectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
      return this;
    }

    public Builder headers(Map<String, String> headers) {
      this.headers = new LinkedHashMap<>(headers);
      return this;
    }

    public Builder header(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    public Builder directory(String directory) {
      this.directory = directory;
      return this;
    }

    public OpencodeClientConfig build() {
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
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ApiException extends RuntimeException {
  private final Integer statusCode;
  private final String responseBody;
  private final Map<String, List<String>> responseHeaders;

  public ApiException(String message, Throwable cause) {
    super(message, cause);
    this.statusCode = null;
    this.responseBody = null;
    this.responseHeaders = Map.of();
  }

  public ApiException(Integer statusCode, String responseBody, HttpHeaders headers) {
    super("API request failed with status " + statusCode);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
    this.responseHeaders = headers.map();
  }

  public Integer statusCode() {
    return statusCode;
  }

  public String responseBody() {
    return responseBody;
  }

  public Map<String, List<String>> responseHeaders() {
    return responseHeaders;
  }

  public JsonNode responseJson() {
    if (responseBody == null || responseBody.isBlank()) return null;
    try {
      return new ObjectMapper().readTree(responseBody);
    } catch (IOException error) {
      return null;
    }
  }

  public static ApiException from(HttpResponse<String> response) {
    return new ApiException(response.statusCode(), response.body(), response.headers());
  }
}
`
}

function sseEventFile() {
  return `
package ${corePackage};

public record SseEvent<T>(
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

public final class SseEventStream<T> implements AutoCloseable, Iterable<SseEvent<T>> {
  private final BufferedReader reader;
  private final ObjectMapper mapper;
  private final JavaType type;

  public SseEventStream(HttpClient client, ObjectMapper mapper, HttpRequest request, JavaType type) {
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

  @Override
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
          if (data.length() == 0 && event == null && id == null && retry == null) continue;
          var raw = data.length() == 0 ? null : data.toString();
          T value = raw == null ? null : mapper.readValue(raw, type);
          return new SseEvent<>(value, event, id, retry);
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
      if (data.length() == 0 && event == null && id == null && retry == null) return null;
      var raw = data.length() == 0 ? null : data.toString();
      T value = raw == null ? null : mapper.readValue(raw, type);
      return new SseEvent<>(value, event, id, retry);
    } catch (IOException error) {
      throw new ApiException("Failed to read SSE stream", error);
    }
  }

  @Override
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
