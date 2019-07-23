package org.galaxyworld.flycode.action;

import com.intellij.openapi.project.Project;
import org.galaxyworld.flycode.model.DatabaseTable;
import org.galaxyworld.flycode.ui.DbTableFakeWizardDialog;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DbTableFakeAction extends DbTableAction {

    @Override
    void doWithSelectedDbTables(@NotNull List<DatabaseTable> tables, @NotNull Project project) {
        System.out.println(tables);
        DbTableFakeWizardDialog dialog = new DbTableFakeWizardDialog(tables, project);
        dialog.show();
    }

}
