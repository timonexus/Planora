package de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.FormularHeader;
import de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen.dienstAnzeigenBody.DienstAnzeigenBody;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class DienstAnzeigenFormular extends RoundedPanel implements Formular, Component{

    // attributes
    private final Runnable onClose;
    private final FormularHeader header;
	private final DienstAnzeigenBody body;
    private final Dutie model;

    // constructor
    public DienstAnzeigenFormular(DefaultPageService nService, Runnable nOnClose, Model nModel){
        this.onClose = nOnClose;
        this.header = new FormularHeader("Neuer Dienst", this.onClose);
        this.model = (Dutie) nModel;
		this.body = new DienstAnzeigenBody(this.model);

        prepareComponent();
    }

	@Override
	public Model getData() {
        return null;
	}

	@Override
	public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(440, 480));
        this.setBackground(Colors.CARDS.getColor());
        this.setRadius(15);
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
		this.body.prepareComponent();
	}

	@Override
	public void addComponents() {
        this.add(this.header, BorderLayout.NORTH);
		this.add(this.body, BorderLayout.CENTER);
	}

	@Override
	public void refresh() {
	}
    
}
