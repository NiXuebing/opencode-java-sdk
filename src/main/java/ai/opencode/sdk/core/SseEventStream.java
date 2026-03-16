package ai.opencode.sdk.core;

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
          if (data.length() > 0) data.append("\n");
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
