package com.example.UserDetails.Shared;
public class OrderEntity {
//    @Transient
//    public static final String sequence_name="order_sequence";
    private double amount;
private int orderId;
private int itemCode;
    private String itemName,quantity;
    private String uid;

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



    public String getUid() {
        return uid;
    }

    public OrderEntity setUid(String uid) {
        this.uid = uid;
        return this;
    }



    public double getAmount() {
        return amount;
    }

    public OrderEntity setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrderEntity setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }
}