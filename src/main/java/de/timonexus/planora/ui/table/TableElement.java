package de.timonexus.planora.ui.table;

public class TableElement {
    
    // attributes
    private final TableObject defaultTableObject;
    private String columnTitle;
    private final int columnID;
    private final int minWidth;
    private final int maxWidth;
    private int width;

    // cosntructor
    public TableElement(TableObject nDefaultTableObject, String nColumnTitle, int nColumnID, int nWidth, int nMinWidth, int nMaxWidth){
        this.defaultTableObject = nDefaultTableObject;
        this.columnTitle = nColumnTitle;
        this.columnID = nColumnID;
        this.width = nWidth;
        this.minWidth = nMinWidth;
        this.maxWidth = nMaxWidth;
    }

    // getter
    public int getColumnID() {
        return columnID;
    }
    public String getValue() {
        return columnTitle;
    }
    public TableObject getDefaultTableObject() {
        return defaultTableObject;
    }
    public int getMaxWidth() {
        return maxWidth;
    }
    public int getMinWidth() {
        return minWidth;
    }
    public int getWidth() {
        return width;
    }

    // setter
    public void setWidth(int width) {
        this.width = width;
    }
    public void setValue(String columnTitle) {
        this.columnTitle = columnTitle;
    }
}
