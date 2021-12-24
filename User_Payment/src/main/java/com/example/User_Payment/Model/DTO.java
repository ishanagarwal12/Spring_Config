package com.example.User_Payment.Model;

import java.util.List;

public class DTO {
    private String tid;
    private List<OrderEntity> orderEntity;

    public String getTid() {
        return tid;
    }

    public DTO setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public List<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public DTO setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
        return this;
    }
}
