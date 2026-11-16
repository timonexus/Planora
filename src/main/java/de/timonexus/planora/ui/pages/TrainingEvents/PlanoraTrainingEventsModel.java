package de.timonexus.planora.ui.pages.TrainingEvents;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import de.timonexus.planora.ui.table.tableHeader.TableModel;
import de.timonexus.planora.ui.table.tableHeader.tableHeaderElement.TableHeaderElement;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class PlanoraTrainingEventsModel implements TableModel{
    
    private final List<TableHeaderElement> headerElements;

    // constructor
    public PlanoraTrainingEventsModel(){
        this.headerElements = new ArrayList<>();

        setUpHeader();
    }

    // method to setup header
    public void setUpHeader(){
        JLabel idL = new JLabel("ID");
        idL.setForeground(Colors.TEXT.getColor());
        idL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement id = new TableHeaderElement(idL, 20, 20);
        id.prepareComponent();
        this.headerElements.add(id);

        Checkbox checkboxJ = new Checkbox(true);
        TableHeaderElement checkbox = new TableHeaderElement(checkboxJ, 20, 20);
        checkbox.prepareComponent();
        this.headerElements.add(checkbox);

        JLabel nameL = new JLabel("Name");
        nameL.setForeground(Colors.TEXT.getColor());
        nameL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement name = new TableHeaderElement(nameL, 200, Integer.MAX_VALUE);
        name.prepareComponent();
        this.headerElements.add(name);

        JLabel datumL = new JLabel("Datum");
        datumL.setForeground(Colors.TEXT.getColor());
        datumL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement datum = new TableHeaderElement(datumL, 20, Integer.MAX_VALUE);
        datum.prepareComponent();
        this.headerElements.add(datum);
    }

    // getter
    public List<TableHeaderElement> getHeaderElements() {
        return headerElements;
    }
}
