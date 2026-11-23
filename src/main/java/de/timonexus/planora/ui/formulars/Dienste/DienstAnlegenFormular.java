package de.timonexus.planora.ui.formulars.Dienste;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.FormularHeader;
import de.timonexus.planora.ui.formulars.Dienste.dienstAnlegenBody.DienstAnlegenBody;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class DienstAnlegenFormular extends RoundedPanel implements Formular, Component{

    // attributes
    private final Runnable onClose;
    private final FormularHeader header;
    private final DienstAnlegenBody body;

    // constructor
    public DienstAnlegenFormular(DefaultPageService nService, Runnable nOnClose){
        this.onClose = nOnClose;
        this.header = new FormularHeader("Neuer Dienst", this.onClose);
        this.body = new DienstAnlegenBody(nService);
    }

	public void setData(Model nModel){
		this.body.setData(nModel);
	}

	@Override
	public Model getData() {
        return null;
	}

	@Override
	public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(440, 480));
        this.setBackground(Colors.APP_BAR.getColor());
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
