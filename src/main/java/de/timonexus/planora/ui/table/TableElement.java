package de.timonexus.planora.ui.table;

import java.util.function.Consumer;

public class TableElement {
    
    // attributes
    private Object value;
    private final int columnId;
    private final int minWidth;
    private final int maxWidth;
    private int width;
    private final Consumer<Integer> action;

    // constructor
    public TableElement(Object nValue, int nColumnId, int nWidth, int nMinWidth, int nMaxWidth, Consumer<Integer> nAction){
        this.value = nValue;
        this.columnId = nColumnId;
        this.width = nWidth;
        this.minWidth = nMinWidth;
        this.maxWidth = nMaxWidth;
        this.action = nAction;
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
    public Consumer<Integer> getAction() {
        return action;
    }

    // setter
    public void setValue(Object value) {
        this.value = value;
    }
    public void setWidth(int width) {
        this.width = width;
    }
}
