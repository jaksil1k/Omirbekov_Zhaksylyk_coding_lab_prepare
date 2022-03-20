package com.company;

import com.company.connection.CustomerConnection;
import com.company.connection.ItemConnection;
import com.company.exception.CustomerException;
import com.company.exception.ItemException;
import com.company.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Order {
    private int id;
    private int customerId;
    private int itemId;
    private int quantity;
    private float totalPrice;

    public Order() {

    }

    public Order(int id, int customId, int itemId, int quantity, float totalPrice) {
        Connection connection = ConnectionManager.open();
        this.id = id;
        this.customerId = customId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCustomId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomId() {
        return customerId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setQuantity(int quantity) throws SQLException, ItemException {

        Item item = new ItemConnection().getById("items", this.itemId);

        if (quantity > item.getQuantity()){
            throw new ItemException("We don't have enough" + item.getDesc());
        } else {
            new ItemConnection().updateTableById("items", "quantity", this.itemId, item.getQuantity() - quantity);
            this.quantity = quantity;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTotalPrice(float totalPrice) throws SQLException, CustomerException {

        Customer customer = new CustomerConnection().getById("customer", this.customerId);

        if (totalPrice > customer.getBalance()){
            throw new CustomerException("You don't have enough balance");
        }else {
            new CustomerConnection().updateTableById("customer", "balance", this.customerId,
                    customer.getBalance() - totalPrice);
            this.totalPrice = totalPrice;
        }
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
