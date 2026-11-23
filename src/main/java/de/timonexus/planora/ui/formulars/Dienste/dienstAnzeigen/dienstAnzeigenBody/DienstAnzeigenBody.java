package de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen.dienstAnzeigenBody;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen.dienstAnzeigenBody.elements.DAB_Datum;

public class DienstAnzeigenBody extends JPanel implements Component{

    // attributes
    private final Model model;
    private final DAB_Datum datumContainer;

    // constructor
    public DienstAnzeigenBody(Model nModel){
        this.model = nModel;
        this.datumContainer = new DAB_Datum(((Dutie) this.model).getDate());
    }

    @Override
    public void designComponent() {
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void skinParts() {
    }

    @Override
    public void addParts() {
    }

    @Override
    public void prepareComponents() {
        this.datumContainer.prepareComponent();
    }

    @Override
    public void addComponents() {
        this.add(this.datumContainer);
    }

    @Override
    public void refresh() {
    }
    
}
