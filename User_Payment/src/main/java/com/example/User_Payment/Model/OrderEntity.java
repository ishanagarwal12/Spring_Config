package com.example.User_Payment.Model;

public class OrderEntity   {

    private String firstName;
    private String itemName;
    private int  quantity;
    private int itemCode;
    private int orderId;
    private double amount;

    public String getFirstName() {
        return firstName;
    }

    public OrderEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getItemCode() {
        return itemCode;
    }

    public OrderEntity setItemCode(int itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public OrderEntity setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderEntity setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public OrderEntity setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}