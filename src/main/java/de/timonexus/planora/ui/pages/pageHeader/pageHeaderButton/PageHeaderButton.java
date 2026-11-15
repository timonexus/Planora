package de.timonexus.planora.ui.pages.pageHeader.pageHeaderButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Icons;

public class PageHeaderButton extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private JLabel iconLabel;
    private Icons icon;
    private boolean highlighted;

    // constructor
    public PageHeaderButton(Icons nIcon, boolean nHighlighted){
        this.basePanel = new RoundedPanel();

        this.icon = nIcon;
        this.highlighted = nHighlighted;

        this.iconLabel = this.icon.getIconLabel();
    }

	@Override
	public void designComponent() {
        this.setMaximumSize(new Dimension((int) PageHeaderButtonValues.WIDTH.getValue(), (int) PageHeaderButtonValues.HEIGHT.getValue()));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
	}

	@Override
	public void skinParts() {
        skinBasePanel();
        skinIconLabel();

        addMouseListeners();
	}

	@Override
	public void addParts() {
        // basePanel
        this.basePanel.add(this.iconLabel, BorderLayout.CENTER);

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
        if(highlighted){
            this.basePanel.setBackground(Colors.PRIMARY.getColor());
        }else{
            this.basePanel.setBackground(Colors.DIALOGS.getColor());
        }
        this.basePanel.setRadius(15);
        this.basePanel.setLayout(new BorderLayout());
    }

    private void skinIconLabel(){
        this.iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.iconLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void addMouseListeners() {
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if(highlighted){
                    basePanel.setRoundedBorder(
                            Colors.BASE.getColor(),
                            1,
                            BorderPlacement.OUTSIDE
                    );
                } else {
                    basePanel.setRoundedBorder(
                            Colors.TEXT_DISABLED.getColor(),
                            1,
                            BorderPlacement.OUTSIDE
                    );
                }
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
                if(highlighted){
                    basePanel.setBackground(Colors.TEXT.getColor());
                } else{
                    basePanel.setBackground(Colors.BASE.getColor());
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                skinBasePanel();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Geklickt");
            }
        };

        basePanel.addMouseListener(listener);
        iconLabel.addMouseListener(listener);
    }
    
}
