package com.company;

public class Order {
    private int id;
    private int customerId;
    private int itemId;
    private int quantity;
    private float totalPrice;

    public Order() {

    }

    public Order(int id, int customId, int itemId, int quantity, float totalPrice) {
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

    public void setQuantity(int quantity) {
        Item s = new Item();
        s.getId(itemId);
        System.out.println(s.getDesc());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
