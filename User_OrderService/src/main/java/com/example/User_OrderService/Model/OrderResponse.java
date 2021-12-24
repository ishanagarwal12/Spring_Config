package com.example.User_OrderService.Model;

public class OrderResponse {
    private String fname;
    private String itemName;
    private String quantity;
    private int itemCode;
    private int orderId;
    private double amount;

    public int getItemCode() {
        return itemCode;
    }

    public OrderResponse setItemCode(int itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public OrderResponse setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderResponse setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public OrderResponse setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrderResponse setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }


    public double getAmount() {
        return amount;
    }

    public OrderResponse setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
