package com.example.User_OrderService.Entity;
import com.example.User_OrderService.Shared.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@Document("OrderDetails")
public class OrderEntity {
    @Transient
    public static final String sequence_name="order_sequence";

    private List<UserEntity> userEntity;
    private String firstName;
    private String itemName;
    private int  quantity;
    private int itemCode;
    @Id
    private int orderId;
    private double amount;
    private FeedBack feedBack;

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public OrderEntity setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public OrderEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public OrderEntity setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
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