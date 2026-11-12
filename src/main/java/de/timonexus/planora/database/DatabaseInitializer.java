package de.timonexus.planora.database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {

    // Attributes
    private final List<String> files;

    // Constructor
    public DatabaseInitializer() {
        this.files = new ArrayList<>();
        registerFiles();
    }

    // Register all SQL files
    private void registerFiles() {
        files.add("sql/Duties/CreateTable.sql");
    }

    // Initialize database tables
    public void initialize() throws SQLException, IOException {

        try (Connection connection = Database.getConnection()) {

            connection.setAutoCommit(false);

            try {
                for (String file : files) {
                    String sql = readSqlFile(file);

                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sql);
                    }
                }

                connection.commit();

            } catch (SQLException | IOException exception) {
                connection.rollback();
                throw exception;
            }
        }
    }

    // Read SQL file from resources
    private String readSqlFile(String file) throws IOException {

        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(file)) {

            if (inputStream == null) {
                throw new IOException("SQL file not found: " + file);
            }

            return new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            );
        }
    }
}