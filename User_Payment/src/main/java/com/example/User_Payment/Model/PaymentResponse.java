package com.example.User_Payment.Model;

public class PaymentResponse {
    private String fname;
    private String tid;
    private int orderId;
    private String itemName;
    private String quantity;
    private double amount;

    public String getQuantity() {
        return quantity;
    }

    public PaymentResponse setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTid() {
        return tid;
    }

    public PaymentResponse setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public PaymentResponse setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public PaymentResponse setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentResponse setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public PaymentResponse setFname(String fname) {
        this.fname = fname;
        return this;
    }

}
