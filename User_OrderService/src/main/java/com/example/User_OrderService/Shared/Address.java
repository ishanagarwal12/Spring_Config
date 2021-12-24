package com.example.User_OrderService.Shared;

//import org.springframework.data.mongodb.core.mapping.Document;
public class Address {
    private String city;
    private String streetName;
    private int pinCode;

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public int getPinCode() {
        return pinCode;
    }

    public Address setPinCode(int pinCode) {
        this.pinCode = pinCode;
        return this;
    }
}
