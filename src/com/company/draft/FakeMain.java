//package com.company;
//
//import com.company.util.ConnectionManager;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//
//        var connection = ConnectionManager.open();
//
//        while (true){
//            System.out.println("Please select a Customer from the list by his id");
//
//            Statement statement = connection.createStatement();
//            String SQL_SELECT_CUSTOMERS = "select * from customer order by id";
//            ResultSet resultCustomer =  statement.executeQuery(SQL_SELECT_CUSTOMERS);
//
//            while (resultCustomer.next()){
//                Customer customer = new Customer(resultCustomer.getInt("id"), resultCustomer.getString("firstName"),
//                        resultCustomer.getString("lastName"), resultCustomer.getString("phone"), resultCustomer.getFloat("balance"));
//                System.out.println(customer);
//            }
//
//
//            String SQL_SELECT_CUSTOMER = "select * from customer where id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CUSTOMER);
//            int customerId = scanner.nextInt();
//            preparedStatement.setInt(1, customerId);
//            resultCustomer = preparedStatement.executeQuery();
//            resultCustomer.next();
//            Customer customer = new Customer(resultCustomer.getInt("id"), resultCustomer.getString("firstName"),
//                    resultCustomer.getString("lastName"), resultCustomer.getString("phone"), resultCustomer.getFloat("balance"));
//
//
//            System.out.println("Please select id od an item that " + customer.getFname() + " wants to order");
//            String SQL_SELECT_ITEMS = "select * from items order by id";
//            ResultSet resultItem = statement.executeQuery(SQL_SELECT_ITEMS);
//            while (resultItem.next()){
//                Item item = new Item(resultItem.getInt("id"), resultItem.getString("name"), resultItem.getFloat("price"),
//                        resultItem.getInt("quantity"));
//                System.out.println(item);
//            }
//
//
//            int itemId = scanner.nextInt();
//            String SQL_SELECT_ITEM = "select * from items where id = ?";
//            preparedStatement = connection.prepareStatement(SQL_SELECT_ITEM);
//            preparedStatement.setInt(1, itemId);
//            resultItem = preparedStatement.executeQuery();
//            resultItem.next();
//            Item item = new Item(resultItem.getInt("id"), resultItem.getString("name"), resultItem.getFloat("price"),
//                    resultItem.getInt("quantity"));
//
//
//            System.out.println("Please Input, how many " + item.getDesc() + " does want to order:");
//            int itemQuantity;
//            while (true){
//                itemQuantity = scanner.nextInt();
//                if (itemQuantity > item.getQuantity()){
//                    System.err.println("We don't have enough " + item.getDesc() + ". Please input again");
//                }else if (itemQuantity * item.getPrice() > customer.getBalance()){
//                    System.err.println("You don't have enough balance. Please input again");
//                }else {
//                    break;
//                }
//            }
//
//
//            String updateItem = """
//                    update items set quantity = ? where id = ?
//                    """;
//            String updateCustomer = "update customer set balance = ? where id = ?";
//            preparedStatement = connection.prepareStatement(updateItem);
//            preparedStatement.setInt(1, item.getQuantity() - itemQuantity);
//            preparedStatement.setInt(2, itemId);
//            preparedStatement.executeUpdate();
//            preparedStatement = connection.prepareStatement(updateCustomer);
//            preparedStatement.setFloat(1, customer.getBalance() - (itemQuantity * item.getPrice()));
//            preparedStatement.setInt(2, customer.getId());
//            preparedStatement.executeUpdate();
//
//            resultCustomer =  statement.executeQuery(SQL_SELECT_CUSTOMERS);
//
//            while (resultCustomer.next()){
//                customer = new Customer(resultCustomer.getInt("id"), resultCustomer.getString("firstName"),
//                        resultCustomer.getString("lastName"), resultCustomer.getString("phone"), resultCustomer.getFloat("balance"));
//                System.out.println(customer);
//            }
//
//
//            resultItem = statement.executeQuery(SQL_SELECT_ITEMS);
//            while (resultItem.next()){
//                item = new Item(resultItem.getInt("id"), resultItem.getString("name"), resultItem.getFloat("price"),
//                        resultItem.getInt("quantity"));
//                System.out.println(item);
//            }
//        }
//    }
//}
