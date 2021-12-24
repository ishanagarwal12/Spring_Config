package com.example.UserDetails.Model;

import com.example.UserDetails.Entity.Address;

public class UserResponseModel {
    private String email;
    private String fname;
    private String lname;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public UserResponseModel setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public UserResponseModel setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public UserResponseModel setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseModel setEmail(String email) {
        this.email = email;
        return this;
    }

}
