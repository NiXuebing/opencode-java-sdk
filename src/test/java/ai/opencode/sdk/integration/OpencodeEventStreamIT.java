package ai.opencode.sdk.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ai.opencode.sdk.model.EventServerConnected;
import ai.opencode.sdk.model.EventSessionCreated;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class OpencodeEventStreamIT extends AbstractIntegrationTest {
  @Test
  @Timeout(30)
  void globalEventStreamCarriesWorkspaceScopedSessionEvents() throws Exception {
    var title = "global-event-session-" + System.nanoTime();
    var executor = Executors.newSingleThreadExecutor();

    try (var stream = client.global().event()) {
      var future =
          executor.submit(
              () -> {
                for (var item : stream) {
                  var event = item.data();
                  if (event == null || event.payload() == null) {
                    continue;
                  }
                  if (event.payload() instanceof EventSessionCreated) {
                    return (EventSessionCreated) event.payload();
                  }
                }
                throw new AssertionError("global/event closed before session.created arrived");
              });

      var created = environment.createSession(title);
      try {
        var event = future.get(20, TimeUnit.SECONDS);
        assertNotNull(event.properties());
        assertNotNull(event.properties().info());
        assertEquals(created.id(), event.properties().info().id());
        assertEquals(title, event.properties().info().title());
      } finally {
        environment.deleteSessionQuietly(created.id());
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  @Timeout(30)
  void workspaceEventStreamEmitsServerConnectedThenSessionCreated() throws Exception {
    var title = "workspace-event-session-" + System.nanoTime();
    var executor = Executors.newSingleThreadExecutor();

    try (var stream = client.event().subscribe()) {
      var iterator = stream.iterator();
      var first = iterator.next();
      var connected = assertInstanceOf(EventServerConnected.class, first.data());
      assertEquals("server.connected", connected.type());

      var future =
          executor.submit(
              () -> {
                for (var item : stream) {
                  if (item.data() instanceof EventSessionCreated) {
                    return (EventSessionCreated) item.data();
                  }
                }
                throw new AssertionError("/event closed before session.created arrived");
              });

      var created = environment.createSession(title);
      try {
        var event = future.get(20, TimeUnit.SECONDS);
        assertNotNull(event.properties());
        assertNotNull(event.properties().info());
        assertEquals(created.id(), event.properties().info().id());
        assertEquals(title, event.properties().info().title());
      } finally {
        environment.deleteSessionQuietly(created.id());
      }
    } finally {
      executor.shutdownNow();
    }
  }
}
