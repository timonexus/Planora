package de.timonexus.planora.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Fonts;

public class StepDisplay extends JPanel implements Component{

    // attributes
    private final int numberOfSteps;
    private int currentStep;

    private final int circleSize;
    private final int  topOffset;

    // constructor
    public StepDisplay(int nNumberOfSteps, int nCurrentStep){
        this.checkInputs(nNumberOfSteps, nCurrentStep);

        this.numberOfSteps = nNumberOfSteps;
        this.currentStep = nCurrentStep;

        this.circleSize = 30;
        this.topOffset = 30;
    }

    private void checkInputs(int nNumberOfSteps, int nCurrentStep){
        if(nNumberOfSteps < 1) throw new IllegalArgumentException("Number of steps must be at least 1.");
        if(nCurrentStep < 1 || nCurrentStep > nNumberOfSteps) throw new IllegalArgumentException("Current step is out of range.");
    }

	@Override
	public void designComponent() {
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(500, 50));
        this.setMinimumSize(new Dimension(200, 50));
	}

	@Override
	public void skinParts() {
	}

	@Override
	public void addParts() {
	}

	@Override
	public void prepareComponents() {
	}

	@Override
	public void addComponents() {
	}

	@Override
	public void refresh() {
        this.repaint();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int width = this.getWidth();
        int startX = this.circleSize / 2 + 5;
        int endX = width - this.circleSize / 2 - 5;
        int centerY = this.topOffset;

        int distance = this.numberOfSteps == 1 ? 0 : (endX - startX) / (this.numberOfSteps - 1);
        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for(int i = 0; i < this.numberOfSteps - 1; i++){
            int x1 = startX + i * distance;
            int x2 = startX + (i + 1) * distance;

            g2.setColor(i + 1 < this.currentStep ? Colors.PRIMARY.getColor() : Colors.TEXT_DISABLED.getColor());
            g2.drawLine(x1, centerY, x2, centerY);
        }

        for(int i = 1; i <= this.numberOfSteps; i++){
            int x = startX + (i - 1) * distance;

            Color circleColor;

            if(i < this.currentStep){
                circleColor = Colors.PRIMARY.getColor();
            }else if(i == this.currentStep){
                circleColor = Colors.PRIMARY.getColor();
            }else{
                circleColor = Colors.TEXT_DISABLED.getColor();
            }

            if(i == this.currentStep){
                Color aktiv = Colors.TEXT_SECONDARY.getColor();
                g2.setColor(new Color(aktiv.getRed(), aktiv.getGreen(), aktiv.getBlue(), 45));
                g2.fillOval(x - this.circleSize / 2 - 5, centerY - this.circleSize / 2 - 5, this.circleSize + 10, this.circleSize + 10);
            }

            g2.setColor(circleColor);
            g2.fillOval(x - this.circleSize / 2, centerY - this.circleSize / 2, this.circleSize, this.circleSize);

            g2.setFont(Fonts.TEXT_SECOND.loadFont());
            g2.setColor(Colors.BASE.getColor());

            String value = String.valueOf(i);

            FontMetrics metrics = g2.getFontMetrics();

            int textX = x - metrics.stringWidth(value) / 2;
            int textY = centerY + (metrics.getAscent() - metrics.getDescent()) / 2;

            g2.drawString(value, textX, textY);
        }

        g2.dispose();
    }

    //getter
    public int getCurrentStep(){
        return this.currentStep;
    }

    // setter
    public void setCurrentStep(int nCurrentStep){
        if(nCurrentStep < 1 || nCurrentStep > this.numberOfSteps) throw new IllegalArgumentException("Current step is out of range.");

        this.currentStep = nCurrentStep;
        this.refresh();
    }
    
}
