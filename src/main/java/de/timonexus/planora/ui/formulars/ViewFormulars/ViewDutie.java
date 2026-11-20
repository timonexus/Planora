package de.timonexus.planora.ui.formulars.ViewFormulars;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.timonexus.planora.models.Dutie;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.FormularHeader;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class ViewDutie extends RoundedPanel implements Formular{

    // attributes
    private final Runnable onClose;
    private final FormularHeader header;

    private final Model model;

    // constructor
    public ViewDutie(DefaultPageService nService, Runnable nOnClose, Model nModel){
        this.onClose = nOnClose;
        this.header = new FormularHeader("Dienst", nOnClose);
        this.model = nModel;

        skinComponent();
        addComponents();
    }

    private void skinComponent(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(440, 320));
        this.setBackground(Colors.APP_BAR.getColor());
        this.setRadius(15);
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private JPanel skinModelBody(){
        JPanel basePanel = new JPanel();
        basePanel.setOpaque(false);
        basePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        basePanel.setLayout(new BorderLayout());

        RoundedPanel viewPanel = new RoundedPanel();
        viewPanel.setOpaque(false);
        viewPanel.setBackground(Colors.APP_BAR.getColor());
        viewPanel.setSideBorder(Colors.TEXT_DISABLED.getColor(), 1, Side.TOP, Side.BOTTOM);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));

        JPanel datePanel = informationPanel("Datum: " + ((Dutie) this.model).getDate());
        JPanel time_kleinen_Panel = informationPanel("Zeit (kleinen): " + ((Dutie) this.model).getUhrzeit_kleine());
        JPanel time_große_Panel = informationPanel("Zeit (große): " + ((Dutie) this.model).getUhrzeit_große());
        JPanel anzahlBetreuer = informationPanel("Anzahl der Betreuer: " + ((Dutie) this.model).getAnzahlBetreuer());

        viewPanel.add(datePanel);
        viewPanel.add(Box.createVerticalStrut(4));
        viewPanel.add(time_kleinen_Panel);
        viewPanel.add(Box.createVerticalStrut(4));
        viewPanel.add(time_große_Panel);
        viewPanel.add(Box.createVerticalStrut(4));
        viewPanel.add(anzahlBetreuer);

        basePanel.add(viewPanel, BorderLayout.CENTER);

        return basePanel;
    }

    private JPanel informationPanel(String nText){
        JPanel datePanel = new JPanel();
        datePanel.setPreferredSize(new Dimension(0, 50));
        datePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        datePanel.setOpaque(false);
        datePanel.setLayout(new BorderLayout());

        JLabel dateLabel = new JLabel(nText);
        dateLabel.setForeground(Colors.TEXT.getColor());
        dateLabel.setFont(Fonts.TEXT.loadFont());

        datePanel.add(dateLabel, BorderLayout.CENTER);

        return datePanel;
    }

    private void addComponents(){
        this.add(this.header, BorderLayout.NORTH);
        this.add(skinModelBody(), BorderLayout.CENTER);
    }

    public void close(){
        onClose.run();
    }

	@Override
	public Model getData() {
        return null;
	}
}
