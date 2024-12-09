package com.tech.lunch.controller;

import com.tech.lunch.entity.Reserva;
import com.tech.lunch.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Crear una nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    // Obtener una reserva por código
    @GetMapping("/{codigoReserva}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable String codigoReserva) {
        Optional<Reserva> reservaOpt = reservaService.obtenerReservaPorCodigo(codigoReserva);
        if (reservaOpt.isPresent()) {
            return new ResponseEntity<>(reservaOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Listar todas las reservas
    @GetMapping
    public ResponseEntity<Iterable<Reserva>> obtenerTodasLasReservas() {
        Iterable<Reserva> reservas = reservaService.obtenerTodasLasReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    // Cancelar una reserva
    @PutMapping("/cancelar/{codigoReserva}")
    public ResponseEntity<Reserva> cancelarReserva(@PathVariable String codigoReserva) {
        Optional<Reserva> reservaOpt = reservaService.cancelarReserva(codigoReserva);
        if (reservaOpt.isPresent()) {
            return new ResponseEntity<>(reservaOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
