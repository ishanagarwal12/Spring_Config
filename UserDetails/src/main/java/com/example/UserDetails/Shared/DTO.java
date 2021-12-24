package com.example.UserDetails.Shared;

import com.example.UserDetails.Entity.Address;
import com.example.UserDetails.Entity.UserEntity;

import java.io.Serializable;

public class DTO implements Serializable {
    private String uid;
    private String fname,lname,email,password;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public DTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    private static final long serialVersionUID = -4161418838111180364L;
//    private OrderEntity orderEntity;
//    private UserEntity userEntity;

    public String getUid() {
        return uid;
    }

    public DTO setUid(String uid) {
        this.uid = uid;
        return this;
    }

    private String Status;

    public String getStatus() {
        return Status;
    }

    public DTO setStatus(String status) {
        Status = status;
        return this;
    }



    public String getFname() {
        return fname;
    }

    public DTO setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public DTO setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DTO setPassword(String password) {
        this.password = password;
        return this;
    }

}
