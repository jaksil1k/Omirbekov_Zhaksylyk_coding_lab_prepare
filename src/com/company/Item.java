package com.company;

public class Item {
    private int id;
    private String description;
    private float price;
    private int quantity;

    public Item() {
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity;
    }

    public Item(int id, String description, float price, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId(int itemId) {
        return id;
    }

    public String getDesc() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
