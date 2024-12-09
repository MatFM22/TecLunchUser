package com.tech.lunch.dto;

public class LoginResponse {

    private String status;
    private String message;

    public LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
