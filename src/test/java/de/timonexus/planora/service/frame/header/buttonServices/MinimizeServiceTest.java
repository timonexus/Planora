package de.timonexus.planora.service.frame.header.buttonServices;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;

class MinimizeServiceTest {

    // Attributes
    private FrameService frameService;
    private MinimizeService minimizeService;

    // Setup
    @BeforeEach
    void setUp() {
        this.frameService = mock(FrameService.class);
        this.minimizeService = new MinimizeService(this.frameService);
    }

    // execute()
    @Test
    void testExecute() {
        this.minimizeService.execute();

        verify(this.frameService).minimize();
    }

    // getIconLabel()
    @Test
    void testGetIconLabel() {
        assertNotNull(this.minimizeService.getIconLabel());
        assertNotNull(this.minimizeService.getIconLabel().getIcon());
    }

    // getButtonColor()
    @Test
    void testGetButtonColor() {
        assertSame(
                Colors.APPLE_MINIMIZE.getColor(),
                this.minimizeService.getButtonColor()
        );
    }
}