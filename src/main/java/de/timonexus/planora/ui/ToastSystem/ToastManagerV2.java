package de.timonexus.planora.ui.ToastSystem;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import de.timonexus.planora.ui.frame.Frame;

public class ToastManagerV2 {
    
    // attributes
    private final Frame frame;
    private final List<ToastNotification> notificationList;

    private Timer timer;

    private static final int MARGIN = 10;
    private static final int DISPLAY_TIME = 9000;

    // constructor
    public ToastManagerV2(Frame nFrame){
        this.frame = nFrame;

        this.notificationList = new ArrayList<>();
    }

    public void createToastNotification(ToastType nToastType, String nMessage){
        this.notificationList.add(new ToastNotification(nToastType, nMessage, null));
    }

    public void removeToastNotification(String nMessage){
        for(ToastNotification notification : notificationList){
            if(notification.getMessage().contains(nMessage)){
                this.notificationList.remove(notification);
            }
        }
    }

    public void showNotifications(){

    }

}
