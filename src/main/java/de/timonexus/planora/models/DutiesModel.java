package de.timonexus.planora.models;

import de.timonexus.planora.ui.table.TableColumn;

public class DutiesModel implements Model{

    // attributes
    private TableColumn[] columns;

    // constructor
    public DutiesModel(){
        this.columns = new TableColumn[7];

        defineHeader();
    }

    private void defineHeader(){
        TableColumn checkbox = new TableColumn(defaultCheckbox(), 1, 40, 40, 40);
        TableColumn date = new TableColumn(defaultTextElement("Datum"), 1, 150, 100, 200);
        TableColumn time = new TableColumn(defaultTextElement("Zeit"), 2, 150, 100, 200);
        TableColumn group = new TableColumn(defaultTextElement("Gruppe"), 3, 250, 200, 300);
        TableColumn teacher = new TableColumn(defaultTextElement("Ausbilder"), 4, 300, 200, Integer.MAX_VALUE);
        TableColumn topics = new TableColumn(defaultTextElement("Themenanzahl"), 5, 150, 100, 200);
        TableColumn participation = new TableColumn(defaultTextElement("Anwesenheit"), 6, 150, 100, 200);

        this.columns = new TableColumn[]{checkbox, date, time, group, teacher, topics, participation};
    }

    @Override
    public TableColumn[] getColumns() {
        return this.columns;
    }
    
}
