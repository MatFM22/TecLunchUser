package com.tech.lunch.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    private Boolean disponible;

    @Column(name = "imagen", nullable = true)
    private String imagen;  // Campo para la imagen

    private String ingredientes;  // Campo para los ingredientes

    private Integer calorias;  // Campo para las calorías

    private Float proteinas;  // Campo para las proteínas

    private Float grasas;  // Campo para las grasas

    private Float carbohidratos;  // Campo para los carbohidratos

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Float getProteinas() {
        return proteinas;
    }

    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    public Float getGrasas() {
        return grasas;
    }

    public void setGrasas(Float grasas) {
        this.grasas = grasas;
    }

    public Float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
}

