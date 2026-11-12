package de.timonexus.planora.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {
    
    // attributes
    private Path filepath;

    // constructor
    public FileManager(Path nFilepath){
        this.filepath = nFilepath;

        createFile();
    }

    // method for creating path
    private void createFile(){
        try {
            Files.createDirectories(this.filepath.getParent());
            Files.createFile(filepath);
        } catch (IOException e) {
            System.out.println("Failed to create directory of the file (class: FileManager, methods: createFile)): " + this.filepath.toString() + " " + e);
        }
    }

    // method to read the file
    public List<String> readFile() {
        try {
            return Files.readAllLines(this.filepath);
        } catch (IOException e) {
            System.err.println("Failed to read file (class: FileManager, method: readFile()): " + this.filepath);
            e.printStackTrace();
            return List.of();
        }
    }

    // method to write into a file
    public void writeToFile(List<String> nTexts){
        try {
            Files.write(this.filepath, nTexts);
        } catch (IOException e) {
            System.out.println("Failed to write to file (class: FileManager, methods: writeToFile()): " + this.filepath.toString());
            e.printStackTrace();
        }
    }

    // method to append to a file
    public void appendToFile(List<String> nTexts) throws IOException {
        try {
            Files.write(this.filepath, nTexts, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Failed to append to file (class: FileManager, methods: appendToFile()): " + this.filepath.toString());
            e.printStackTrace();
        }
    }
}
