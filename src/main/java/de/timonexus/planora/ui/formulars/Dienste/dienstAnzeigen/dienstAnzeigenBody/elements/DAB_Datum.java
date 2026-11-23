package de.timonexus.planora.ui.formulars.Dienste.dienstAnzeigen.dienstAnzeigenBody.elements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class DAB_Datum extends RoundedPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final JPanel panelDatum;
    private final JLabel labelDatum;

    private final JPanel panelTitle;
    private final JLabel labelTitle;

    // attributes
    public DAB_Datum(String nDatum){
        this.basePanel = new RoundedPanel();

        this.panelDatum = new JPanel();
        this.labelDatum = new JLabel(nDatum);

        this.panelTitle = new JPanel();
        this.labelTitle = new JLabel("Datum");
    }

    @Override
    public void designComponent() {
        this.setBackground(Colors.APP_BAR.getColor());
        this.setPreferredSize(new Dimension(Integer.MAX_VALUE, 70));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setRadius(10);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void skinParts() {
        skinBasePanel();
        skinPanelDatum();
        skinLabelDatum();
        skinLabelTitle();
        skinPanelTitle();
    }

    @Override
    public void addParts() {
        this.panelTitle.add(this.labelTitle, BorderLayout.CENTER);
        this.panelDatum.add(this.labelDatum, BorderLayout.CENTER);

        this.basePanel.add(this.panelTitle, BorderLayout.SOUTH);
        this.basePanel.add(this.panelDatum, BorderLayout.CENTER);

        this.add(this.basePanel, BorderLayout.CENTER);
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void refresh() {
    }

    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.APP_BAR.getColor());
        this.basePanel.setSideBorder(Colors.PRIMARY.getColor(), 3, Side.LEFT);
        this.basePanel.setLayout(new BorderLayout());
    }

    private void skinPanelDatum(){
        this.panelDatum.setOpaque(false);
        this.panelDatum.setLayout(new BorderLayout());
        this.panelDatum.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    }

    private void skinLabelDatum(){
        this.labelDatum.setForeground(Colors.TEXT.getColor());
        this.labelDatum.setFont(Fonts.TEXT_SECOND.loadFont());
        this.labelDatum.setFont(new Font(Fonts.TEXT_SECOND.loadFont().getName(), Fonts.TEXT_SECOND.loadFont().getStyle(), 18));
    }

    private void skinPanelTitle(){
        this.panelTitle.setOpaque(false);
        this.panelTitle.setLayout(new BorderLayout());
        this.panelTitle.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    }

    private void skinLabelTitle(){
        this.labelTitle.setForeground(Colors.TEXT_SECONDARY.getColor());
        this.labelTitle.setFont(Fonts.TEXT.loadFont());
        this.labelTitle.setFont(new Font(Fonts.TEXT.loadFont().getName(), Fonts.TEXT.loadFont().getStyle(), 12));
    }
    
}
