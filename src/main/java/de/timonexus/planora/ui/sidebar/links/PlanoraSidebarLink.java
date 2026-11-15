package de.timonexus.planora.ui.sidebar.links;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.timonexus.planora.service.Service;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.pages.Pages;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.RoundedPanel.BorderPlacement;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class PlanoraSidebarLink extends JPanel implements Component {

    // Attributes
    private final RoundedPanel basePanel;
    private final JPanel namePanel;
    private final JLabel nameLabel;
    private final JPanel iconPanel;
    private JLabel iconLabel;

    private final Pages page;
    private final Service pageService;

    private boolean active;

    // Constructor
    public PlanoraSidebarLink(Pages nPage, Service nPageService) {
        this.page = nPage;
        this.pageService = nPageService;

        this.basePanel = new RoundedPanel();
        this.namePanel = new JPanel();
        this.nameLabel = new JLabel();
        this.iconPanel = new JPanel();

        this.active = page.isActive();
    }

    // Component design
    @Override
    public void designComponent() {
        setMaximumSize(new Dimension(
            Integer.MAX_VALUE,
            (int) PlanoraSidebarLinkValues.HEIGHT.getValue()
        ));

        setOpaque(false);
        setLayout(new BorderLayout());
    }

    // Component styling
    @Override
    public void skinParts() {
        skinBasePanel();
        skinNamePanel();
        skinNameLabel();
        skinIconPanel();
        skinIconLabel();
    }

    // Add component parts
    @Override
    public void addParts() {
        namePanel.add(nameLabel, BorderLayout.CENTER);
        iconPanel.add(iconLabel, BorderLayout.CENTER);

        basePanel.add(iconPanel, BorderLayout.WEST);
        basePanel.add(namePanel, BorderLayout.CENTER);

        add(basePanel, BorderLayout.CENTER);
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    // Base panel styling
    private void skinBasePanel() {
        basePanel.setRadius(15);
        basePanel.setOpaque(false);
        basePanel.setLayout(new BorderLayout());
        basePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        updateActiveMode();

        addMouseListeners();
    }

    // Name panel styling
    private void skinNamePanel() {
        namePanel.setPreferredSize(new Dimension(140, 20));
        namePanel.setLayout(new BorderLayout());
        namePanel.setOpaque(false);
    }

    // Name label styling
    private void skinNameLabel() {
        nameLabel.setFont(Fonts.TEXT.loadFont());
        nameLabel.setText(page.getName());
    }

    // Icon panel styling
    private void skinIconPanel() {
        iconPanel.setPreferredSize(new Dimension(55, 50));
        iconPanel.setLayout(new BorderLayout());
        iconPanel.setOpaque(false);
    }

    // Icon label styling
    private void skinIconLabel() {
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    // Update active mode
    private void updateActiveMode() {
        if (active) {
            basePanel.setBackground(Colors.PRIMARY.getColor());
            basePanel.setRoundedBorder(
                    Colors.PRIMARY.getColor(), 0, BorderPlacement.OUTSIDE
            );
            nameLabel.setForeground(Colors.BASE.getColor());
            iconLabel = page.getIconLabel_dark();
        } else {
            basePanel.setBackground(Colors.APP_BAR.getColor());
            basePanel.setRoundedBorder(
                    Colors.TEXT_DISABLED.getColor(), 0, BorderPlacement.OUTSIDE
            );
            nameLabel.setForeground(Colors.TEXT.getColor());
            iconLabel = page.getIconLabel_bright();
        }

        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setVerticalAlignment(SwingConstants.CENTER);

        iconPanel.removeAll();
        iconPanel.add(iconLabel, BorderLayout.CENTER);

        iconPanel.revalidate();
        iconPanel.repaint();
    }

    private void addMouseListeners() {
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!active) {
                    basePanel.setRoundedBorder(
                            Colors.TEXT_DISABLED.getColor(),
                            1,
                            BorderPlacement.OUTSIDE
                    );
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!active) {
                    basePanel.setRoundedBorder(
                            Colors.TEXT_DISABLED.getColor(),
                            0,
                            BorderPlacement.OUTSIDE
                    );
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!active) {
                    basePanel.setBackground(Colors.BASE.getColor());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                updateActiveMode();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                pageService.openPage(page);
            }
        };

        basePanel.addMouseListener(listener);
        namePanel.addMouseListener(listener);
        nameLabel.addMouseListener(listener);
        iconPanel.addMouseListener(listener);
        iconLabel.addMouseListener(listener);
    }

    // Set active mode
    public void setActive(boolean active) {
        this.active = active;
        updateActiveMode();
    }

    // Getter
    public boolean isActive() {
        return active;
    }

    public Pages getPage() {
        return page;
    }

    // Refresh
    @Override
    public void refresh() {
        setActive(page.isActive());
    }
}