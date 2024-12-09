package com.tech.lunch.controller;

import com.tech.lunch.entity.Transaccion;
import com.tech.lunch.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    // Obtener todas las transacciones
    @GetMapping
    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionService.obtenerTodasLasTransacciones();
    }

    // Obtener una transacción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerTransaccionPorId(@PathVariable Integer id) {
        Optional<Transaccion> transaccion = transaccionService.obtenerTransaccionPorId(id);
        return transaccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva transacción
    @PostMapping
    public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {
        Transaccion nuevaTransaccion = transaccionService.crearTransaccion(transaccion);
        return ResponseEntity.ok(nuevaTransaccion);
    }

    // Eliminar una transacción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Integer id) {
        transaccionService.eliminarTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}
