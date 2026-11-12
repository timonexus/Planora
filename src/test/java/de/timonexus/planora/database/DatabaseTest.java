package de.timonexus.planora.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @TempDir
    Path tempDir;

    private String originalUserHome;

    @BeforeEach
    void setUp() {
        originalUserHome = System.getProperty("user.home");
        System.setProperty("user.home", tempDir.toString());
    }

    @AfterEach
    void tearDown() {
        if (originalUserHome != null) {
            System.setProperty("user.home", originalUserHome);
        }
    }

    @Test
    void defaultDatabasePathShouldReturnCorrectPath() {

        // Arrange
        Path expected = tempDir.resolve(".planora").resolve("planora.db");

        // Act
        Path actual = Database.defaultDatabasePath();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getConnectionShouldCreateDatabaseDirectory() throws Exception {

        // Arrange
        Path databaseDirectory = tempDir.resolve(".planora");

        // Act
        try (Connection connection = Database.getConnection()) {

            // Assert
            assertNotNull(connection);
            assertTrue(Files.exists(databaseDirectory));
            assertTrue(Files.exists(databaseDirectory.resolve("planora.db")));
            assertFalse(connection.isClosed());
        }
    }

    @Test
    void getConnectionShouldEnableForeignKeys() throws Exception {

        // Arrange & Act
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("PRAGMA foreign_keys")) {

            // Assert
            assertTrue(resultSet.next());
            assertEquals(1, resultSet.getInt(1));
        }
    }
}