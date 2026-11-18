package de.timonexus.planora.repositorys;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.timonexus.planora.database.Database;
import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;

public interface Repository {

    Model[] loadAll();

    default QueryResult querySQL(String nSQL) throws SQLException {

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(nSQL);
            ResultSet resultSet = statement.executeQuery();

            return new QueryResult(connection, statement, resultSet);

        } catch (SQLException e) {
            connection.close();
            throw e;
        }
    }

    default String readSqlFile(String file) throws IOException {
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
