package com.company.connection;

import com.company.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SuperConnection {
    private final Connection connection;

    public SuperConnection() {
        connection = ConnectionManager.open();
    }

    public ResultSet getResultSet(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void Execute(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        var execute = statement.execute(sql);
    }

    public Object getById(String tableName, int id) throws SQLException {
        return new Object();
    }

    public void deleteTable (String tableName) throws SQLException {
        String sql = "DROP TABLE IF EXISTS " + tableName + "";
        Execute(sql);
    }

    public <T> void updateTableById (String tableName, String fieldName, int id, T field) throws SQLException {
        String sql = "update " + tableName + " set " + fieldName + " = " + field + " where id = " + id + "";
        Execute(sql);
    }

    public void printAll(String tableName, String order) throws SQLException {
        String sql = "select * from " + tableName + " order by " + order + "";
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()){
            System.out.println(getById(tableName, resultSet.getInt("id")));
        }
    }
}
