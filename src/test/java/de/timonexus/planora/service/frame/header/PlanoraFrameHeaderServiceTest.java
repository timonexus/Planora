package de.timonexus.planora.service.frame.header;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import java.awt.BorderLayout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.ComponentService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.ComponentContainer;

class PlanoraFrameHeaderServiceTest {

    // Attributes
    private Component header;
    private ComponentService buttonService;
    private PlanoraFrameHeaderService headerService;

    // Setup
    @BeforeEach
    void setUp() {
        this.header = mock(Component.class, withSettings().extraInterfaces(ComponentContainer.class));
        this.buttonService = mock(ComponentService.class);

        this.headerService = new PlanoraFrameHeaderService(
                this.header,
                this.buttonService
        );
    }

    // prepareComponent()
    @Test
    void testPrepareComponent() {
        Component buttonComponent = mock(Component.class);

        when(this.buttonService.getComponent()).thenReturn(buttonComponent);

        this.headerService.prepareComponent();

        verify(this.header).prepareComponent();
        verify(this.buttonService).prepareComponent();
        verify(this.buttonService).getComponent();

        verify((ComponentContainer) this.header)
                .add(buttonComponent, BorderLayout.WEST);
    }

    // add()
    @Test
    void testAdd() {
        Component component = mock(Component.class);
        String layout = BorderLayout.CENTER;

        this.headerService.add(component, layout);

        verify((ComponentContainer) this.header)
                .add(component, layout);
    }

    // getComponent()
    @Test
    void testGetComponent() {
        Component result = this.headerService.getComponent();

        assertSame(this.header, result);
    }
}