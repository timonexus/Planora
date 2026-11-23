package de.timonexus.planora.utils;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.utils.enums.Icons;

public class Checkbox extends JPanel {

    // attributes
    private boolean isChecked;
    private final DefaultPageService service;
    private final int id;

    private final Consumer<Integer> action;

    private JLabel icon;

    // constructor
    public Checkbox(DefaultPageService nService, int nId, boolean n_isChecked, Consumer<Integer> nAction) {
        this.isChecked = n_isChecked;
        this.id = nId;
        this.service = nService;
        this.action = nAction;

        designPanel();
        createIcon();
        updateIcon();
        registerListener();
    }

    private void designPanel() {
        this.setMinimumSize(new Dimension(20, 20));
        this.setMaximumSize(new Dimension(60, 60));
        this.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void createIcon() {
        this.icon = new JLabel();
        this.icon.setHorizontalAlignment(SwingConstants.CENTER);
        this.icon.setVerticalAlignment(SwingConstants.CENTER);

        this.add(this.icon, BorderLayout.CENTER);
    }

    private void updateIcon() {
        if (this.isChecked) {
            this.icon.setIcon(Icons.CHECKBOX_CHECKED_BRIGHT.getIconLabel().getIcon());
        } else {
            this.icon.setIcon(Icons.CHECKBOX_BRIGHT.getIconLabel().getIcon());
        }

        this.revalidate();
        this.repaint();
    }

    private void registerListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isChecked = !isChecked;

                if (isChecked) {
                    service.addSelectedLine(id);
                } else {
                    service.removeSelectedLine(id);
                }

                updateIcon();
                service.refreshTable();
            }
        });

        this.icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action.accept(id);
            }
        });
    }



    // getter
    public boolean isChecked() {
        return this.isChecked;
    }

    // setter
    public void setIsChecked(boolean n_isChecked) {
        this.isChecked = n_isChecked;
        updateIcon();
    }
}