package de.timonexus.planora.service.frame.header.buttonServices;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import java.awt.Color;

import javax.swing.JLabel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.ui.Component;

class FrameButtonServiceTest {

    // Attributes
    private FrameService frameService;
    private JLabel iconLabel;
    private Color buttonColor;

    private TestFrameButtonService buttonService;

    // Setup
    @BeforeEach
    void setUp() {
        this.frameService = mock(FrameService.class);
        this.iconLabel = new JLabel("Test");
        this.buttonColor = Color.RED;

        this.buttonService = new TestFrameButtonService(
                this.frameService,
                this.iconLabel,
                this.buttonColor
        );
    }

    // getIconLabel()
    @Test
    void testGetIconLabel() {
        assertSame(
                this.iconLabel,
                this.buttonService.getIconLabel()
        );
    }

    // getButtonColor()
    @Test
    void testGetButtonColor() {
        assertSame(
                this.buttonColor,
                this.buttonService.getButtonColor()
        );
    }

    // getButton()
    @Test
    void testGetButton() {
        Component result = this.buttonService.getButton();

        assertNotNull(result);
    }

    // Test implementation
    private static class TestFrameButtonService extends FrameButtonService {

        public TestFrameButtonService(
                FrameService nFrameService,
                JLabel nIconLabel,
                Color nButtonColor) {

            super(nFrameService, nIconLabel, nButtonColor);
        }

        @Override
        public void execute() {
            // No implementation required for this test.
        }
    }
}