package de.timonexus.planora.ui.formulars.Deletion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class DeletionNotice extends RoundedPanel implements Formular, Component{

    // attributes
    private final DefaultPageService service;
    private final String className;

    private final JPanel titlePanel;
    private final JPanel descriptionPanel;
    private final JPanel buttonPanel;

    // constructor
    public DeletionNotice(DefaultPageService nService, String nClassName){
        this.service = nService;
        this.className = nClassName;

        this.titlePanel = new JPanel();
        this.descriptionPanel = new JPanel();
        this.buttonPanel = new JPanel();
    }

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(350, 210));
        this.setBackground(Colors.CARDS.getColor());
        this.setRadius(20);
        this.setRoundedBorder(Colors.MENUES.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
    }

    @Override
    public void skinParts() {
        skinTitle();
        skinDescription();
        skinButtonPanel();
    }

    @Override
    public void addParts() {
        this.add(this.titlePanel, BorderLayout.NORTH);
        this.add(this.descriptionPanel, BorderLayout.CENTER);
        this.add(this.buttonPanel, BorderLayout.SOUTH);
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

    @Override
    public Model getData() {
        return null;
    }

    private void skinTitle(){
        this.titlePanel.setOpaque(false);
        this.titlePanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
        this.titlePanel.setLayout(new BorderLayout());

        JLabel title = new JLabel(this.className + " löschen?");
        title.setForeground(Colors.TEXT.getColor());
        title.setFont(Fonts.TEXT_SECOND.loadFont());
        title.setOpaque(false);

        this.titlePanel.add(title, BorderLayout.CENTER);
    }

    private void skinDescription() {
        this.descriptionPanel.setOpaque(false);
        this.descriptionPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.descriptionPanel.setLayout(new GridBagLayout());

        JTextPane description = new JTextPane();
        description.setText("Willst du wirklich " + this.service.getSelectedLines().size() + " " + this.className
                + "\nunwiderruflich löschen?");
        description.setFont(Fonts.TEXT.loadFont());
        description.setForeground(Colors.TEXT_SECONDARY.getColor());
        description.setOpaque(false);
        description.setEditable(false);
        description.setFocusable(false);
        description.setBorder(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;                       
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        this.descriptionPanel.add(description, gbc);
    }

    private void skinButtonPanel(){
        JPanel btn_abbrechen = skinDefaultButton("Abbrechen", false);
        btn_abbrechen.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        btn_abbrechen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                service.closeFormular();
            }
        });

        JPanel btn_bestätigen = skinDefaultButton("Löschen", true);
        btn_bestätigen.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        btn_bestätigen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                service.deleteInDatabase();
            }
        });

        this.buttonPanel.setOpaque(false);
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.X_AXIS));
        this.buttonPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE,60));

        this.buttonPanel.add(btn_abbrechen);
        this.buttonPanel.add(btn_bestätigen);

    }

    private JPanel skinDefaultButton(String nText, boolean nIsHighlighted){
        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout());

        RoundedPanel viewPanel = new RoundedPanel();
        viewPanel.setBackground(switchBackgroundColor(nIsHighlighted));
        viewPanel.setRadius(15);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(nText);
        label.setForeground(Colors.TEXT.getColor());
        label.setFont(Fonts.TEXT.loadFont());
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(label, BorderLayout.CENTER);

        basePanel.add(viewPanel, BorderLayout.CENTER);

        return basePanel;
    }

    private Color switchBackgroundColor(boolean nIsHighlighted){
        Color backgroundColor = Colors.APP_BAR.getColor();
        if(nIsHighlighted) backgroundColor = Colors.ERROR.getColor();

        return backgroundColor;
    }
    
}
