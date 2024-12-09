package com.tech.lunch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;  // Relación con la entidad Usuario

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;  // La fecha de la reserva

    @Column(name = "fecha_hora_creacion", nullable = false)
    private LocalDateTime fechaHoraCreacion;  // La fecha y hora de creación de la reserva

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado;  // 'Pendiente', 'Confirmada', 'Cancelada'

    @Column(name = "codigo_reserva", nullable = false, unique = true)
    private String codigoReserva;  // Código único de la reserva

    /*
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    @JsonManagedReference  // Aquí es donde la relación se debe serializar
    private Set<ReservaItem> reservaItems;
    */

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<ReservaItem> reservaItems;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
}

