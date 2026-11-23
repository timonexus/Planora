package de.timonexus.planora.ui.formulars.Dienste.dienstAnlegen.dienstAnlegenBody;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.DefaultInputField;

public class FirstStep extends JPanel implements Component{

    // attributes
    private final DefaultInputField inputID;
    private final DefaultInputField inputDate;
    private final DefaultInputField inputTimeGroße;
    private final DefaultInputField inputTimeKleine;

    private JPanel firstInputLine;
    private JPanel secondInputLine;

    private Model model;

    // constructor
    public FirstStep(){
        this.inputID = new DefaultInputField("ID", "z.B. 01", 60);
        this.inputDate = new DefaultInputField("Datum", "19.11.2026", Integer.MAX_VALUE);
        this.inputTimeGroße = new DefaultInputField("Uhrzeit - Große", "16:47", Integer.MAX_VALUE);
        this.inputTimeKleine = new DefaultInputField("Uhrzeit - Kleine", "16:47", Integer.MAX_VALUE);

        this.firstInputLine = new JPanel();
        this.secondInputLine = new JPanel();
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	public void skinParts() {
        this.skinFirstInputLine();
        this.skinSecondInputLine();
	}

	@Override
	public void addParts() {
        this.add(Box.createVerticalStrut(24));
        this.add(this.firstInputLine);
        this.add(Box.createVerticalStrut(16));
        this.add(this.secondInputLine);
        this.add(Box.createVerticalStrut(32));
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

    private void skinFirstInputLine(){
        this.firstInputLine = skinInputLines(firstInputLine);

        this.firstInputLine.add(this.inputID);
        this.firstInputLine.add(Box.createHorizontalStrut(10));
        this.firstInputLine.add(this.inputDate);
    }

    private void skinSecondInputLine(){
        this.secondInputLine = skinInputLines(secondInputLine);

        this.secondInputLine.add(this.inputTimeKleine);
        this.secondInputLine.add(Box.createHorizontalStrut(10));
        this.secondInputLine.add(this.inputTimeGroße);
    }

    private JPanel skinInputLines(JPanel nInputLine){
        nInputLine.setOpaque(false);
        nInputLine.setLayout(new BoxLayout(nInputLine, BoxLayout.X_AXIS));
        nInputLine.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        nInputLine.setAlignmentX(CENTER_ALIGNMENT);

        return nInputLine;
    }

    private void fillFormular(){
        Dutie dutie = (Dutie) this.model;
        this.inputID.setText(String.valueOf(dutie.getID()));
        this.inputDate.setText(dutie.getDate());
        this.inputTimeKleine.setText(dutie.getUhrzeit_kleine());
        this.inputTimeGroße.setText(dutie.getUhrzeit_große());
    }

    public Model getData() {
        this.model = new Dutie(
            this.inputID.getContent().isEmpty()
                ? 0
                : Integer.parseInt(this.inputID.getContent()),
            this.inputDate.getContent(),
            this.inputTimeKleine.getContent(),
            this.inputTimeGroße.getContent(),
            ""
        );
        return this.model;
    }

    public void setData(Model nModel){
        this.model = nModel;
        fillFormular();
    }
    
}
