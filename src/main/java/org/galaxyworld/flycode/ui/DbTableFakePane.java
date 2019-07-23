package org.galaxyworld.flycode.ui;

import org.galaxyworld.flycode.model.DatabaseTable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DbTableFakePane {

    private DatabaseTable table;

    private JPanel rootPanel;

    public DbTableFakePane(@NotNull DatabaseTable table) {
        this.table = table;
    }

    public JPanel getPane() {
        return this.rootPanel;
    }
}
