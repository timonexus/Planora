package de.timonexus.planora.ui.frame.frameHeader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;

class FrameHeaderTest {

    private FrameHeader frameHeader;
    private FrameService frameService;

    @BeforeEach
    void setUp() {
        this.frameService = mock(FrameService.class);
        this.frameHeader = new FrameHeader(this.frameService);
    }

    @Test
    void testDesignComponent() {
        this.frameHeader.designComponent();

        assertInstanceOf(BorderLayout.class, this.frameHeader.getLayout());
        assertEquals(Colors.BASE.getColor(), this.frameHeader.getBackground());
        assertEquals(new Dimension(0, 40), this.frameHeader.getPreferredSize());
    }

    @Test
    void testSkinParts() {
        assertDoesNotThrow(() -> this.frameHeader.skinParts());
    }

    @Test
    void testAddParts() {
        assertDoesNotThrow(() -> this.frameHeader.addParts());
    }

    @Test
    void testPrepareComponents() {
        assertDoesNotThrow(() -> this.frameHeader.prepareComponents());

        assertTrue(this.frameHeader.getMouseListeners().length > 0);
        assertTrue(this.frameHeader.getMouseMotionListeners().length > 0);
    }

    @Test
    void testAddComponents() {
        assertDoesNotThrow(() -> this.frameHeader.addComponents());
    }

    @Test
    void testRefresh() {
        assertDoesNotThrow(() -> this.frameHeader.refresh());
    }

    @Test
    void testMouseDraggedMovesFrame() {
        when(this.frameService.isMaximized()).thenReturn(false);
        when(this.frameService.getLocation()).thenReturn(new Point(100, 100));

        this.frameHeader.prepareComponents();

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_PRESSED,
            System.currentTimeMillis(),
            0,
            10,
            10,
            1,
            false
        ));

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_DRAGGED,
            System.currentTimeMillis(),
            MouseEvent.BUTTON1_DOWN_MASK,
            30,
            40,
            1,
            false
        ));

        verify(this.frameService).setLocation(new Point(120, 130));
    }

    @Test
    void testMouseDraggedDoesNotMoveMaximizedFrame() {
        when(this.frameService.isMaximized()).thenReturn(true);

        this.frameHeader.prepareComponents();

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_PRESSED,
            System.currentTimeMillis(),
            0,
            10,
            10,
            1,
            false
        ));

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_DRAGGED,
            System.currentTimeMillis(),
            MouseEvent.BUTTON1_DOWN_MASK,
            30,
            40,
            1,
            false
        ));

        verify(this.frameService, never()).getLocation();
        verify(this.frameService, never()).setLocation(any(Point.class));
    }

    @Test
    void testMouseDraggedWithoutMousePressedDoesNotMoveFrame() {
        when(this.frameService.isMaximized()).thenReturn(false);

        this.frameHeader.prepareComponents();

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_DRAGGED,
            System.currentTimeMillis(),
            MouseEvent.BUTTON1_DOWN_MASK,
            30,
            40,
            1,
            false
        ));

        verify(this.frameService, never()).getLocation();
        verify(this.frameService, never()).setLocation(any(Point.class));
    }

    @Test
    void testMouseReleasedResetsDragPoint() {
        when(this.frameService.isMaximized()).thenReturn(false);

        this.frameHeader.prepareComponents();

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_PRESSED,
            System.currentTimeMillis(),
            0,
            10,
            10,
            1,
            false
        ));

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_RELEASED,
            System.currentTimeMillis(),
            0,
            10,
            10,
            1,
            false
        ));

        this.frameHeader.dispatchEvent(new MouseEvent(
            this.frameHeader,
            MouseEvent.MOUSE_DRAGGED,
            System.currentTimeMillis(),
            MouseEvent.BUTTON1_DOWN_MASK,
            30,
            40,
            1,
            false
        ));

        verify(this.frameService, never()).getLocation();
        verify(this.frameService, never()).setLocation(any(Point.class));
    }
}