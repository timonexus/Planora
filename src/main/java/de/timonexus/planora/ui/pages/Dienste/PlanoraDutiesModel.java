package de.timonexus.planora.ui.pages.Dienste;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import de.timonexus.planora.ui.table.tableHeader.TableModel;
import de.timonexus.planora.ui.table.tableHeader.tableHeaderElement.TableHeaderElement;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class PlanoraDutiesModel implements TableModel{
    
    private final List<TableHeaderElement> headerElements;

    // constructor
    public PlanoraDutiesModel(){
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

        JLabel nameL = new JLabel("Datum");
        nameL.setForeground(Colors.TEXT.getColor());
        nameL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement name = new TableHeaderElement(nameL, 100, 300);
        name.prepareComponent();
        this.headerElements.add(name);

        JLabel datumL = new JLabel("Uhrzeit");
        datumL.setForeground(Colors.TEXT.getColor());
        datumL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement datum = new TableHeaderElement(datumL, 100, 300);
        datum.prepareComponent();
        this.headerElements.add(datum);

        JLabel gruppeL = new JLabel("Gruppe");
        gruppeL.setForeground(Colors.TEXT.getColor());
        gruppeL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement gruppe = new TableHeaderElement(gruppeL, 500, 800);
        gruppe.prepareComponent();
        this.headerElements.add(gruppe);

        JLabel themenL = new JLabel("Themenanzahl");
        themenL.setForeground(Colors.TEXT.getColor());
        themenL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement themen = new TableHeaderElement(themenL, 200, 450);
        themen.prepareComponent();
        this.headerElements.add(themen);

        JLabel ausbilderL = new JLabel("Ausbilder");
        ausbilderL.setForeground(Colors.TEXT.getColor());
        ausbilderL.setFont(Fonts.TEXT.loadFont());
        TableHeaderElement ausbilder = new TableHeaderElement(ausbilderL, 200, Integer.MAX_VALUE);
        ausbilder.prepareComponent();
        this.headerElements.add(ausbilder);
    }

    // getter
    public List<TableHeaderElement> getHeaderElements() {
        return headerElements;
    }
}
