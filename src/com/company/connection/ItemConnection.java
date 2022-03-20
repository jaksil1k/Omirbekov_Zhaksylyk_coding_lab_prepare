package com.company.connection;

import com.company.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemConnection extends SuperConnection{
    public ItemConnection(){
        super();
    }

    @Override
    public Item getById(String tableName, int id) throws SQLException {
        String sql = "select * from " + tableName + " where id = " + id + "";
        ResultSet resultSet = getResultSet(sql);
        resultSet.next();
        return new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getFloat( "price"),
                resultSet.getInt("quantity"));
    }

    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS items(
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(20),
                    price REAL,
                    quantity INT
                );
                INSERT INTO items (name, price, quantity)
                VALUES ('PS5', 450, 6), ('Ryzen 5900', 300, 10), ('SSD', 150, 5);
                """;
        Execute(sql);
    }
}
