package ai.opencode.sdk.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.model.AppLogBody;
import ai.opencode.sdk.request.AppLogRequest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class OpencodeServeContractIT extends AbstractIntegrationTest {
  @Test
  void liveOpenApiDocumentContainsAllSupportedRoutes() {
    var paths = environment.openApiDocument().path("paths");

    for (var route :
        List.of(
            "/global/health",
            "/global/event",
            "/project",
            "/project/current",
            "/config",
            "/config/providers",
            "/event",
            "/file",
            "/file/content",
            "/file/status",
            "/find",
            "/find/file",
            "/question",
            "/mcp",
            "/path",
            "/command",
            "/agent",
            "/log",
            "/lsp",
            "/formatter",
            "/session",
            "/session/status",
            "/experimental/tool",
            "/experimental/tool/ids")) {
      assertTrue(paths.has(route), () -> "Missing route in live /doc: " + route);
    }
  }

  @Test
  void readOnlyApisWorkAgainstRealServe() {
    var health = client.global().health();
    assertTrue(Boolean.TRUE.equals(health.healthy()));
    assertNotNull(health.version());
    assertFalse(health.version().isBlank());

    var currentProject = client.project().current();
    assertNotNull(currentProject);
    assertEquals(environment.workspaceDir().toString(), currentProject.worktree());
    assertNotNull(currentProject.id());

    var projects = client.project().list();
    assertFalse(projects.isEmpty());
    assertTrue(
        projects.stream()
            .anyMatch(project -> environment.workspaceDir().toString().equals(project.worktree())));

    var path = client.path().get();
    assertEquals(environment.homeDir().toString(), path.home());
    assertEquals(environment.workspaceDir().toString(), path.directory());
    assertEquals(environment.workspaceDir().toString(), path.worktree());

    var config = client.config().get();
    assertNotNull(config);

    var configProviders = client.config().providers();
    assertNotNull(configProviders.providers());
    assertFalse(configProviders.providers().isEmpty());
    assertNotNull(configProviders.defaultValue());

    var agents = client.app().agents();
    assertFalse(agents.isEmpty());

    var commands = client.command().list();
    assertFalse(commands.isEmpty());

    var mcpStatus = client.mcp().status();
    assertNotNull(mcpStatus);

    var formatterStatus = client.formatter().status();
    assertFalse(formatterStatus.isEmpty());

    var lspStatus = client.lsp().status();
    assertNotNull(lspStatus);

    var toolIds = client.tool().ids();
    assertNotNull(toolIds.value());
    assertFalse(toolIds.value().isEmpty());
  }

  @Test
  void isolatedSupportEndpointsAllowSafeMutations() {
    var success =
        client
            .app()
            .log(
                new AppLogRequest(
                    null, new AppLogBody("integration-test", "info", "hello", Map.of())));
    assertTrue(Boolean.TRUE.equals(success));
  }
}
