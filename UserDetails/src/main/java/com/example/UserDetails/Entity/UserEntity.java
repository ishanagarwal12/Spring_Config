package com.example.UserDetails.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("LoginData")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -4161418838111180364L;
    private String uid;
    private String fname;
    private String lname;
    private String email;
    private String password;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public UserEntity setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public UserEntity setUid(String uid) {
        this.uid = uid;
        return this;
    }



    public String getFname() {
        return fname;
    }

    public UserEntity setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public UserEntity setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
