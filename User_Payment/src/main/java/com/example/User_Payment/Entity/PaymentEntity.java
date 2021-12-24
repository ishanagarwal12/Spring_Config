package com.example.User_Payment.Entity;

import com.example.User_Payment.Model.OrderEntity;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("PaymentData")
public class PaymentEntity
{
    private String tid;
    private List<OrderEntity> orderEntity;

    public List<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public PaymentEntity setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
        return this;
    }

    public String getTid() {
        return tid;
    }

    public PaymentEntity setTid(String tid) {
        this.tid = tid;
        return this;
    }

}
