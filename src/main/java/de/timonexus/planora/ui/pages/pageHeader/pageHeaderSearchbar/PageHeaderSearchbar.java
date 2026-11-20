package de.timonexus.planora.ui.pages.pageHeader.pageHeaderSearchbar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.event.DocumentEvent;

import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Icons;

public class PageHeaderSearchbar extends JPanel implements Component{

    // attributes
    private final RoundedPanel basePanel;
    private final JPanel iconPanel;
    private final JLabel iconLabel;
    private final JTextField searchField;
    private final Timer searchTimer;
    private final DefaultPageService service;

    // constructor
    public PageHeaderSearchbar(DefaultPageService nService){
        this.service = nService;
        this.basePanel = new RoundedPanel();
        this.iconPanel = new JPanel();
        this.iconLabel = Icons.SEARCH_BRIGHT.getIconLabel();
        this.searchField = new JTextField("Suchen");
        this.searchTimer = new Timer(1000, e -> executeSearch());
    }

	@Override
	public void designComponent() {
        this.setPreferredSize(new Dimension((int) PageHeaderSearchbarValues.WIDTH.getValue(), (int) PageHeaderSearchbarValues.HEIGHT.getValue()));
        this.setBorder((Border) PageHeaderSearchbarValues.BORDER.getValue());
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
	}

	@Override
	public void skinParts() {
        skinBasePanel();
        skinIconPanel();
        skinIconLabel();
        skinSearchField();
        skinSearchTimer();

        configureHoverListener();
	}

	@Override
	public void addParts() {

        // iconPanel
        this.iconPanel.add(this.iconLabel, BorderLayout.CENTER);

        // basePanel
        this.basePanel.add(this.iconPanel, BorderLayout.WEST);
        this.basePanel.add(this.searchField, BorderLayout.CENTER);

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
        this.basePanel.setBackground(Colors.MENUES.getColor());
        this.basePanel.setRadius(15);
        this.basePanel.setLayout(new BorderLayout());
    }

    private void skinIconPanel(){
        this.iconPanel.setPreferredSize(new Dimension(45, 45));
        this.iconPanel.setOpaque(false);
        this.iconPanel.setLayout(new BorderLayout());
    }

    private void skinIconLabel(){
        this.iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.iconLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void skinSearchField(){
        searchField.setOpaque(false);
        searchField.setForeground(Colors.TEXT_SECONDARY.getColor());
        searchField.setCaretColor(Colors.TEXT.getColor());
        searchField.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
        searchField.setFont(searchField.getFont().deriveFont(14f));

        configureSearchFieldListener();
    }

    private void skinSearchTimer(){
        searchTimer.setRepeats(false);
    }

    private void configureSearchFieldListener(){
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Suchen")) {
                    searchField.setText("");
                    searchField.setForeground(Colors.TEXT.getColor());
                }

                basePanel.setRoundedBorder(Colors.TEXT.getColor(), 1, RoundedPanel.BorderPlacement.OUTSIDE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isBlank()) {
                    searchField.setText("Suchen");
                    searchField.setForeground(Colors.TEXT_DISABLED.getColor());
                    searchTimer.stop();
                }

                basePanel.setRoundedBorder(Colors.TEXT.getColor(), 0, RoundedPanel.BorderPlacement.OUTSIDE);
            }
        });

        // Auf Änderungen im Textfeld reagieren
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            private void handleChange() {
                String text = searchField.getText();

                if (text.equals("Suchen")) {
                    searchTimer.stop();
                    return;
                }

                if (text.isBlank()) {
                    searchTimer.stop();
                    service.refreshTable();
                    return;
                }

                searchTimer.restart();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleChange();
            }
        });

        // Enter führt die Suche sofort aus
        searchField.addActionListener(e -> {
            searchTimer.stop();
            executeSearch();
        });

    }

    private void executeSearch(){
        this.service.search(this.searchField.getText());
    }
    
    private void configureHoverListener() {
        MouseAdapter hoverListener = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                basePanel.setRoundedBorder(
                        Colors.TEXT_DISABLED.getColor(),
                        1,
                        RoundedPanel.BorderPlacement.OUTSIDE
                );
            }

            @Override
            public void mouseExited(MouseEvent e) {
                basePanel.setRoundedBorder(
                        Colors.TEXT_DISABLED.getColor(),
                        0,
                        RoundedPanel.BorderPlacement.OUTSIDE
                );
            }
        };

        basePanel.addMouseListener(hoverListener);
        iconPanel.addMouseListener(hoverListener);
        iconLabel.addMouseListener(hoverListener);
        searchField.addMouseListener(hoverListener);
    }
}
