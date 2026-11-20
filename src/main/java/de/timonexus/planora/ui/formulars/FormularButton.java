package de.timonexus.planora.ui.formulars;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class FormularButton extends JPanel{

    // attributes
    private final RoundedPanel basePanel;
    private final JLabel label;
    private final Runnable onClose;
    private final Formular formular;
    private final DefaultPageService service;

    // constructor
    public FormularButton(Formular nFormular, DefaultPageService nService, Runnable nOnClose){
        this.onClose = nOnClose;
        this.formular = nFormular;
        this.service = nService;

        this.basePanel = new RoundedPanel();
        this.label = new JLabel("Speichern");

        skinComponent();
        skinLabel();
        skinBasePanel();
        addMouseListeners();
        addComponents();
    }

    private void skinComponent(){
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(0, 40));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
    }

    private void skinBasePanel(){
        this.basePanel.setBackground(Colors.PRIMARY.getColor());
        this.basePanel.setRadius(10);
        this.basePanel.setLayout(new BorderLayout());
        this.basePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.basePanel.add(this.label, BorderLayout.CENTER);
    }

    private void skinLabel(){
        this.label.setForeground(Colors.BASE.getColor());
        this.label.setFont(Fonts.TEXT.loadFont());
        this.label.setVerticalAlignment(SwingConstants.CENTER);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void addComponents(){
        this.add(this.basePanel, BorderLayout.CENTER);
    }

    private void addMouseListeners() {
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                    basePanel.setRoundedBorder(
                            Colors.BASE.getColor(),
                            1,
                            BorderPlacement.OUTSIDE
                    );
            }

            @Override
            public void mouseExited(MouseEvent e) {
                    basePanel.setRoundedBorder(
                            Colors.TEXT_DISABLED.getColor(),
                            0,
                            BorderPlacement.OUTSIDE
                    );
            }

            @Override
            public void mousePressed(MouseEvent e) {
                basePanel.setBackground(Colors.TEXT.getColor());

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                skinBasePanel();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                service.safe(formular.getData());
                onClose.run();
            }
        };

        basePanel.addMouseListener(listener);
        label.addMouseListener(listener);
    }
    
}
