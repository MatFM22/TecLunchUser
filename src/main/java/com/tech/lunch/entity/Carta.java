package com.tech.lunch.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Carta")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private LocalDate fecha;

    private Boolean disponible;

    /*
    // Relación con la tabla intermedia CartaItem
    @OneToMany(mappedBy = "carta")
    private Set<CartaItem> cartaItems = new HashSet<>();
    */

    @OneToMany(mappedBy = "carta", cascade = CascadeType.ALL)
    @JsonManagedReference // Indica que esta parte de la relación debe ser serializada
    private Set<CartaItem> cartaItems;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Set<CartaItem> getCartaItems() {
        return cartaItems;
    }

    public void setCartaItems(Set<CartaItem> cartaItems) {
        this.cartaItems = cartaItems;
    }
}

