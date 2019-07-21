package org.galaxyworld.flycode.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class HelloAction extends AnAction {

    public HelloAction() {
        super("Hello");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon());
    }

}
