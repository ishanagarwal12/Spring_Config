package com.example.User_OrderService.Model;

public class OrderRequest {
    private String itemName,quantity;
    private int ItemCode;
    private double amount;
    private String fname;

    public String getFname() {
        return fname;
    }

    public OrderRequest setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public OrderRequest setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrderRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getItemCode() {
        return ItemCode;
    }

    public OrderRequest setItemCode(int itemCode) {
        ItemCode = itemCode;
        return this;
    }
    public double getAmount() {
        return amount;
    }

    public OrderRequest setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
