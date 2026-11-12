package de.timonexus.planora.database;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    
    public static Path defaultDatabasePath(){
        return Path.of(System.getProperty("user.home"), ".planora", "planora.db");
    }

    public static Connection getConnection() throws SQLException{
        Path path = defaultDatabasePath().toAbsolutePath();

        try {
            Files.createDirectories(path.getParent());
        } catch (Exception e){
            System.out.println("The database-folder can't be created (class: Database, method: getConnection()): " + e);
        }

        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);

        try(Statement statement = connection.createStatement()){
            statement.execute("PRAGMA foreign_keys = ON");
        }catch (Exception e){
            connection.close();
            System.out.println("Failed to enable foreign_keys (class: Database, method:getConnection()): " + e);
        }

        return connection;
    }
}
