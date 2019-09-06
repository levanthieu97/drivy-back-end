package com.thieu.setup.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApi {

    @JsonProperty("user_info")
    private User account;

    private String token;

    private String role;

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
