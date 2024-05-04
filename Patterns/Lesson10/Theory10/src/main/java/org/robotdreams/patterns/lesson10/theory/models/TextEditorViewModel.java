package org.robotdreams.patterns.lesson10.theory.models;

public class TextEditorViewModel {
    private boolean saveAll;
    private String fontSizePt;
    private int rows;
    private int columns;
    private String tableType;

    public boolean isSaveAll() {
        return saveAll;
    }

    public void setSaveAll(boolean saveAll) {
        this.saveAll = saveAll;
    }

    public String getFontSizePt() {
        return fontSizePt;
    }

    public void setFontSizePt(String fontSizePt) {
        this.fontSizePt = fontSizePt;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
}
