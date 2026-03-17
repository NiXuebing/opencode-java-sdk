package ai.opencode.sdk.testutil;

import com.fasterxml.jackson.databind.node.TextNode;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class SampleFactory {
  private final Set<Type> building = new LinkedHashSet<>();

  public Object sample(Type type) {
    return sample(type, "value");
  }

  private Object sample(Type type, String hint) {
    if (type instanceof Class<?> cls) {
      return sampleClass(cls, hint);
    }
    if (type instanceof ParameterizedType parameterizedType) {
      return sampleParameterizedType(parameterizedType, hint);
    }
    if (type instanceof GenericArrayType genericArrayType) {
      var component = genericArrayType.getGenericComponentType();
      var array = Array.newInstance(rawType(component), 1);
      Array.set(array, 0, sample(component, hint + "Item"));
      return array;
    }
    if (type instanceof WildcardType wildcardType) {
      var upperBounds = wildcardType.getUpperBounds();
      return sample(upperBounds.length == 0 ? Object.class : upperBounds[0], hint);
    }
    if (type instanceof TypeVariable<?> typeVariable) {
      var bounds = typeVariable.getBounds();
      return sample(bounds.length == 0 ? Object.class : bounds[0], hint);
    }
    return null;
  }

  private Object sampleParameterizedType(ParameterizedType type, String hint) {
    var raw = rawType(type);
    if (List.class.isAssignableFrom(raw)) {
      var value = sample(type.getActualTypeArguments()[0], hint + "Item");
      var list = new ArrayList<>();
      if (value != null) list.add(value);
      return list;
    }
    if (Set.class.isAssignableFrom(raw)) {
      var value = sample(type.getActualTypeArguments()[0], hint + "Item");
      var set = new LinkedHashSet<>();
      if (value != null) set.add(value);
      return set;
    }
    if (Map.class.isAssignableFrom(raw)) {
      var map = new LinkedHashMap<>();
      var key = sampleKey(type.getActualTypeArguments()[0], hint + "Key");
      var value = sample(type.getActualTypeArguments()[1], hint + "Value");
      if (key != null && value != null) map.put(key, value);
      return map;
    }
    return sampleClass(raw, hint);
  }

  private Object sampleClass(Class<?> type, String hint) {
    if (building.contains(type)) {
      return fallback(type);
    }
    if (type == Object.class) return "sample-object";
    if (type == Void.class || type == void.class) return null;
    if (type == String.class || CharSequence.class.isAssignableFrom(type)) return stringValue(hint);
    if (type == boolean.class || type == Boolean.class) return Boolean.TRUE;
    if (type == byte.class || type == Byte.class) return (byte) 1;
    if (type == short.class || type == Short.class) return (short) 1;
    if (type == int.class || type == Integer.class) return 1;
    if (type == long.class || type == Long.class) return 1L;
    if (type == float.class || type == Float.class) return 1.0f;
    if (type == double.class || type == Double.class) return 1.0d;
    if (type == BigInteger.class) return BigInteger.ONE;
    if (type == BigDecimal.class) return BigDecimal.ONE;
    if (type == UUID.class) return UUID.fromString("00000000-0000-0000-0000-000000000001");
    if (type == URI.class) return URI.create("https://example.com/sample");
    if (type == Duration.class) return Duration.ofSeconds(1);
    if (type == Instant.class) return Instant.parse("2024-01-01T00:00:00Z");
    if (type == byte[].class) return "sample".getBytes(StandardCharsets.UTF_8);
    if (type == File.class) return new File("sample.txt");
    if (type == java.nio.file.Path.class) return Paths.get("sample.txt");
    if (type == com.fasterxml.jackson.databind.JsonNode.class) return TextNode.valueOf("sample");
    if (type.isEnum()) return type.getEnumConstants()[0];
    if (type.isArray()) {
      var array = Array.newInstance(type.getComponentType(), 1);
      Array.set(array, 0, sample(type.getComponentType(), hint + "Item"));
      return array;
    }
    if (List.class.isAssignableFrom(type)) return new ArrayList<>();
    if (Set.class.isAssignableFrom(type)) return new LinkedHashSet<>();
    if (Map.class.isAssignableFrom(type)) return new LinkedHashMap<>();
    if (type.isSealed()) {
      var permitted = type.getPermittedSubclasses();
      if (permitted.length > 0) return sample(permitted[0], hint);
    }
    if (type.isInterface() || Modifier.isAbstract(type.getModifiers())) {
      return null;
    }

    building.add(type);
    try {
      if (type.isRecord()) {
        return instantiateRecord(type);
      }
      Constructor<?> constructor =
          java.util.Arrays.stream(type.getDeclaredConstructors())
              .sorted(java.util.Comparator.comparingInt(Constructor::getParameterCount))
              .findFirst()
              .orElseThrow();
      constructor.setAccessible(true);
      var parameterTypes = constructor.getGenericParameterTypes();
      var arguments = new Object[parameterTypes.length];
      for (int i = 0; i < parameterTypes.length; i++) {
        arguments[i] = sample(parameterTypes[i], type.getSimpleName() + i);
      }
      return constructor.newInstance(arguments);
    } catch (ReflectiveOperationException error) {
      throw new IllegalStateException("Failed to create sample for " + type.getName(), error);
    } finally {
      building.remove(type);
    }
  }

  private Object instantiateRecord(Class<?> type) throws ReflectiveOperationException {
    RecordComponent[] components = type.getRecordComponents();
    Class<?>[] parameterTypes = new Class<?>[components.length];
    Object[] arguments = new Object[components.length];
    for (int i = 0; i < components.length; i++) {
      parameterTypes[i] = components[i].getType();
      arguments[i] = sample(components[i].getGenericType(), components[i].getName());
    }
    var constructor = type.getDeclaredConstructor(parameterTypes);
    constructor.setAccessible(true);
    return constructor.newInstance(arguments);
  }

  private Object sampleKey(Type type, String hint) {
    var key = sample(type, hint);
    return key == null ? stringValue(hint) : key;
  }

  private Class<?> rawType(Type type) {
    if (type instanceof Class<?> cls) return cls;
    if (type instanceof ParameterizedType parameterizedType) {
      return (Class<?>) parameterizedType.getRawType();
    }
    if (type instanceof GenericArrayType genericArrayType) {
      return Array.newInstance(rawType(genericArrayType.getGenericComponentType()), 0).getClass();
    }
    return Object.class;
  }

  private Object fallback(Class<?> type) {
    if (type == boolean.class || type == Boolean.class) return Boolean.TRUE;
    if (type.isPrimitive()) return 0;
    if (List.class.isAssignableFrom(type)) return new ArrayList<>();
    if (Set.class.isAssignableFrom(type)) return new LinkedHashSet<>();
    if (Map.class.isAssignableFrom(type)) return new LinkedHashMap<>();
    return null;
  }

  private String stringValue(String hint) {
    var normalized = hint == null ? "value" : hint.toLowerCase();
    if (normalized.contains("session")) return "ses_123";
    if (normalized.contains("message")) return "msg_123";
    if (normalized.contains("permission")) return "perm_123";
    if (normalized.contains("provider")) return "provider_123";
    if (normalized.contains("workspace")) return "ws_123";
    if (normalized.contains("path")) return "src/Main.java";
    if (normalized.contains("query")) return "sample-query";
    if (normalized.contains("pattern")) return "sample-pattern";
    if (normalized.contains("model")) return "gpt-4.1";
    if (normalized.contains("agent")) return "agent";
    if (normalized.contains("title")) return "sample-title";
    if (normalized.contains("name")) return "sample-name";
    if (normalized.contains("directory")) return "/workspace/sample";
    if (normalized.contains("code")) return "sample-code";
    return "sample";
  }
}
