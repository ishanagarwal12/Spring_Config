package com.example.User_OrderService.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OrderIdSequence")
public class OrderIdSequenceGenerator {
    @Id
    private String id;
    private int seq;

    public int getSeq() {
        return seq;
    }

    public OrderIdSequenceGenerator setSeq(int seq) {
        this.seq = seq;
        return this;
    }

    public String getId() {
        return id;
    }

    public OrderIdSequenceGenerator setId(String id) {
        this.id = id;
        return this;
    }
}