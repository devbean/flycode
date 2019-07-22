package org.galaxyworld.flycode.action;

import com.intellij.database.psi.DbTable;
import com.intellij.openapi.project.Project;
import org.galaxyworld.flycode.ui.DbTableFakeWizardDialog;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DbTableFakeAction extends DbTableAction {

    @Override
    void doWithSelectedDbTables(@NotNull List<DbTable> tables, @NotNull Project project) {
        DbTableFakeWizardDialog dialog = new DbTableFakeWizardDialog(project);
        dialog.show();
    }

}
