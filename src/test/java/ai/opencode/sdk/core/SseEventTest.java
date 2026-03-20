package ai.opencode.sdk.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SseEventTest {
  @Test
  void valueSemanticsMatchRecordStyleBehavior() {
    var left = new SseEvent<String>("data", "message", "evt_1", 500);
    var right = new SseEvent<String>("data", "message", "evt_1", 500);
    var different = new SseEvent<String>("other", "message", "evt_1", 500);

    assertEquals("data", left.data());
    assertEquals("message", left.event());
    assertEquals("evt_1", left.id());
    assertEquals(Integer.valueOf(500), left.retry());
    assertEquals(left, right);
    assertEquals(left.hashCode(), right.hashCode());
    assertNotEquals(left, different);
    assertTrue(left.toString().contains("evt_1"));
  }
}
