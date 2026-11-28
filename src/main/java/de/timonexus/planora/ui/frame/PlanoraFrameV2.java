package de.timonexus.planora.ui.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import de.timonexus.planora.ui.formulars.LayeredPane;
import de.timonexus.planora.ui.pages.DefaultPage;
import de.timonexus.planora.utils.enums.Colors;
import de.timonexus.planora.utils.enums.Logo;

public class PlanoraFrameV2 extends JFrame implements FrameV2{

    // attributes

    // constructor
    public PlanoraFrameV2(){
    }

    @Override
    public void skinFrame() {
        this.setTitle("Planora");
        this.setSize(new Dimension(1500 , 800));
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Colors.BASE.getColor());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Logo.DEFAULT_LOGO.getImageForTaskbar());

        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateWindowShape();
            }
        });
        this.updateWindowShape();

        this.setLayout(new BorderLayout());
    }

    @Override
    public void prepareComponents() {
    }

    @Override
    public void addComponents() {
    }

    @Override
    public void setPage(DefaultPage nDefaultPage) {
    }

    @Override
    public void refresh() {
        this.revalidate();
        this.repaint();
    }

    @Override
    public LayeredPane getLayeredPage() {
        return null;
    }

    @Override
    public void setVisible(boolean isVisible) {
        super.setVisible(isVisible);
    }


    private void updateWindowShape(){
        int width = this.getWidth();
        int height = this.getHeight();

        if(width > 0 && height > 0){
            this.setShape(new RoundRectangle2D.Double(0, 0, width, height, 24, 24));
        }
    }
    
}
