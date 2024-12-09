package com.tech.lunch.service;

import com.tech.lunch.entity.Reserva;
import com.tech.lunch.entity.EstadoReserva;
import com.tech.lunch.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Crear una nueva reserva
    public Reserva crearReserva(Reserva reserva) {
        reserva.setFechaHoraCreacion(LocalDateTime.now());
        reserva.setEstado(EstadoReserva.Pendiente);  // Estado por defecto
        reserva.setCodigoReserva(generarCodigoReserva());  // Generar un código único
        return reservaRepository.save(reserva);
    }

    // Obtener una reserva por código
    public Optional<Reserva> obtenerReservaPorCodigo(String codigoReserva) {
        return reservaRepository.findByCodigoReserva(codigoReserva);
    }

    // Cancelar una reserva
    public Optional<Reserva> cancelarReserva(String codigoReserva) {
        Optional<Reserva> reservaOpt = reservaRepository.findByCodigoReserva(codigoReserva);
        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            reserva.setEstado(EstadoReserva.Cancelada);
            return Optional.of(reservaRepository.save(reserva));
        }
        return Optional.empty();
    }

    // Listar todas las reservas
    public Iterable<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    // Método para generar un código único de reserva (puedes usar un UUID)
    private String generarCodigoReserva() {
        return UUID.randomUUID().toString().substring(0, 15); // Limitar el código a 15 caracteres
    }
}
