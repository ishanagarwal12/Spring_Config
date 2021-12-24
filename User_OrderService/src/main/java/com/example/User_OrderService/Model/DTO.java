package com.example.User_OrderService.Model;

import com.example.User_OrderService.Entity.FeedBack;
import com.example.User_OrderService.Entity.OrderEntity;
import com.example.User_OrderService.Shared.UserEntity;

import java.util.List;
//import com.example.User_OrderService.Shared.UserEntity;

public class DTO {

    private List<UserEntity> userEntity;
    private String firstName;
    private String itemName;
    private int  quantity;
    private int itemCode;
    private int orderId;
    private double amount;
    private FeedBack feedBack;

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public DTO setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public DTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public DTO setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public DTO setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getItemCode() {
        return itemCode;
    }

    public DTO setItemCode(int itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public DTO setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public DTO setQuantity(int  quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public DTO setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
