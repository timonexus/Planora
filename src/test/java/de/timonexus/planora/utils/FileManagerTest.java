package de.timonexus.planora.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @TempDir
    Path tempDir;

    private FileManager fileManager;
    private Path filepath;

    @BeforeEach
    void setUp() {
        filepath = tempDir.resolve("test.txt");
        fileManager = new FileManager(filepath);
    }

    @Test
    void constructorShouldCreateFile() {

        // Assert
        assertTrue(Files.exists(filepath));
        assertTrue(Files.isRegularFile(filepath));
    }

    @Test
    void readFileShouldReturnCorrectContent() throws IOException {

        // Arrange
        List<String> expected = List.of("Hello", "World");
        Files.write(filepath, expected);

        // Act
        List<String> actual = fileManager.readFile();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void writeToFileShouldWriteContent() {

        // Arrange
        List<String> expected = List.of("Hello", "World");

        // Act
        fileManager.writeToFile(expected);

        // Assert
        assertEquals(expected, fileManager.readFile());
    }

    @Test
    void writeToFileShouldOverwriteExistingContent() {

        // Arrange
        fileManager.writeToFile(List.of("Old content"));

        List<String> expected = List.of("New content");

        // Act
        fileManager.writeToFile(expected);

        // Assert
        assertEquals(expected, fileManager.readFile());
    }

    @Test
    void appendToFileShouldAddContent() throws IOException {

        // Arrange
        fileManager.writeToFile(List.of("First line"));

        List<String> additionalContent = List.of("Second line");

        // Act
        fileManager.appendToFile(additionalContent);

        // Assert
        assertEquals(
            List.of("First line", "Second line"),
            fileManager.readFile()
        );
    }

    @Test
    void appendToFileShouldPreserveExistingContent() throws IOException {

        // Arrange
        List<String> originalContent = List.of("One", "Two");
        fileManager.writeToFile(originalContent);

        // Act
        fileManager.appendToFile(List.of("Three"));

        // Assert
        assertEquals(
            List.of("One", "Two", "Three"),
            fileManager.readFile()
        );
    }
}