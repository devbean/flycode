package org.galaxyworld.flycode.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DbTableFakeWizardDialog extends DialogWrapper {

    private JPanel rootPanel;

    public DbTableFakeWizardDialog(@Nullable Project project) {
        super(project, true);
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return this.rootPanel;
    }
}
