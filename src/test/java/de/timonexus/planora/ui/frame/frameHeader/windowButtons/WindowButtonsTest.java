package de.timonexus.planora.ui.frame.frameHeader.windowButtons;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WindowButtonsTest {

    private WindowButtons windowButtons;

    @BeforeEach
    void setUp() {
        this.windowButtons = new WindowButtons();
    }

    @Test
    void testDesignComponent() {
        this.windowButtons.designComponent();

        assertInstanceOf(BoxLayout.class, this.windowButtons.getLayout());
        assertFalse(this.windowButtons.isOpaque());
        assertEquals(new Dimension(200, 80), this.windowButtons.getPreferredSize());
    }

    @Test
    void testSkinParts() {
        assertDoesNotThrow(() -> this.windowButtons.skinParts());
    }

    @Test
    void testAddParts() {
        assertDoesNotThrow(() -> this.windowButtons.addParts());
    }

    @Test
    void testPrepareComponents() {
        assertDoesNotThrow(() -> this.windowButtons.prepareComponents());
    }

    @Test
    void testAddComponents() {
        assertDoesNotThrow(() -> this.windowButtons.addComponents());
    }

    @Test
    void testRefresh() {
        assertDoesNotThrow(() -> this.windowButtons.refresh());
    }

    @Test
    void testPrepareComponent() {
        assertDoesNotThrow(() -> this.windowButtons.prepareComponent());

        assertInstanceOf(BoxLayout.class, this.windowButtons.getLayout());
        assertFalse(this.windowButtons.isOpaque());
        assertEquals(new Dimension(200, 80), this.windowButtons.getPreferredSize());
    }
}