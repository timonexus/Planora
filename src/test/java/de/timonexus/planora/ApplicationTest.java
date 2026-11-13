
package de.timonexus.planora;

import de.timonexus.planora.database.DatabaseInitializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    // Test: Application constructor
    @Test
    void testConstructor() {
        Application application = new Application();

        assertNotNull(application);
    }

    // Test: DatabaseInitializer initialization
    @Test
    void testDatabaseInitializer() {
        Application application = new Application();

        assertNotNull(application.getDatabaseInitializer());
        assertInstanceOf(
                DatabaseInitializer.class,
                application.getDatabaseInitializer()
        );
    }

    // Test: Getter returns the same instance
    @Test
    void testGetDatabaseInitializer() {
        Application application = new Application();

        DatabaseInitializer initializer1 =
                application.getDatabaseInitializer();

        DatabaseInitializer initializer2 =
                application.getDatabaseInitializer();

        assertSame(initializer1, initializer2);
    }

    // Test: Start application
    @Test
    void testStartApplication() {
        Application application = new Application();

        assertDoesNotThrow(application::startApplication);
    }
}
