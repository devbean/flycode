package org.galaxyworld.flycode.action;

import com.intellij.database.psi.DbElement;
import com.intellij.database.psi.DbTable;
import com.intellij.database.view.DatabaseView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.galaxyworld.flycode.model.DatabaseTable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DbTableAction extends AnAction {

    /**
     * Do something with selected tables.
     * @param tables Maybe empty.
     * @param project Project related to this action.
     */
    abstract void doWithSelectedDbTables(@NotNull List<DatabaseTable> tables, @NotNull Project project);

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Project project = getEventProject(e);
        if (project == null) {
            return;
        }
        List<DatabaseTable> tables = DatabaseView.getSelectedElements(e.getDataContext(), DbElement.class)
                .stream()
                .filter(dbElement -> dbElement instanceof DbTable)
                .map(dbElement -> (DbTable) dbElement)
                .map(DatabaseTable::new)
                .collect(Collectors.toList());
        doWithSelectedDbTables(tables, project);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Project project = getEventProject(e);
        if (project == null) {
            return;
        }
        DatabaseView view = DatabaseView.DATABASE_VIEW_KEY.getData(e.getDataContext());
        if (view == null) {
            e.getPresentation().setEnabledAndVisible(false);
        } else {
            boolean hasTable = DatabaseView.getSelectedElements(e.getDataContext(), DbElement.class)
                    .stream()
                    .anyMatch(dbElement -> dbElement instanceof DbTable);
            e.getPresentation().setEnabledAndVisible(hasTable);
        }
    }

}
