package de.timonexus.planora;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.timonexus.planora.database.DatabaseInitializer;
import de.timonexus.planora.service.services.FrameService;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    // Attributes
    @Mock
    private DatabaseInitializer databaseInitializer;

    @Mock
    private FrameService frameService;

    private Application application;

    // Setup
    @BeforeEach
    void setUp() {
        application = new Application(
            databaseInitializer,
            frameService
        );
    }

    // Tests

    @Test
    void shouldInitializeDatabaseWhenApplicationIsCreated() throws SQLException, IOException {
        verify(databaseInitializer).initialize();
    }

    @Test
    void shouldNotPrepareFrameBeforeApplicationStarts() {
        verifyNoInteractions(frameService);
    }

    @Test
    void shouldPrepareFrameWhenApplicationStarts() {
        application.startApplication();

        verify(frameService).prepareComponent();
    }

    @Test
    void shouldMakeFrameVisibleWhenApplicationStarts() {
        application.startApplication();

        verify(frameService).isVisible(true);
    }

    @Test
    void shouldPrepareFrameBeforeMakingItVisible() {
        application.startApplication();

        InOrder inOrder = inOrder(frameService);

        inOrder.verify(frameService).prepareComponent();
        inOrder.verify(frameService).isVisible(true);
    }

    @Test
    void shouldContinueWhenDatabaseInitializationFails() throws SQLException, IOException {
        doThrow(new RuntimeException("Database initialization failed"))
            .when(databaseInitializer)
            .initialize();

        assertDoesNotThrow(() ->
            new Application(databaseInitializer, frameService)
        );
    }

    @Test
    void shouldReturnDatabaseInitializer() {
        assertSame(
            databaseInitializer,
            application.getDatabaseInitializer()
        );
    }
}