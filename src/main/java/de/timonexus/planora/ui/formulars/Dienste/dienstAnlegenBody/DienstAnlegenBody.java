package de.timonexus.planora.ui.formulars.Dienste.dienstAnlegenBody;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import de.timonexus.planora.models.Model;
import de.timonexus.planora.service.DefaultPageService;
import de.timonexus.planora.service.Duties.DutiesService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.formulars.FormularButton;
import de.timonexus.planora.utils.StepDisplay;

public class DienstAnlegenBody extends JPanel implements Component{

	// attributes
	private final StepDisplay stepDisplay;
	private final FirstStep firstStep;
	private SecondStep secondStep;

	private final DefaultPageService service;

	private FormularButton button;

	private int step;

	// constructor
	public DienstAnlegenBody(DefaultPageService nService){
		this.service = nService;
		this.stepDisplay = new StepDisplay(3, 1);
		this.firstStep = new FirstStep();
		this.button = new FormularButton(this::safe);

		this.step = 1;
	}

	private void safe(){
		this.service.safe(this.firstStep.getData());
		this.secondStep = new SecondStep(((DutiesService) this.service).getDienstId());
		this.increaseStep();
		this.refresh();
	}

	private void increaseStep(){
		this.step++;
		this.stepDisplay.setCurrentStep(this.step);
	}

	public void setData(Model nModel){
		this.firstStep.setData(nModel);
	}

	@Override
	public void designComponent() {
        this.setOpaque(false);
		this.setLayout(new BorderLayout());
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
		this.stepDisplay.prepareComponent();
		this.firstStep.prepareComponent();
	}

	@Override
	public void addComponents() {
		this.removeAll();

		this.add(this.stepDisplay, BorderLayout.NORTH);
		if(this.step == 1){
			this.add(this.firstStep, BorderLayout.CENTER);
		}else if(this.step == 2){
			this.add(this.secondStep, BorderLayout.CENTER);
		}
		this.add(this.button, BorderLayout.SOUTH);
	}

	@Override
	public void refresh() {
		this.prepareComponent();
	}

	public void setCurrentStep(int nStep){
		this.stepDisplay.setCurrentStep(nStep);
	}
    
}
