package de.timonexus.planora.repositorys;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import de.timonexus.planora.database.Database;
import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;

public interface Repository {

    Model[] loadAll(int nId);
    int safe(Model nValues);
    void delete(List<Integer> nLineIds);
    Model[] search(String nText);

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

    default int executeSQL(String sql, Object... values)
            throws SQLException {

        try (
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }

            return statement.executeUpdate();
        }
    }

    default int executeSQLWithGeneratedKey(
            String sql,
            Object... values
    ) throws SQLException {

        try (
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            )
        ) {

            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }

                throw new SQLException("Keine generierte ID zurückgegeben.");
            }
        }
    }

    default QueryResult querySQL(String sql, Object... values) throws SQLException {

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }

            ResultSet resultSet = statement.executeQuery();

            return new QueryResult(connection, statement, resultSet);

        } catch (SQLException e) {
            connection.close();
            throw e;
        }
    }

}
