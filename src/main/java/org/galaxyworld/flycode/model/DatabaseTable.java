package org.galaxyworld.flycode.model;

import com.intellij.database.psi.DbTable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DatabaseTable {

    @Setter @Getter
    private String name;

    public DatabaseTable(DbTable dbTable) {
        this.name = dbTable.getName();
    }

}
