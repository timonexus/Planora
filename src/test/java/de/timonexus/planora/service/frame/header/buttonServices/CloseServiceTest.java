package de.timonexus.planora.service.frame.header.buttonServices;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.service.services.FrameService;
import de.timonexus.planora.utils.enums.Colors;

class CloseServiceTest {

    // Attributes
    private FrameService frameService;
    private CloseService closeService;

    // Setup
    @BeforeEach
    void setUp() {
        this.frameService = mock(FrameService.class);
        this.closeService = new CloseService(this.frameService);
    }

    // execute()
    @Test
    void testExecute() {
        this.closeService.execute();

        verify(this.frameService).close();
    }

    // getIconLabel()
    @Test
    void testGetIconLabel() {
        assertNotNull(this.closeService.getIconLabel());
        assertNotNull(this.closeService.getIconLabel().getIcon());
    }

    // getButtonColor()
    @Test
    void testGetButtonColor() {
        assertSame(
                Colors.APPLE_CLOSE.getColor(),
                this.closeService.getButtonColor()
        );
    }
}