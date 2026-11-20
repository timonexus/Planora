package de.timonexus.planora.ui.table;

public class TableElement {
    
    // attributes
    private Object value;
    private final int columnId;
    private final int minWidth;
    private final int maxWidth;
    private int width;

    // constructor
    public TableElement(Object nValue, int nColumnId, int nWidth, int nMinWidth, int nMaxWidth){
        this.value = nValue;
        this.columnId = nColumnId;
        this.width = nWidth;
        this.minWidth = nMinWidth;
        this.maxWidth = nMaxWidth;
    }

    // getter
    public int getColumnId() {
        return columnId;
    }
    public int getMaxWidth() {
        return maxWidth;
    }
    public int getMinWidth() {
        return minWidth;
    }
    public Object getValue() {
        return value;
    }
    public int getWidth() {
        return width;
    }

    // setter
    public void setValue(Object value) {
        this.value = value;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}
