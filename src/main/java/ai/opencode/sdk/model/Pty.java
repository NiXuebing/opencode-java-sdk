package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * PTY数据模型。
 *
 * @param id 唯一标识。
 * @param title 标题。
 * @param command 命令内容。
 * @param args 参数列表。
 * @param cwd 当前工作目录。
 * @param status 当前状态。
 * @param pid 进程 ID。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Pty {
  @JsonProperty("id")
  private final String id;
  @JsonProperty("title")
  private final String title;
  @JsonProperty("command")
  private final String command;
  @JsonProperty("args")
  private final List<String> args;
  @JsonProperty("cwd")
  private final String cwd;
  @JsonProperty("status")
  private final String status;
  @JsonProperty("pid")
  private final Double pid;

  /** 使用字段创建PTY。 */
  @JsonCreator
  public Pty(
      @JsonProperty("id") String id,
      @JsonProperty("title") String title,
      @JsonProperty("command") String command,
      @JsonProperty("args") List<String> args,
      @JsonProperty("cwd") String cwd,
      @JsonProperty("status") String status,
      @JsonProperty("pid") Double pid
  ) {
    this.id = id;
    this.title = title;
    this.command = command;
    this.args = args;
    this.cwd = cwd;
    this.status = status;
    this.pid = pid;
  }

  /**
   * 获取id。
   *
   * @return 唯一标识。
   */
  public String id() {
    return id;
  }

  /**
   * 获取title。
   *
   * @return 标题。
   */
  public String title() {
    return title;
  }

  /**
   * 获取命令。
   *
   * @return 命令内容。
   */
  public String command() {
    return command;
  }

  /**
   * 获取参数。
   *
   * @return 参数列表。
   */
  public List<String> args() {
    return args;
  }

  /**
   * 获取工作目录。
   *
   * @return 当前工作目录。
   */
  public String cwd() {
    return cwd;
  }

  /**
   * 获取状态。
   *
   * @return 当前状态。
   */
  public String status() {
    return status;
  }

  /**
   * 获取pid。
   *
   * @return 进程 ID。
   */
  public Double pid() {
    return pid;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Pty)) return false;
    Pty that = (Pty) other;
    return Objects.equals(id, that.id)
        && Objects.equals(title, that.title)
        && Objects.equals(command, that.command)
        && Objects.equals(args, that.args)
        && Objects.equals(cwd, that.cwd)
        && Objects.equals(status, that.status)
        && Objects.equals(pid, that.pid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, command, args, cwd, status, pid);
  }

  @Override
  public String toString() {
    return "Pty{" +
        "id=" + id + "," +
        "title=" + title + "," +
        "command=" + command + "," +
        "args=" + args + "," +
        "cwd=" + cwd + "," +
        "status=" + status + "," +
        "pid=" + pid +
        "}";
  }
}
