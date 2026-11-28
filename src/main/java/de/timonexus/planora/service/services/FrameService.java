package de.timonexus.planora.service.services;

import java.awt.Point;

import de.timonexus.planora.ui.Component;

public interface FrameService{

    void prepareComponent();

    void isVisible(boolean isVisible);
    void minimize();
    void maximize();
    void close();

    void add(Component nComponent, String nBorderLayout);

    boolean isMaximized();
    Point getLocation();
    void setLocation(Point nPoint);
}