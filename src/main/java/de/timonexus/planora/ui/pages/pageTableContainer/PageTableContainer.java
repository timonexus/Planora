package de.timonexus.planora.ui.pages.pageTableContainer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class PageTableContainer extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final JPanel titlePanel;
    private final JLabel titleLabel;

    // constructor
    public PageTableContainer(){
        this.basePanel = new RoundedPanel();
        this.titlePanel = new JPanel();
        this.titleLabel = new JLabel();
    }

	@Override
	public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
    	this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
	}

	@Override
	public void skinParts() {
        skinBasePanel();
        skinTitlePanel();
        skinTitleLabel();
	}

	@Override
	public void addParts() {
        // titlePanel
        this.titlePanel.add(this.titleLabel, BorderLayout.WEST);

        // basePanel
        this.basePanel.add(this.titlePanel, BorderLayout.NORTH);

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
        this.basePanel.setBackground(Colors.CARDS.getColor());
        this.basePanel.setRadius(35);
        this.basePanel.setLayout(new BorderLayout());
    	this.basePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void skinTitlePanel(){
        this.titlePanel.setPreferredSize(new Dimension(20, 50));
        this.titlePanel.setOpaque(false);
        this.titlePanel.setLayout(new BorderLayout());
    }

    private void skinTitleLabel(){
        this.titleLabel.setText("Dienst");
        this.titleLabel.setForeground(Colors.TEXT.getColor());
        this.titleLabel.setVerticalAlignment(SwingConstants.CENTER);
    }
    
}
