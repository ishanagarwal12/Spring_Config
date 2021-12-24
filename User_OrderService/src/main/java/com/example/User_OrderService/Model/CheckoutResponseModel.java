package com.example.User_OrderService.Model;



public class CheckoutResponseModel  {
    private String fname;
    private String itemName;
    private int quantity;
    private int itemCode;
    private int orderId;
    private double amount;


    public int getQuantity() {
        return quantity;
    }

    public CheckoutResponseModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public CheckoutResponseModel setFname(String fname) {
        this.fname = fname;
        return this;
    }


    public String getItemName() {
        return itemName;
    }

    public CheckoutResponseModel setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public int getItemCode() {
        return itemCode;
    }

    public CheckoutResponseModel setItemCode(int itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public CheckoutResponseModel setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public CheckoutResponseModel setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

}