
package de.timonexus.planora.ui.frame;

import java.awt.GraphicsEnvironment;

import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import de.timonexus.planora.utils.enums.Colors;

import org.junit.jupiter.api.Assumptions;

import static org.junit.jupiter.api.Assertions.*;

class PlanoraFrameTest {

    // Test: Frame configuration
    @Test
    void testSkinFrame() throws Exception {

        Assumptions.assumeFalse(GraphicsEnvironment.isHeadless());

        SwingUtilities.invokeAndWait(() -> {

            PlanoraFrame frame = new PlanoraFrame();

            try {
                frame.skinFrame();

                assertAll(
                    () -> assertEquals(
                        FrameValues.TITLE.getValue(),
                        frame.getTitle()
                    ),
                    () -> assertEquals(
                        FrameValues.WIDTH.getValue(),
                        frame.getWidth()
                    ),
                    () -> assertEquals(
                        FrameValues.HEIGHT.getValue(),
                        frame.getHeight()
                    ),
                    () -> assertEquals(
                        Colors.BASE.getColor(),
                        frame.getContentPane().getBackground()
                    )
                );

            } finally {
                frame.dispose();
            }
        });
    }

    // Test: Adding components
    @Test
    void testAddComponents() throws Exception {

        Assumptions.assumeFalse(GraphicsEnvironment.isHeadless());

        SwingUtilities.invokeAndWait(() -> {

            PlanoraFrame frame = new PlanoraFrame();

            try {
                assertDoesNotThrow(frame::addComponents);

            } finally {
                frame.dispose();
            }
        });
    }

    // Test: Frame inheritance
    @Test
    void testFrameInheritance() throws Exception {

        Assumptions.assumeFalse(GraphicsEnvironment.isHeadless());

        SwingUtilities.invokeAndWait(() -> {

            PlanoraFrame frame = new PlanoraFrame();

            try {
                assertInstanceOf(Frame.class, frame);
                assertInstanceOf(
                    javax.swing.JFrame.class,
                    frame
                );

            } finally {
                frame.dispose();
            }
        });
    }
}
