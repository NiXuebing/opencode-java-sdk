package ai.opencode.sdk.model;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = EventTuiPromptAppend.class, name = "tui.prompt.append"),
    @JsonSubTypes.Type(value = EventTuiCommandExecute.class, name = "tui.command.execute"),
    @JsonSubTypes.Type(value = EventTuiToastShow.class, name = "tui.toast.show"),
    @JsonSubTypes.Type(value = EventTuiSessionSelect.class, name = "tui.session.select")
})
public sealed interface TuiPublishBody permits EventTuiPromptAppend, EventTuiCommandExecute, EventTuiToastShow, EventTuiSessionSelect {
}
