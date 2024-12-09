package com.tech.lunch.dto;

import com.tech.lunch.entity.Usuario;

public class LoginRequest {

    private String idInstitucional;
    private String passwordHash;

    // Constructor vacío para deserialización
    public LoginRequest() {
    }

    // Getters y setters
    public String getIdInstitucional() {
        return idInstitucional;
    }

    public void setIdInstitucional(String idInstitucional) {
        this.idInstitucional = idInstitucional;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = passwordHash;
    }

}
