package de.timonexus.planora.ui.ToastSystem;

import java.awt.Dimension;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class ToastManager {

    private final JFrame frame;
    private final Queue<ToastData> queue = new ArrayDeque<>();

    private ToastNotification currentToast;
    private Timer timer;

    private static final int MARGIN = 10;
    private static final int DISPLAY_TIME = 9000;

    public ToastManager(JFrame frame) {
        this.frame = frame;
    }

    public void show(ToastType type, String message) {

        queue.offer(new ToastData(type, message));

        if (currentToast == null) {
            showNext();
        }
    }

    private void showNext() {

        ToastData data = queue.poll();

        if (data == null) {
            return;
        }

        JLayeredPane layeredPane = frame.getLayeredPane();

        currentToast = new ToastNotification(
                data.type(),
                data.message()
        );
        currentToast.prepareComponent();

        layeredPane.add(
                currentToast,
                JLayeredPane.POPUP_LAYER
        );

        positionToast();
        layeredPane.revalidate();
        layeredPane.repaint();

        timer = new Timer(DISPLAY_TIME, e -> removeCurrentToast());
        timer.setRepeats(false);
        timer.start();
    }

    private void positionToast() {

        if (currentToast == null) {
            return;
        }

        Dimension size = currentToast.getPreferredSize();

        int x = frame.getLayeredPane().getWidth()
                - size.width - MARGIN;

        int y = frame.getLayeredPane().getHeight()
                - size.height - MARGIN;

        currentToast.setBounds(
                x,
                y,
                size.width,
                size.height
        );
    }

    private void removeCurrentToast() {

        if (timer != null) {
            timer.stop();
            timer = null;
        }

        if (currentToast != null) {
            frame.getLayeredPane().remove(currentToast);
            currentToast = null;
        }

        frame.getLayeredPane().revalidate();
        frame.getLayeredPane().repaint();

        showNext();
    }

    private record ToastData(ToastType type, String message) {
    }
}