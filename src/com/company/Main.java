package com.company;

import com.company.connection.CustomerConnection;
import com.company.connection.ItemConnection;
import com.company.util.ConnectionManager;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static final String customerTableName = "customer";
    private static final String itemTableName = "items";
    private static final String orderedBy = "id";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Class <Driver> driverClass = Driver.class;
        CustomerConnection customerConnection = new CustomerConnection();
        ItemConnection itemConnection = new ItemConnection();

        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            customerConnection.createTable();
            itemConnection.createTable();

            System.out.println("Please select a Customer from the list by his id");
            customerConnection.printAll(customerTableName, orderedBy);

            int customerId = scanner.nextInt();
            Customer customer  = customerConnection.getById(customerTableName, customerId);

            System.out.println("Please select id of an item that " + customer.getFname() + " wants to order");
            itemConnection.printAll(itemTableName, orderedBy);

            int itemId = scanner.nextInt();
            Item item = itemConnection.getById(itemTableName, itemId);

            System.out.println("Please Input, how many " + item.getDesc() + " does " + customer.getFname()
                    + " want to order:");
            int itemQuantity = scanner.nextInt();
            Order order = new Order(1, customerId, itemId, itemQuantity, item.getPrice() * itemQuantity);

            System.out.println(customer);
            System.out.println(item);
            itemConnection.deleteTable(itemTableName);
            customerConnection.deleteTable(customerTableName);
        }
    }
}