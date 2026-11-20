
package de.timonexus.planora.ui.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WindowAnimator implements WindowStateListener {

    private final JFrame frame;
    private final JLayeredPane layeredPane;

    private AnimationOverlay overlay;
    private Timer animationTimer;

    private boolean animating;

    private static final int DURATION = 240;
    private static final int FPS_DELAY = 16;

    public WindowAnimator(JFrame nFrame) {
        this.frame = nFrame;
        this.layeredPane = frame.getRootPane().getLayeredPane();

        this.frame.addWindowStateListener(this);
    }

    // Fenster öffnen
    public void open() {
        if (animating) {
            return;
        }

        this.startAnimation(1f, 0f, null);
    }

    // Fenster minimieren
    public void minimize() {
        if (animating || frame.getState() == JFrame.ICONIFIED) {
            return;
        }

        this.startAnimation(0f, 1f, () -> {
            frame.setState(JFrame.ICONIFIED);
            removeOverlay();
        });
    }

    // Fenster wiederherstellen
    @Override
    public void windowStateChanged(WindowEvent event) {

        boolean wasMinimized =
                (event.getOldState() & JFrame.ICONIFIED) != 0;

        boolean isRestored =
                (event.getNewState() & JFrame.ICONIFIED) == 0;

        if (wasMinimized && isRestored) {
            SwingUtilities.invokeLater(() -> {
                if (frame.isVisible()) {
                    this.open();
                }
            });
        }
    }

    private void startAnimation(
            float startAlpha,
            float endAlpha,
            Runnable onFinished) {

        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }

        animating = true;

        createOverlay();

        overlay.setAlpha(startAlpha);
        overlay.setVisible(true);

        final long startTime = System.nanoTime();

        animationTimer = new Timer(FPS_DELAY, event -> {

            float progress = Math.min(
                    1f,
                    (System.nanoTime() - startTime)
                            / (DURATION * 1_000_000f)
            );

            // Smooth Ease-In-Out
            float eased = progress * progress * (3f - 2f * progress);

            float alpha = startAlpha
                    + (endAlpha - startAlpha) * eased;

            overlay.setAlpha(alpha);

            if (progress >= 1f) {
                animationTimer.stop();

                animating = false;

                if (onFinished != null) {
                    onFinished.run();
                } else {
                    removeOverlay();
                }
            }
        });

        animationTimer.start();
    }

    private void createOverlay() {

        if (overlay != null) {
            layeredPane.remove(overlay);
        }

        overlay = new AnimationOverlay();

        overlay.setBounds(
                0,
                0,
                layeredPane.getWidth(),
                layeredPane.getHeight()
        );

        layeredPane.add(overlay, JLayeredPane.POPUP_LAYER);

        layeredPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) {
                if (overlay != null) {
                    overlay.setBounds(
                            0,
                            0,
                            layeredPane.getWidth(),
                            layeredPane.getHeight()
                    );
                }
            }
        });

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private void removeOverlay() {

        if (overlay == null) {
            return;
        }

        layeredPane.remove(overlay);
        overlay = null;

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private static class AnimationOverlay extends JPanel {

        private float alpha;

        private final Color overlayColor = new Color(20, 20, 20);

        public AnimationOverlay() {
            setOpaque(false);
            setFocusable(true);
        }

        public void setAlpha(float nAlpha) {
            this.alpha = Math.max(0f, Math.min(1f, nAlpha));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics graphics) {

            Graphics2D g2 = (Graphics2D) graphics.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(new Color(
                    overlayColor.getRed(),
                    overlayColor.getGreen(),
                    overlayColor.getBlue(),
                    Math.round(alpha * 255)
            ));

            g2.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );

            g2.dispose();
        }
    }
}
