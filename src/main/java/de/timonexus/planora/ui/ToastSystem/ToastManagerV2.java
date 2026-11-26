
package de.timonexus.planora.ui.ToastSystem;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import de.timonexus.planora.ui.frame.Frame;

public class ToastManagerV2 {

    // --------------------------------------------------
    // Attributes
    // --------------------------------------------------

    private final Frame frame;
    private final List<ToastNotification> notificationList;
    private final JPanel toastLayer;

    private final Map<ToastNotification, Timer> timerMap;

    private static final int MARGIN = 10;
    private static final int DISPLAY_TIME = 9000;


    // --------------------------------------------------
    // Constructor
    // --------------------------------------------------

    public ToastManagerV2(Frame nFrame) {

        this.frame = nFrame;

        this.toastLayer = frame.getLayeredPage().getToastLayer();

        this.notificationList = new ArrayList<>();
        this.timerMap = new HashMap<>();
    }


    // --------------------------------------------------
    // Create Toast
    // --------------------------------------------------

    public void createToastNotification(
        ToastType nToastType,
        String nMessage
    ) {

        ToastNotification notification =
            new ToastNotification(nToastType, nMessage, null);

        this.notificationList.add(notification);

        this.showNotifications();
        this.startTimer(notification);
    }


    // --------------------------------------------------
    // Remove Toast
    // --------------------------------------------------

    public void removeToastNotification(String nMessage) {

        List<ToastNotification> notificationsToRemove =
            new ArrayList<>();

        for (ToastNotification notification : notificationList) {

            if (notification.getMessage().contains(nMessage)) {
                notificationsToRemove.add(notification);
            }
        }

        for (ToastNotification notification : notificationsToRemove) {
            this.removeToast(notification);
        }

        this.showNotifications();
    }

    private void removeToast(ToastNotification notification) {

        this.notificationList.remove(notification);

        Timer timer = this.timerMap.remove(notification);

        if (timer != null) {
            timer.stop();
        }
    }


    // --------------------------------------------------
    // Timer
    // --------------------------------------------------

    private void startTimer(ToastNotification notification) {

        Timer timer = new Timer(
            DISPLAY_TIME,
            e -> {
                this.removeToast(notification);
                this.showNotifications();
            }
        );

        timer.setRepeats(false);

        this.timerMap.put(notification, timer);

        timer.start();
    }


    // --------------------------------------------------
    // Display Notifications
    // --------------------------------------------------

    public void showNotifications() {

        this.toastLayer.removeAll();

        for (ToastNotification notification : notificationList) {

            notification.prepareComponent();

            this.toastLayer.add(notification);
        }

        this.positionNotifications();

        this.toastLayer.revalidate();
        this.toastLayer.repaint();

        this.frame.getLayeredPage().updateVisibility();
    }


    // --------------------------------------------------
    // Position Notifications
    // --------------------------------------------------

    private void positionNotifications() {

        int y = this.toastLayer.getHeight() - MARGIN;

        for (int i = notificationList.size() - 1; i >= 0; i--) {

            ToastNotification notification = notificationList.get(i);

            Dimension size = notification.getPreferredSize();

            int x = this.toastLayer.getWidth() - size.width - MARGIN;

            y -= size.height;

            notification.setBounds(
                x,
                y,
                size.width,
                size.height
            );

            y -= MARGIN;
        }
    }
}
