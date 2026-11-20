package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public enum TableObject {
    
    PANEL,
    CHECKBOX;

    public JPanel getObject(String nValue, DefaultPageService nService, int nLineId, boolean n_isChecked){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        switch (this) {
            case PANEL:
                JLabel label = new JLabel(nValue);
                label.setForeground(Colors.TEXT.getColor());
                label.setFont(Fonts.TEXT.loadFont());
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.addMouseListener(new MouseAdapter() {

                    private Timer clickTimer;

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (e.getClickCount() == 1) {

                            if (clickTimer != null) {
                                clickTimer.stop();
                            }

                            clickTimer = new Timer(
                                250,
                                event -> {
                                    if (n_isChecked) {
                                        nService.removeSelectedLine(nLineId);
                                    } else {
                                        nService.addSelectedLine(nLineId);
                                    }

                                    nService.refreshTable();
                                }
                            );

                            clickTimer.setRepeats(false);
                            clickTimer.start();

                        } else if (e.getClickCount() == 2) {

                            if (clickTimer != null) {
                                clickTimer.stop();
                            }

                            nService.showModel(nLineId);
                        }
                    }
                });
                panel.add(label, BorderLayout.CENTER);
                break;
            case CHECKBOX:
                Checkbox checkbox = new Checkbox(nService, nLineId, n_isChecked);
                panel.add(checkbox, BorderLayout.CENTER);
                break;
        }

        return panel;
    }
}
