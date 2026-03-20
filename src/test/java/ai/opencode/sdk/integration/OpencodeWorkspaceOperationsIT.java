package ai.opencode.sdk.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ai.opencode.sdk.core.ApiException;
import ai.opencode.sdk.model.SessionCreateBody;
import ai.opencode.sdk.model.SessionUpdateBody;
import ai.opencode.sdk.request.FileListRequest;
import ai.opencode.sdk.request.FileReadRequest;
import ai.opencode.sdk.request.SessionChildrenRequest;
import ai.opencode.sdk.request.SessionCreateRequest;
import ai.opencode.sdk.request.SessionDeleteRequest;
import ai.opencode.sdk.request.SessionGetRequest;
import ai.opencode.sdk.request.SessionTodoRequest;
import ai.opencode.sdk.request.SessionUpdateRequest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OpencodeWorkspaceOperationsIT extends AbstractIntegrationTest {
  @Test
  void fileApisSeeLiveWorkspaceState() {
    var nodes = client.file().list(new FileListRequest(null, "."));
    assertFalse(nodes.isEmpty());
    assertTrue(nodes.stream().anyMatch(node -> "README.md".equals(node.path())));
    assertTrue(nodes.stream().anyMatch(node -> "src".equals(node.path())));

    var readme = client.file().read(new FileReadRequest(null, "README.md"));
    assertNotNull(readme);
    assertNotNull(readme.content());
    assertTrue(readme.content().contains("hello opencode"));

    environment.appendReadmeLine("status-marker-" + UUID.randomUUID());
    var status = client.file().status();
    assertTrue(
        status.stream()
            .anyMatch(
                file ->
                    "README.md".equals(file.path())
                        && "modified".equals(file.status())
                        && file.added() != null
                        && file.added() >= 1));
  }

  @Test
  void sessionLifecycleApisWorkAgainstRealServe() {
    var sessionsBefore = client.session().list();
    assertNotNull(sessionsBefore);

    var statusBefore = client.session().status();
    assertNotNull(statusBefore);

    var created =
        client
            .session()
            .create(
                new SessionCreateRequest(
                    null, new SessionCreateBody(null, "integration-session", null, null)));
    assertNotNull(created.id());
    assertEquals("integration-session", created.title());

    var loaded = client.session().get(new SessionGetRequest(created.id(), null));
    assertEquals(created.id(), loaded.id());
    assertEquals("integration-session", loaded.title());

    var children = client.session().children(new SessionChildrenRequest(created.id(), null));
    assertNotNull(children);
    assertTrue(children.isEmpty());

    var todo = client.session().todo(new SessionTodoRequest(created.id(), null));
    assertNotNull(todo);
    assertTrue(todo.isEmpty());

    var updated =
        client
            .session()
            .update(
                new SessionUpdateRequest(
                    created.id(),
                    null,
                    new SessionUpdateBody("integration-session-updated", null)));
    assertEquals(created.id(), updated.id());
    assertEquals("integration-session-updated", updated.title());

    assertTrue(
        Boolean.TRUE.equals(client.session().delete(new SessionDeleteRequest(created.id(), null))));

    var error =
        assertThrows(
            ApiException.class,
            () -> client.session().get(new SessionGetRequest(created.id(), null)));
    assertEquals(404, error.statusCode());
  }
}
