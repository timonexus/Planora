package de.timonexus.planora.ui.sidebar.links;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;
import de.timonexus.planora.utils.enums.Colors;

public class PlanoraSidebarLink extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final JPanel namePanel;
    private final JLabel nameLabel;
    private final JPanel iconPanel;
    private final JLabel iconLabel;
    private final Pages page;
    private final Service pageService;

    // constructor
    public PlanoraSidebarLink(Pages nPage, Service nPageService){
        this.page = nPage;
        this.pageService = nPageService;

        this.basePanel = new RoundedPanel();
        this.nameLabel = new JLabel();
        this.namePanel = new JPanel();
        this.iconPanel = new JPanel();
        this.iconLabel = page.getIconLabel();

    }

	@Override
	public void designComponent() {
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int) PlanoraSidebarLinkValues.HEIGHT.getValue()));
        this.setOpaque((boolean) PlanoraSidebarLinkValues.OPAQUE.getValue());
        this.setLayout(new BorderLayout());
	}

	@Override
	public void skinParts() {
        skinBasePanel();
        skinNamePanel();
        skinNameLabel();
        skinIconPanel();
        skinIconLabel();
	}

	@Override
	public void addParts() {
        // namePanel
        this.namePanel.add(this.nameLabel, BorderLayout.CENTER);

        // iconLabel
        this.iconPanel.add(this.iconLabel, BorderLayout.CENTER);

        // basePanel
        this.basePanel.add(namePanel, BorderLayout.EAST);
        this.basePanel.add(iconPanel, BorderLayout.WEST);

        this.add(basePanel, BorderLayout.CENTER);
	}

	@Override
	public void prepareComponents() {
	}

	@Override
	public void addComponents() {
	}

    private void skinBasePanel(){
        this.basePanel.setRadius(15);
        this.basePanel.setOpaque(false);
        this.basePanel.setBackground(Colors.APP_BAR.getColor());
        this.basePanel.setLayout(new BorderLayout());

        this.basePanel.addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseEntered(MouseEvent e){
                basePanel.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
            }
            @Override 
            public void mouseExited(MouseEvent e){
                basePanel.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 0, BorderPlacement.OUTSIDE);
            }
            @Override 
            public void mousePressed(MouseEvent e){
                basePanel.setBackground(Colors.CARDS.getColor());
            }
            @Override 
            public void mouseReleased(MouseEvent e){
                basePanel.setBackground(Colors.APP_BAR.getColor());
            }
            @Override 
            public void mouseClicked(MouseEvent e){
                basePanel.setBackground(Colors.PRIMARY.getColor());
                pageService.openPage(page);
            }
        });

        this.basePanel.setCursor(new java.awt.Cursor(
            java.awt.Cursor.HAND_CURSOR
        ));
    }

    private void skinNamePanel(){
        this.namePanel.setPreferredSize(new Dimension(140, 20));
        this.namePanel.setLayout(new BorderLayout());
        this.namePanel.setOpaque(false);
    }

    private void skinNameLabel(){
        this.nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.nameLabel.setForeground(Colors.TEXT.getColor());
        this.nameLabel.setText(page.getName());
    }

    private void skinIconPanel(){
        this.iconPanel.setPreferredSize(new Dimension(55, 50));
        this.iconPanel.setOpaque(false);
        this.iconPanel.setLayout(new BorderLayout());
    }

    private void skinIconLabel(){
        this.iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.iconLabel.setVerticalAlignment(SwingConstants.CENTER);
    }
    
}
