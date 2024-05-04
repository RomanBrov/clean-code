package org.robotdreams.patterns.lesson10.theory.classic01;

import org.robotdreams.patterns.lesson10.theory.auxiliary.ICommandLight;

public class InsertTable implements ICommandLight {
    private final int rows;
    private final int columns;
    private final String tableType;

    public InsertTable(int rows, int columns, String tableType) {
        this.rows = rows;
        this.columns = columns;
        this.tableType = tableType;
    }

    @Override
    public void execute() {
        System.out.printf("Executing %s of size %dx%d%n", InsertTable.class.getSimpleName(), rows, columns);
    }
}
