
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

    // Attributes
    private boolean isChecked;

    private final DefaultPageService service;
    private final int id;
    private final Consumer<Integer> action;

    private JLabel icon;

    // Constructor
    public Checkbox(
            DefaultPageService nService,
            int nId,
            boolean nIsChecked,
            Consumer<Integer> nAction
    ) {
        this.isChecked = nIsChecked;
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
            this.icon.setIcon(
                Icons.CHECKBOX_CHECKED_BRIGHT.getIconLabel().getIcon()
            );
        } else {
            this.icon.setIcon(
                Icons.CHECKBOX_BRIGHT.getIconLabel().getIcon()
            );
        }

        this.revalidate();
        this.repaint();
    }

    private void registerListener() {
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick();
            }
        };

        this.addMouseListener(listener);
        this.icon.addMouseListener(listener);
    }

    private void handleClick() {

        this.isChecked = !this.isChecked;

        // Custom action, if provided
        if (this.action != null) {
            this.action.accept(this.id);
        } else {
            updateSelection();
        }

        updateIcon();

        if (this.service != null) {
            this.service.refreshTable();
        }
    }

    private void updateSelection() {
        if (this.service == null) {
            return;
        }

        if (this.isChecked) {
            this.service.addSelectedLine(this.id);
            if(this.id == -1) this.service.addAllLines();
        } else {
            this.service.removeSelectedLine(this.id);
            if(this.id == -1) this.service.removeAllLines();
        }
    }

    // Getter
    public boolean isChecked() {
        return this.isChecked;
    }

    // Setter
    public void setIsChecked(boolean nIsChecked) {
        this.isChecked = nIsChecked;
        updateIcon();
    }
}
