package de.timonexus.planora.service.frame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import java.awt.BorderLayout;
import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.frame.Frame;

class PlanoraFrameServiceTest {

    // Attributes
    private Frame frame;
    private ComponentService header;
    private PlanoraFrameService frameService;

    // Setup
    @BeforeEach
    void setUp() {
        this.frame = mock(Frame.class);
        this.header = mock(ComponentService.class);

        this.frameService = new PlanoraFrameService(
                this.frame,
                this.header
        );
    }

    // prepareComponent()
    @Test
    void testPrepareComponent() {
        Component headerComponent = mock(Component.class);

        when(this.header.getComponent()).thenReturn(headerComponent);

        this.frameService.prepareComponent();

        verify(this.frame).prepareFrame();
        verify(this.header).prepareComponent();
        verify(this.frame).add(headerComponent, BorderLayout.NORTH);
    }

    // isVisible()
    @Test
    void testIsVisible() {
        this.frameService.isVisible(true);

        verify(this.frame).setVisible(true);
    }

    @Test
    void testIsNotVisible() {
        this.frameService.isVisible(false);

        verify(this.frame).setVisible(false);
    }

    // close()
    @Test
    void testClose() {
        this.frameService.close();

        verify(this.frame).close();
    }

    // maximize()
    @Test
    void testMaximize() {
        this.frameService.maximize();

        verify(this.frame).maximize();
    }

    // minimize()
    @Test
    void testMinimize() {
        this.frameService.minimize();

        verify(this.frame).minimize();
    }

    // add()
    @Test
    void testAdd() {
        Component component = mock(Component.class);
        String layout = BorderLayout.CENTER;

        this.frameService.add(component, layout);

        verify(this.frame).add(component, layout);
    }

    // isMaximized()
    @Test
    void testIsMaximized() {
        when(this.frame.isMaximized()).thenReturn(true);

        boolean result = this.frameService.isMaximized();

        assertEquals(true, result);
        verify(this.frame).isMaximized();
    }

    @Test
    void testIsNotMaximized() {
        when(this.frame.isMaximized()).thenReturn(false);

        boolean result = this.frameService.isMaximized();

        assertEquals(false, result);
        verify(this.frame).isMaximized();
    }

    // setLocation()
    @Test
    void testSetLocation() {
        Point location = new Point(100, 200);

        this.frameService.setLocation(location);

        verify(this.frame).setLocation(location);
    }

    // getLocation()
    @Test
    void testGetLocation() {
        Point location = new Point(100, 200);

        when(this.frame.getLocation()).thenReturn(location);

        Point result = this.frameService.getLocation();

        assertSame(location, result);
        verify(this.frame).getLocation();
    }
}