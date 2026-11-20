package de.timonexus.planora.ui.formulars;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class DefaultInputField extends JPanel{

    // attributes
    private final JPanel labelPanel;
    private final JLabel labelLabel;

    private final JPanel inputBase;
    private final RoundedPanel inputPanel;
    private final JTextField searchField;

    private String placeholder;
    private int width;

    
    public DefaultInputField(String nTitle, String nPlaceHolder, int nWidth){
        this.placeholder = nPlaceHolder;
        this.width = nWidth;

        this.labelPanel = new JPanel();
        this.labelLabel = new JLabel(nTitle);

        this.inputBase = new JPanel();
        this.inputPanel = new RoundedPanel();
        this.searchField = new JTextField(nPlaceHolder);

        skinComponent();
        skinLabelPanel();
        skinLabelLabel();
        skinInputBase();
        skinInputPanel();
        skinSearchField();
        addComponents();
    }

    private void skinComponent() {
        this.setOpaque(false);
        this.setPreferredSize( new Dimension(this.width == Integer.MAX_VALUE ? 200 : this.width, 60));
        this.setMaximumSize( new Dimension( this.width == Integer.MAX_VALUE ? Integer.MAX_VALUE : this.width, 60)
        );

        if (this.width != Integer.MAX_VALUE) {
            this.setMinimumSize(new Dimension(this.width, 60));
        }

        this.setLayout(new BorderLayout());
    }

    private void skinLabelPanel(){
        this.labelPanel.setPreferredSize(new Dimension(0, 20));
        this.labelPanel.setLayout(new BorderLayout());
        this.labelPanel.setOpaque(false);
        this.labelPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    private void skinLabelLabel(){
        this.labelLabel.setForeground(Colors.TEXT.getColor());
        this.labelLabel.setFont(Fonts.TEXT.loadFont());
        this.labelLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void addComponents(){
        this.labelPanel.add(this.labelLabel, BorderLayout.CENTER);
        this.add(this.labelPanel, BorderLayout.NORTH);
        this.add(this.inputBase, BorderLayout.CENTER);
    }

    private void skinInputBase(){
        this.inputBase.setLayout(new BorderLayout());
        this.inputBase.setOpaque(false);
        this.inputBase.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));

        this.inputBase.add(this.inputPanel, BorderLayout.CENTER);
    }

    private void skinInputPanel(){
        this.inputPanel.setBackground(Colors.DIALOGS.getColor());
        this.inputPanel.setRadius(10);
        this.inputPanel.setLayout(new BorderLayout());

        this.inputPanel.add(this.searchField, BorderLayout.CENTER);
    }

    private void skinSearchField(){
        searchField.setOpaque(false);
        searchField.setForeground(Colors.TEXT_SECONDARY.getColor());
        searchField.setCaretColor(Colors.TEXT.getColor());
        searchField.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
        searchField.setFont(Fonts.TEXT.loadFont());

        configureSearchFieldListener();
    }

    private void configureSearchFieldListener(){
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals(placeholder)) {
                    searchField.setText("");
                    searchField.setForeground(Colors.TEXT.getColor());
                }

                inputPanel.setRoundedBorder(Colors.TEXT.getColor(), 1, RoundedPanel.BorderPlacement.OUTSIDE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isBlank()) {
                    searchField.setText(placeholder);
                    searchField.setForeground(Colors.TEXT_DISABLED.getColor());
                }

                inputPanel.setRoundedBorder(Colors.TEXT.getColor(), 0, RoundedPanel.BorderPlacement.OUTSIDE);
            }
        });

    }

    public void setText(String nText){
        this.searchField.setText(nText);
        this.searchField.setForeground(Colors.TEXT.getColor());
    }

    public String getContent() {
        String content = this.searchField.getText();

        if (content.equals(this.placeholder)) {
            return "";
        }

        return content;
    }
}
