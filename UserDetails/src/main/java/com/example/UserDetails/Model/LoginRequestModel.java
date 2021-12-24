package com.example.UserDetails.Model;

public class LoginRequestModel {
    private String password,email;
    private String uid;

    public String getUid() {
        return uid;
    }

    public LoginRequestModel setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequestModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginRequestModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
