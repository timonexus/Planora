package de.timonexus.planora.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryResult implements AutoCloseable {

    private final Connection connection;
    private final PreparedStatement statement;
    private final ResultSet resultSet;

    public QueryResult(Connection nConnection, PreparedStatement nStatement,
            ResultSet nResultSet) {

        this.connection = nConnection;
        this.statement = nStatement;
        this.resultSet = nResultSet;
    }

    public ResultSet getResultSet() {
        return this.resultSet;
    }

    @Override
    public void close() throws SQLException {
        try {
            this.resultSet.close();
        } finally {
            try {
                this.statement.close();
            } finally {
                this.connection.close();
            }
        }
    }
}