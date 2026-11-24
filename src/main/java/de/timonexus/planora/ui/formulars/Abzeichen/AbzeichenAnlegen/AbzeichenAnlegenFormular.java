package de.timonexus.planora.ui.formulars.Abzeichen.AbzeichenAnlegen;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Abzeichen;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.DefaultInputField;
import de.timonexus.planora.ui.formulars.Formular;
import de.timonexus.planora.ui.formulars.FormularButton;
import de.timonexus.planora.ui.formulars.FormularHeader;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class AbzeichenAnlegenFormular extends RoundedPanel implements Formular, Component{

    // attribute
    private final Runnable onClose;
    private final FormularHeader header;
    private final FormularButton btnSpeichern;

    private final JPanel inputBase;
    private final DefaultInputField inputID;
    private final DefaultInputField inputName;

    private final DefaultPageService service;

    private Model model;
    private JPanel firstInputLine;

    // constructor
    public AbzeichenAnlegenFormular(DefaultPageService nService, Runnable nOnClose){
        this.service = nService;
        this.onClose = nOnClose;
        this.header = new FormularHeader("Neues Abzeichen", this.onClose);
        this.btnSpeichern = new FormularButton(this::safe);

        this.inputBase = new JPanel();
        this.firstInputLine = new JPanel();
        this.inputID = new DefaultInputField("ID", "z.B. 01", 60);
        this.inputName = new DefaultInputField("AbzeichenName", "z.B. Max", Integer.MAX_VALUE);
    }

    @Override
    public void designComponent() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(440, 350));
        this.setBackground(Colors.APP_BAR.getColor());
        this.setRadius(15);
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    @Override
    public void skinParts() {
        skinInputBase();
        skinFirstInputLine();
    }

    @Override
    public void addParts() {
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.inputBase, BorderLayout.CENTER);
        this.add(this.btnSpeichern, BorderLayout.SOUTH);
    }

    @Override
    public void refresh() {
    }

    @Override
    public Model getData() {
        this.model = new Abzeichen(
            this.inputID.getContent().isEmpty()
                ? 0
                : Integer.parseInt(this.inputID.getContent()),
            this.inputName.getContent(), 0
        );
        return this.model;
    }

    private void skinInputBase(){
        this.inputBase.setOpaque(false);
        this.inputBase.setLayout(new BoxLayout(this.inputBase, BoxLayout.Y_AXIS));

        this.inputBase.add(Box.createVerticalStrut(20));
        this.inputBase.add(this.firstInputLine);
    }
    
    private void skinFirstInputLine(){
        this.firstInputLine = skinInputLines(firstInputLine);

        this.firstInputLine.add(this.inputID);
        this.firstInputLine.add(Box.createHorizontalStrut(10));
        this.firstInputLine.add(this.inputName);
    }

    private JPanel skinInputLines(JPanel nInputLine){
        nInputLine.setOpaque(false);
        nInputLine.setLayout(new BoxLayout(nInputLine, BoxLayout.X_AXIS));
        nInputLine.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        nInputLine.setAlignmentX(LEFT_ALIGNMENT);

        return nInputLine;
    }

    private void fillFormular(){
        Abzeichen modeL_temp = (Abzeichen) this.model;
        this.inputID.setText(String.valueOf(modeL_temp.getID()));
        this.inputName.setText(modeL_temp.getAbzeichenName());
    }

    public void close(){
        onClose.run();
    }

	private void safe(){
		this.service.safe(this.getData());
        this.close();
	}

    public void setData(Model nModel){
        this.model = nModel;
        fillFormular();
    }
}
