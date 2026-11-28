package de.timonexus.planora.service.services;

import java.awt.Color;

import javax.swing.JLabel;

import de.timonexus.planora.ui.Component;

public interface ButtonService {

    void execute();
    JLabel getIconLabel();
    Color getButtonColor();
    Component getButton();
}
