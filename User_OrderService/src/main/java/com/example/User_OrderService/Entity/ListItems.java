package com.example.User_OrderService.Entity;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ListOfItems")
public class ListItems {

private int itemCode;
private String itemName;

    public int getItemCode() {
        return itemCode;
    }

    public ListItems setItemCode(int itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public ListItems setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }
}
