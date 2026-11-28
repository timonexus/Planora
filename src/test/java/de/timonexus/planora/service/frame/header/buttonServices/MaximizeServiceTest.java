package de.timonexus.planora.service.frame.header.buttonServices;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;

class MaximizeServiceTest {

    // Attributes
    private FrameService frameService;
    private MaximizeService maximizeService;

    // Setup
    @BeforeEach
    void setUp() {
        this.frameService = mock(FrameService.class);
        this.maximizeService = new MaximizeService(this.frameService);
    }

    // execute()
    @Test
    void testExecute() {
        this.maximizeService.execute();

        verify(this.frameService).maximize();
    }

    // getIconLabel()
    @Test
    void testGetIconLabel() {
        assertNotNull(this.maximizeService.getIconLabel());
        assertNotNull(this.maximizeService.getIconLabel().getIcon());
    }

    // getButtonColor()
    @Test
    void testGetButtonColor() {
        assertSame(
                Colors.APPLE_MAXIMIZE.getColor(),
                this.maximizeService.getButtonColor()
        );
    }
}