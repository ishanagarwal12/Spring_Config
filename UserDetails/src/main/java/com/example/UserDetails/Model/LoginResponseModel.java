package com.example.UserDetails.Model;

import java.io.Serializable;

public class LoginResponseModel implements Serializable {
    private String email,uid;
    private static final long serialVersionUID = -4161418838111180364L;

    public String getEmail() {
        return email;
    }

    public LoginResponseModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public LoginResponseModel setUid(String uid) {
        this.uid = uid;
        return this;
    }
}
