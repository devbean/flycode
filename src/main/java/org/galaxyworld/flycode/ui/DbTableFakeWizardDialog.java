package org.galaxyworld.flycode.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBTabbedPane;
import org.galaxyworld.flycode.model.DatabaseTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class DbTableFakeWizardDialog extends DialogWrapper {

    private List<DatabaseTable> tables;

    private JPanel rootPanel;
    private JBTabbedPane tabbedPane;

    public DbTableFakeWizardDialog(@NotNull List<DatabaseTable> tables, @NotNull Project project) {
        super(project, true);

        this.tables = tables;

        init();
        setTitle("Database Table Faker");

        tables.forEach(table -> this.tabbedPane.addTab(table.getName(), new DbTableFakePane(table).getPane()));
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return this.rootPanel;
    }
}
