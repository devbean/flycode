package org.galaxyworld.flycode.ui;

import com.intellij.ui.table.JBTable;
import org.galaxyworld.flycode.model.DatabaseTable;
import org.galaxyworld.flycode.model.DatabaseTableColumn;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class DbTableFakePane {

    private DatabaseTable dbTable;

    private JPanel rootPanel;
    private JBTable table;

    public DbTableFakePane(@NotNull DatabaseTable table) {
        this.dbTable = table;
    }

    public JPanel getPane() {
        return this.rootPanel;
    }

    private void createUIComponents() {
        List<DatabaseTableColumn> columns = this.dbTable.getColumns();
        TableModel tableModel = new DefaultTableModel(new String[] { "Column Name", "Expression" }, columns.size());
        for (int i = 0; i < columns.size(); i++) {
            DatabaseTableColumn column = columns.get(i);
            tableModel.setValueAt(column.getName(), i, 0);
        }
        TableColumnModel tableColumnModel = new DefaultTableColumnModel();
        TableColumn nameColumn = new TableColumn();
        nameColumn.setWidth(120);
        tableColumnModel.addColumn(nameColumn);
        TableColumn fakeExprColumn = new TableColumn();
        tableColumnModel.addColumn(fakeExprColumn);

        this.table = new JBTable(tableModel, tableColumnModel);
    }
}
