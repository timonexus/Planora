package de.timonexus.planora.service.frame.header;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.frame.header.buttonServices.FrameButtonService;
import de.timonexus.planora.ui.Component;
import de.timonexus.planora.ui.ComponentContainer;

class ButtonsServiceTest {

    // Attributes
    private Component windowButtons;
    private FrameButtonService maximize;
    private FrameButtonService minimize;
    private FrameButtonService close;

    private ButtonsService buttonsService;

    // Setup
    @BeforeEach
    void setUp() {
        this.windowButtons = mock(
                Component.class,
                withSettings().extraInterfaces(ComponentContainer.class)
        );

        this.maximize = mock(FrameButtonService.class);
        this.minimize = mock(FrameButtonService.class);
        this.close = mock(FrameButtonService.class);

        this.buttonsService = new ButtonsService(
                this.windowButtons,
                this.maximize,
                this.minimize,
                this.close
        );
    }

    // prepareComponent()
    @Test
    void testPrepareComponent() {
        Component closeButton = mock(Component.class);
        Component minimizeButton = mock(Component.class);
        Component maximizeButton = mock(Component.class);

        when(this.close.getButton()).thenReturn(closeButton);
        when(this.minimize.getButton()).thenReturn(minimizeButton);
        when(this.maximize.getButton()).thenReturn(maximizeButton);

        this.buttonsService.prepareComponent();

        verify(this.windowButtons).prepareComponent();

        verify(this.close).getButton();
        verify(this.minimize).getButton();
        verify(this.maximize).getButton();

        ComponentContainer container =
                (ComponentContainer) this.windowButtons;

        verify(container).add(closeButton, null);
        verify(container).add(minimizeButton, null);
        verify(container).add(maximizeButton, null);
    }

    // add()
    @Test
    void testAdd() {
        Component component = mock(Component.class);
        ComponentContainer container =
                (ComponentContainer) this.windowButtons;

        this.buttonsService.add(component, null);

        verify(container).add(component, null);
    }

    // getComponent()
    @Test
    void testGetComponent() {
        Component result = this.buttonsService.getComponent();

        assertSame(this.windowButtons, result);
    }
}