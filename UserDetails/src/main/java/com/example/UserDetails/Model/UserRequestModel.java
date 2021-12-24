package com.example.UserDetails.Model;

import com.example.UserDetails.Entity.Address;

public class UserRequestModel {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public UserRequestModel setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getLname() {        return lname;
    }

    public UserRequestModel setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRequestModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public UserRequestModel setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRequestModel setEmail(String email) {
        this.email = email;
        return this;
    }


}
