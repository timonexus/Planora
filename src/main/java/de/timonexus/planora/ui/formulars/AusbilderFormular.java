package de.timonexus.planora.ui.formulars;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class AusbilderFormular extends RoundedPanel implements Formular{

    // attributes
    private final Runnable onClose;
    private final FormularHeader header;
    private final FormularButton btnSpeichern;

    private final JPanel inputBase;
    private final DefaultInputField inputID;
    private final DefaultInputField inputName;

    private Model model;

    private JPanel firstInputLine;

    // constructor
    public AusbilderFormular(DefaultPageService nService, Runnable nOnClose){
        this.onClose = nOnClose;
        this.header = new FormularHeader("Neuer Dienst", onClose);
        this.btnSpeichern = new FormularButton(this, nService, onClose);

        this.inputBase = new JPanel();
        this.firstInputLine = new JPanel();
        this.inputID = new DefaultInputField("ID", "z.B. 01", 60);
        this.inputName = new DefaultInputField("Name", "z.B. Max", Integer.MAX_VALUE);

        skinComponent();
        skinInputBase();
        skinFirstInputLine();
        addComponents();
    }

    private void skinComponent(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(440, 320));
        this.setBackground(Colors.APP_BAR.getColor());
        this.setRadius(15);
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void addComponents(){
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.inputBase, BorderLayout.CENTER);
        this.add(this.btnSpeichern, BorderLayout.SOUTH);
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
        Ausbilder modeL_temp = (Ausbilder) this.model;
        this.inputID.setText(String.valueOf(modeL_temp.getID()));
        this.inputName.setText(modeL_temp.getName());
    }

    public void close(){
        onClose.run();
    }

	@Override
	public Model getData() {
        this.model = new Ausbilder(
            this.inputID.getContent().isEmpty()
                ? 0
                : Integer.parseInt(this.inputID.getContent()),
            this.inputName.getContent()
        );
        return this.model;
	}

    public void setData(Model nModel){
        this.model = nModel;
        fillFormular();
    }
    
}
