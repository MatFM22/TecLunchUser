package com.tech.lunch.entity;

import jakarta.persistence.*;
import java.util.regex.Pattern;

@Entity
@Table(name = "Usuario")

public class Usuario {

    @Id
    @Column(name = "id_institucional", length = 6)
    private String idInstitucional;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    private String rol;
    private String preferenciasAlimenticias;
    private String restriccionesDieteticas;
    private String habitosConsumo;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_staff")
    private Boolean isStaff;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "password_hash")
    private String passwordHash;

    // Getter y Setter manualmente
    public String getIdInstitucional() {
        return idInstitucional;
    }

    public void setIdInstitucional(String idInstitucional) {
        this.idInstitucional = idInstitucional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPreferenciasAlimenticias() {
        return preferenciasAlimenticias;
    }

    public void setPreferenciasAlimenticias(String preferenciasAlimenticias) {
        this.preferenciasAlimenticias = preferenciasAlimenticias;
    }

    public String getRestriccionesDieteticas() {
        return restriccionesDieteticas;
    }

    public void setRestriccionesDieteticas(String restriccionesDieteticas) {
        this.restriccionesDieteticas = restriccionesDieteticas;
    }

    public String getHabitosConsumo() {
        return habitosConsumo;
    }

    public void setHabitosConsumo(String habitosConsumo) {
        this.habitosConsumo = habitosConsumo;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Método que valida que el correo termine en @tecsup.edu.pe
    public void validarCorreo() {
        String regex = "^[a-zA-Z0-9_.+-]+@tecsup\\.edu\\.pe$";
        if (!Pattern.matches(regex, this.correo)) {
            throw new IllegalArgumentException("El correo debe tener el dominio @tecsup.edu.pe.");
        }
    }

    // Validación antes de persistir el objeto en la base de datos
    @PrePersist
    @PreUpdate
    public void prePersist() {
        validarCorreo();
    }
}

