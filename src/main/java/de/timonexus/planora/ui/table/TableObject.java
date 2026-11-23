package de.timonexus.planora.ui.table;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.utils.Checkbox;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class TableObject {
    
    public static JPanel getObject(Object nValue, DefaultPageService nService, int nLineId, boolean n_isChecked, Consumer<Integer> nAction){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        if(nValue instanceof Boolean){
            Checkbox checkbox = new Checkbox(nService, nLineId,(boolean) nValue, nAction);
            panel.add(checkbox, BorderLayout.CENTER);
        }else{
            panel.add(skinPanel((String) nValue, nService, nLineId, n_isChecked));
        }

        return panel;
    }

    // method for skinning panels
    private static JLabel skinPanel(String nValue, DefaultPageService nService, int nLineId, boolean n_isChecked){
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

        return label;
    }
}
