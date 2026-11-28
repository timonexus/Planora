package de.timonexus.planora.ui.frame.frameHeader.windowButtons;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.ButtonService;

class WindowButtonTest {

    private ButtonService buttonService;
    private WindowButton windowButton;
    private JLabel iconLabel;

    @BeforeEach
    void setUp() {
        this.buttonService = mock(ButtonService.class);
        this.iconLabel = new JLabel();

        when(this.buttonService.getIconLabel()).thenReturn(this.iconLabel);
        when(this.buttonService.getButtonColor()).thenReturn(Color.RED);

        this.windowButton = new WindowButton(this.buttonService);
    }

    @Test
    void testConstructor() {
        assertNotNull(this.windowButton);
        verify(this.buttonService).getIconLabel();
    }

    @Test
    void testDesignComponent() {
        this.windowButton.designComponent();

        assertEquals(new Dimension(30, 30), this.windowButton.getPreferredSize());
        assertEquals(new Dimension(30, 30), this.windowButton.getMinimumSize());
        assertEquals(new Dimension(30, 30), this.windowButton.getMaximumSize());

        assertFalse(this.windowButton.isOpaque());
        assertInstanceOf(GridBagLayout.class, this.windowButton.getLayout());

        assertEquals(
            Cursor.HAND_CURSOR,
            this.windowButton.getCursor().getType()
        );

        assertFalse(this.iconLabel.isVisible());
        assertEquals(SwingConstants.CENTER, this.iconLabel.getVerticalAlignment());
        assertEquals(SwingConstants.CENTER, this.iconLabel.getHorizontalAlignment());

        assertEquals(1, this.windowButton.getComponentCount());
        assertSame(this.iconLabel, this.windowButton.getComponent(0));

        assertTrue(this.windowButton.getMouseListeners().length > 0);
    }

    @Test
    void testSkinParts() {
        assertDoesNotThrow(() -> this.windowButton.skinParts());
    }

    @Test
    void testAddParts() {
        assertDoesNotThrow(() -> this.windowButton.addParts());
    }

    @Test
    void testPrepareComponents() {
        assertDoesNotThrow(() -> this.windowButton.prepareComponents());
    }

    @Test
    void testAddComponents() {
        assertDoesNotThrow(() -> this.windowButton.addComponents());
    }

    @Test
    void testRefresh() {
        assertDoesNotThrow(() -> this.windowButton.refresh());
    }

    @Test
    void testPrepareComponent() {
        assertDoesNotThrow(() -> this.windowButton.prepareComponent());

        assertEquals(new Dimension(30, 30), this.windowButton.getPreferredSize());
        assertEquals(new Dimension(30, 30), this.windowButton.getMinimumSize());
        assertEquals(new Dimension(30, 30), this.windowButton.getMaximumSize());

        assertFalse(this.windowButton.isOpaque());
        assertInstanceOf(GridBagLayout.class, this.windowButton.getLayout());
        assertFalse(this.iconLabel.isVisible());
    }

    @Test
    void testMouseClicked() {
        this.windowButton.prepareComponent();

        MouseEvent event = new MouseEvent(
            this.windowButton,
            MouseEvent.MOUSE_CLICKED,
            System.currentTimeMillis(),
            0,
            15,
            15,
            1,
            false
        );

        this.windowButton.dispatchEvent(event);

        verify(this.buttonService).execute();
    }

    @Test
    void testMouseEntered() {
        this.windowButton.prepareComponent();

        MouseEvent event = new MouseEvent(
            this.windowButton,
            MouseEvent.MOUSE_ENTERED,
            System.currentTimeMillis(),
            0,
            15,
            15,
            0,
            false
        );

        this.windowButton.dispatchEvent(event);

        assertTrue(this.iconLabel.isVisible());
    }

    @Test
    void testMouseExited() {
        this.windowButton.prepareComponent();

        MouseEvent enteredEvent = new MouseEvent(
            this.windowButton,
            MouseEvent.MOUSE_ENTERED,
            System.currentTimeMillis(),
            0,
            15,
            15,
            0,
            false
        );

        this.windowButton.dispatchEvent(enteredEvent);

        MouseEvent exitedEvent = new MouseEvent(
            this.windowButton,
            MouseEvent.MOUSE_EXITED,
            System.currentTimeMillis(),
            0,
            15,
            15,
            0,
            false
        );

        this.windowButton.dispatchEvent(exitedEvent);

        assertFalse(this.iconLabel.isVisible());
    }
}