package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = EventInstallationUpdated.class, name = "installation.updated"),
    @JsonSubTypes.Type(value = EventInstallationUpdateAvailable.class, name = "installation.update-available"),
    @JsonSubTypes.Type(value = EventProjectUpdated.class, name = "project.updated"),
    @JsonSubTypes.Type(value = EventServerInstanceDisposed.class, name = "server.instance.disposed"),
    @JsonSubTypes.Type(value = EventServerConnected.class, name = "server.connected"),
    @JsonSubTypes.Type(value = EventGlobalDisposed.class, name = "global.disposed"),
    @JsonSubTypes.Type(value = EventLspClientDiagnostics.class, name = "lsp.client.diagnostics"),
    @JsonSubTypes.Type(value = EventLspUpdated.class, name = "lsp.updated"),
    @JsonSubTypes.Type(value = EventFileEdited.class, name = "file.edited"),
    @JsonSubTypes.Type(value = EventMessageUpdated.class, name = "message.updated"),
    @JsonSubTypes.Type(value = EventMessageRemoved.class, name = "message.removed"),
    @JsonSubTypes.Type(value = EventMessagePartUpdated.class, name = "message.part.updated"),
    @JsonSubTypes.Type(value = EventMessagePartDelta.class, name = "message.part.delta"),
    @JsonSubTypes.Type(value = EventMessagePartRemoved.class, name = "message.part.removed"),
    @JsonSubTypes.Type(value = EventPermissionAsked.class, name = "permission.asked"),
    @JsonSubTypes.Type(value = EventPermissionReplied.class, name = "permission.replied"),
    @JsonSubTypes.Type(value = EventSessionStatus.class, name = "session.status"),
    @JsonSubTypes.Type(value = EventSessionIdle.class, name = "session.idle"),
    @JsonSubTypes.Type(value = EventQuestionAsked.class, name = "question.asked"),
    @JsonSubTypes.Type(value = EventQuestionReplied.class, name = "question.replied"),
    @JsonSubTypes.Type(value = EventQuestionRejected.class, name = "question.rejected"),
    @JsonSubTypes.Type(value = EventSessionCompacted.class, name = "session.compacted"),
    @JsonSubTypes.Type(value = EventFileWatcherUpdated.class, name = "file.watcher.updated"),
    @JsonSubTypes.Type(value = EventTodoUpdated.class, name = "todo.updated"),
    @JsonSubTypes.Type(value = EventTuiPromptAppend.class, name = "tui.prompt.append"),
    @JsonSubTypes.Type(value = EventTuiCommandExecute.class, name = "tui.command.execute"),
    @JsonSubTypes.Type(value = EventTuiToastShow.class, name = "tui.toast.show"),
    @JsonSubTypes.Type(value = EventTuiSessionSelect.class, name = "tui.session.select"),
    @JsonSubTypes.Type(value = EventMcpToolsChanged.class, name = "mcp.tools.changed"),
    @JsonSubTypes.Type(value = EventMcpBrowserOpenFailed.class, name = "mcp.browser.open.failed"),
    @JsonSubTypes.Type(value = EventCommandExecuted.class, name = "command.executed"),
    @JsonSubTypes.Type(value = EventSessionCreated.class, name = "session.created"),
    @JsonSubTypes.Type(value = EventSessionUpdated.class, name = "session.updated"),
    @JsonSubTypes.Type(value = EventSessionDeleted.class, name = "session.deleted"),
    @JsonSubTypes.Type(value = EventSessionDiff.class, name = "session.diff"),
    @JsonSubTypes.Type(value = EventSessionError.class, name = "session.error"),
    @JsonSubTypes.Type(value = EventSessionTurnCompleted.class, name = "session.turn.completed"),
    @JsonSubTypes.Type(value = EventVcsBranchUpdated.class, name = "vcs.branch.updated"),
    @JsonSubTypes.Type(value = EventPtyCreated.class, name = "pty.created"),
    @JsonSubTypes.Type(value = EventPtyUpdated.class, name = "pty.updated"),
    @JsonSubTypes.Type(value = EventPtyExited.class, name = "pty.exited"),
    @JsonSubTypes.Type(value = EventPtyDeleted.class, name = "pty.deleted"),
    @JsonSubTypes.Type(value = EventWorktreeReady.class, name = "worktree.ready"),
    @JsonSubTypes.Type(value = EventWorktreeFailed.class, name = "worktree.failed"),
    @JsonSubTypes.Type(value = EventMirrorSessionDisposed.class, name = "mirror.session.disposed")
})
public sealed interface Event permits EventInstallationUpdated, EventInstallationUpdateAvailable, EventProjectUpdated, EventServerInstanceDisposed, EventServerConnected, EventGlobalDisposed, EventLspClientDiagnostics, EventLspUpdated, EventFileEdited, EventMessageUpdated, EventMessageRemoved, EventMessagePartUpdated, EventMessagePartDelta, EventMessagePartRemoved, EventPermissionAsked, EventPermissionReplied, EventSessionStatus, EventSessionIdle, EventQuestionAsked, EventQuestionReplied, EventQuestionRejected, EventSessionCompacted, EventFileWatcherUpdated, EventTodoUpdated, EventTuiPromptAppend, EventTuiCommandExecute, EventTuiToastShow, EventTuiSessionSelect, EventMcpToolsChanged, EventMcpBrowserOpenFailed, EventCommandExecuted, EventSessionCreated, EventSessionUpdated, EventSessionDeleted, EventSessionDiff, EventSessionError, EventSessionTurnCompleted, EventVcsBranchUpdated, EventPtyCreated, EventPtyUpdated, EventPtyExited, EventPtyDeleted, EventWorktreeReady, EventWorktreeFailed, EventMirrorSessionDisposed {
}
