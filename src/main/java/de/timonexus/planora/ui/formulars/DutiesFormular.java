package de.timonexus.planora.ui.formulars;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;
import de.timonexus.planora.models.tableModels.utilTables.DienstAusbilder_UTM;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.service.utilServices.DienstAusbilder_US;
import de.timonexus.planora.ui.table.Table;
import de.timonexus.planora.utils.RoundedPanel;
import de.timonexus.planora.utils.enums.Colors;

public class DutiesFormular extends RoundedPanel implements Formular{
    
    // attributes
    private final Runnable onClose;
    private final FormularHeader header;
    private final FormularButton btnSpeichern;

    private final JPanel inputBase;
    private final DefaultInputField inputID;
    private final DefaultInputField inputDate;
    private final DefaultInputField inputTimeGroße;
    private final DefaultInputField inputTimeKleine;

    private JPanel firstInputLine;
    private JPanel secondInputLine;

    private Table table;

    private Model model;

    // constructor
    public DutiesFormular(DefaultPageService nService, Runnable nOnClose){
        this.onClose = nOnClose;
        this.header = new FormularHeader("Neuer Dienst", onClose);
        this.btnSpeichern = new FormularButton(this, nService, onClose);

        this.inputBase = new JPanel();
        this.inputID = new DefaultInputField("ID", "z.B. 01", 60);
        this.inputDate = new DefaultInputField("Datum", "2026-11-19", Integer.MAX_VALUE);
        this.inputTimeGroße = new DefaultInputField("Uhrzeit - Große", "16:47", Integer.MAX_VALUE);
        this.inputTimeKleine = new DefaultInputField("Uhrzeit - Kleine", "16:47", Integer.MAX_VALUE);

        this.firstInputLine = new JPanel();
        this.secondInputLine = new JPanel();

        DienstAusbilder_US dienstAusbilder_Service = new DienstAusbilder_US();
        this.table = new Table(dienstAusbilder_Service.loadAll(), new DienstAusbilder_UTM(), dienstAusbilder_Service);
        this.table.prepareComponent();

        skinComponent();
        skinInputBase();
        skinFirstInputLine();
        skinSecondInputLine();
        addComponents();
    }

    private void skinComponent(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(740, 620));
        this.setBackground(Colors.CARDS.getColor());
        this.setRadius(15);
        this.setRoundedBorder(Colors.TEXT_DISABLED.getColor(), 1, BorderPlacement.OUTSIDE);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    private void addComponents(){
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.inputBase, BorderLayout.CENTER);
        this.add(this.btnSpeichern, BorderLayout.SOUTH);
    }

    public void close(){
        onClose.run();
    }

    private void skinInputBase(){
        this.inputBase.setOpaque(false);
        this.inputBase.setLayout(new BoxLayout(this.inputBase, BoxLayout.Y_AXIS));

        this.inputBase.add(Box.createVerticalStrut(24));
        this.inputBase.add(this.firstInputLine);
        this.inputBase.add(Box.createVerticalStrut(16));
        this.inputBase.add(this.secondInputLine);
        this.inputBase.add(Box.createVerticalStrut(24));
        this.inputBase.add(this.table);
        this.inputBase.add(Box.createVerticalStrut(32));
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
