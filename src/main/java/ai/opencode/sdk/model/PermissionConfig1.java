package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * 权限配置数据模型。
 *
 * @param originalKeys 原始键列表。
 * @param read 读取信息。
 * @param edit 编辑。
 * @param glob 通配。
 * @param grep Grep 权限配置。
 * @param list 列表。
 * @param bash Bash 权限配置。
 * @param task 任务。
 * @param externalDirectory 外部目录权限。
 * @param todowrite 待办写入权限配置。
 * @param todoread 待办读取权限配置。
 * @param question 问题。
 * @param webfetch WebFetch 权限配置。
 * @param websearch WebSearch 权限配置。
 * @param codesearch CodeSearch 权限配置。
 * @param lsp LSP 配置。
 * @param doomLoop 是否允许死循环。
 * @param skill 技能。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PermissionConfig1 {
  @JsonProperty("__originalKeys")
  private final List<String> originalKeys;
  @JsonProperty("read")
  private final PermissionRuleConfig read;
  @JsonProperty("edit")
  private final PermissionRuleConfig edit;
  @JsonProperty("glob")
  private final PermissionRuleConfig glob;
  @JsonProperty("grep")
  private final PermissionRuleConfig grep;
  @JsonProperty("list")
  private final PermissionRuleConfig list;
  @JsonProperty("bash")
  private final PermissionRuleConfig bash;
  @JsonProperty("task")
  private final PermissionRuleConfig task;
  @JsonProperty("external_directory")
  private final PermissionRuleConfig externalDirectory;
  @JsonProperty("todowrite")
  private final PermissionActionConfig todowrite;
  @JsonProperty("todoread")
  private final PermissionActionConfig todoread;
  @JsonProperty("question")
  private final PermissionActionConfig question;
  @JsonProperty("webfetch")
  private final PermissionActionConfig webfetch;
  @JsonProperty("websearch")
  private final PermissionActionConfig websearch;
  @JsonProperty("codesearch")
  private final PermissionActionConfig codesearch;
  @JsonProperty("lsp")
  private final PermissionRuleConfig lsp;
  @JsonProperty("doom_loop")
  private final PermissionActionConfig doomLoop;
  @JsonProperty("skill")
  private final PermissionRuleConfig skill;

  /** 使用字段创建权限配置。 */
  @JsonCreator
  public PermissionConfig1(
      @JsonProperty("__originalKeys") List<String> originalKeys,
      @JsonProperty("read") PermissionRuleConfig read,
      @JsonProperty("edit") PermissionRuleConfig edit,
      @JsonProperty("glob") PermissionRuleConfig glob,
      @JsonProperty("grep") PermissionRuleConfig grep,
      @JsonProperty("list") PermissionRuleConfig list,
      @JsonProperty("bash") PermissionRuleConfig bash,
      @JsonProperty("task") PermissionRuleConfig task,
      @JsonProperty("external_directory") PermissionRuleConfig externalDirectory,
      @JsonProperty("todowrite") PermissionActionConfig todowrite,
      @JsonProperty("todoread") PermissionActionConfig todoread,
      @JsonProperty("question") PermissionActionConfig question,
      @JsonProperty("webfetch") PermissionActionConfig webfetch,
      @JsonProperty("websearch") PermissionActionConfig websearch,
      @JsonProperty("codesearch") PermissionActionConfig codesearch,
      @JsonProperty("lsp") PermissionRuleConfig lsp,
      @JsonProperty("doom_loop") PermissionActionConfig doomLoop,
      @JsonProperty("skill") PermissionRuleConfig skill
  ) {
    this.originalKeys = originalKeys;
    this.read = read;
    this.edit = edit;
    this.glob = glob;
    this.grep = grep;
    this.list = list;
    this.bash = bash;
    this.task = task;
    this.externalDirectory = externalDirectory;
    this.todowrite = todowrite;
    this.todoread = todoread;
    this.question = question;
    this.webfetch = webfetch;
    this.websearch = websearch;
    this.codesearch = codesearch;
    this.lsp = lsp;
    this.doomLoop = doomLoop;
    this.skill = skill;
  }

  /**
   * 获取原始Keys。
   *
   * @return 原始键列表。
   */
  public List<String> originalKeys() {
    return originalKeys;
  }

  /**
   * 获取读取。
   *
   * @return 读取信息。
   */
  public PermissionRuleConfig read() {
    return read;
  }

  /**
   * 获取编辑。
   *
   * @return 编辑。
   */
  public PermissionRuleConfig edit() {
    return edit;
  }

  /**
   * 获取通配。
   *
   * @return 通配。
   */
  public PermissionRuleConfig glob() {
    return glob;
  }

  /**
   * 获取grep。
   *
   * @return Grep 权限配置。
   */
  public PermissionRuleConfig grep() {
    return grep;
  }

  /**
   * 获取列表。
   *
   * @return 列表。
   */
  public PermissionRuleConfig list() {
    return list;
  }

  /**
   * 获取bash。
   *
   * @return Bash 权限配置。
   */
  public PermissionRuleConfig bash() {
    return bash;
  }

  /**
   * 获取任务。
   *
   * @return 任务。
   */
  public PermissionRuleConfig task() {
    return task;
  }

  /**
   * 获取external目录。
   *
   * @return 外部目录权限。
   */
  public PermissionRuleConfig externalDirectory() {
    return externalDirectory;
  }

  /**
   * 获取todowrite。
   *
   * @return 待办写入权限配置。
   */
  public PermissionActionConfig todowrite() {
    return todowrite;
  }

  /**
   * 获取todoread。
   *
   * @return 待办读取权限配置。
   */
  public PermissionActionConfig todoread() {
    return todoread;
  }

  /**
   * 获取问题。
   *
   * @return 问题。
   */
  public PermissionActionConfig question() {
    return question;
  }

  /**
   * 获取webfetch。
   *
   * @return WebFetch 权限配置。
   */
  public PermissionActionConfig webfetch() {
    return webfetch;
  }

  /**
   * 获取websearch。
   *
   * @return WebSearch 权限配置。
   */
  public PermissionActionConfig websearch() {
    return websearch;
  }

  /**
   * 获取codesearch。
   *
   * @return CodeSearch 权限配置。
   */
  public PermissionActionConfig codesearch() {
    return codesearch;
  }

  /**
   * 获取LSP。
   *
   * @return LSP 配置。
   */
  public PermissionRuleConfig lsp() {
    return lsp;
  }

  /**
   * 获取死循环loop。
   *
   * @return 是否允许死循环。
   */
  public PermissionActionConfig doomLoop() {
    return doomLoop;
  }

  /**
   * 获取技能。
   *
   * @return 技能。
   */
  public PermissionRuleConfig skill() {
    return skill;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof PermissionConfig1)) return false;
    PermissionConfig1 that = (PermissionConfig1) other;
    return Objects.equals(originalKeys, that.originalKeys)
        && Objects.equals(read, that.read)
        && Objects.equals(edit, that.edit)
        && Objects.equals(glob, that.glob)
        && Objects.equals(grep, that.grep)
        && Objects.equals(list, that.list)
        && Objects.equals(bash, that.bash)
        && Objects.equals(task, that.task)
        && Objects.equals(externalDirectory, that.externalDirectory)
        && Objects.equals(todowrite, that.todowrite)
        && Objects.equals(todoread, that.todoread)
        && Objects.equals(question, that.question)
        && Objects.equals(webfetch, that.webfetch)
        && Objects.equals(websearch, that.websearch)
        && Objects.equals(codesearch, that.codesearch)
        && Objects.equals(lsp, that.lsp)
        && Objects.equals(doomLoop, that.doomLoop)
        && Objects.equals(skill, that.skill);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalKeys, read, edit, glob, grep, list, bash, task, externalDirectory, todowrite, todoread, question, webfetch, websearch, codesearch, lsp, doomLoop, skill);
  }

  @Override
  public String toString() {
    return "PermissionConfig1{" +
        "originalKeys=" + originalKeys + "," +
        "read=" + read + "," +
        "edit=" + edit + "," +
        "glob=" + glob + "," +
        "grep=" + grep + "," +
        "list=" + list + "," +
        "bash=" + bash + "," +
        "task=" + task + "," +
        "externalDirectory=" + externalDirectory + "," +
        "todowrite=" + todowrite + "," +
        "todoread=" + todoread + "," +
        "question=" + question + "," +
        "webfetch=" + webfetch + "," +
        "websearch=" + websearch + "," +
        "codesearch=" + codesearch + "," +
        "lsp=" + lsp + "," +
        "doomLoop=" + doomLoop + "," +
        "skill=" + skill +
        "}";
  }
}
