package com.company.connection;

import com.company.Customer;
import com.company.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerConnection extends SuperConnection{
    public CustomerConnection() {
        super();
    }

    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS customer(
                    id SERIAL PRIMARY KEY,
                    firstName VARCHAR(20),
                    lastName VARCHAR(20),
                    phone VARCHAR(40),
                    balance REAL
                );
                
                INSERT INTO customer (firstName, lastName, phone, balance) 
                VALUES ('Miras', 'Mels', '+7-701-456-78-85', 15000),('Akniyet', 'Baibolat', '+7-778-965-55-41', 14500),('Erkebulan', 'Alekenov', '+7-701-238-88-70', 170);
                """;
        Execute(sql);
    }

    @Override
    public Customer getById(String tableName, int id) throws SQLException {
        String sql = "select * from " + tableName + " where id = " + id + "";
        ResultSet resultSet = getResultSet(sql);
        resultSet.next();
        return new Customer(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"),
                resultSet.getString("phone"), resultSet.getFloat("balance"));
    }
}
