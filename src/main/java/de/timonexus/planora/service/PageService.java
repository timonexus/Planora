package de.timonexus.planora.service;

import de.timonexus.planora.ui.frame.Frame;
import de.timonexus.planora.ui.pages.Pages;

public class PageService implements Service{

    // attributes
    private Frame frame;
    
    // constructor
    public PageService(Frame nFrame){
        this.frame = nFrame;
    }

    // method for opening page
    @Override
    public void openPage(Pages nPage){
        this.frame.setPage(nPage.getPage());
    }

}
