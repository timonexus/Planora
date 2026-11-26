package de.timonexus.planora.ui.ToastSystem;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
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

        showNotifications();
    }

    public void removeToastNotification(String nMessage){
        for(ToastNotification notification : notificationList){
            if(notification.getMessage().contains(nMessage)){
                this.notificationList.remove(notification);
            }
        }
    }

    public void showNotifications(){
        JLayeredPane layeredPane = frame.getLayeredPage();

        layeredPane.removeAll();

        System.out.println("Added");

        for(ToastNotification toastNotification : this.notificationList){
            toastNotification.prepareComponent();
                        layeredPane.add(
                toastNotification,
                JLayeredPane.POPUP_LAYER
            );
        }

        positionNotifications();

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private void positionNotifications() {

        JLayeredPane layeredPane = frame.getLayeredPage();

        int y = layeredPane.getHeight() - MARGIN;

        for (int i = notificationList.size() - 1; i >= 0; i--) {

            ToastNotification notification = notificationList.get(i);

            int width = notification.getPreferredSize().width;
            int height = notification.getPreferredSize().height;

            int x = layeredPane.getWidth() - width - MARGIN;

            y -= height;

            notification.setBounds(x, y, width, height);

            y -= MARGIN;
        }
    }
}
