package com.tech.lunch.controller;

import com.tech.lunch.entity.Carta;
import com.tech.lunch.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    // Obtener todas las cartas
    @GetMapping
    public List<Carta> obtenerCartas() {
        return cartaService.obtenerTodasLasCartas();
    }

    // Obtener una carta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carta> obtenerCartaPorId(@PathVariable Integer id) {
        Optional<Carta> carta = cartaService.obtenerCartaPorId(id);
        return carta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva carta
    @PostMapping
    public ResponseEntity<Carta> crearCarta(@RequestBody Carta carta) {
        Carta nuevaCarta = cartaService.crearCarta(carta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCarta);
    }

    // Actualizar una carta
    @PutMapping("/{id}")
    public ResponseEntity<Carta> actualizarCarta(@PathVariable Integer id, @RequestBody Carta carta) {
        carta.setId(id);
        Carta cartaActualizada = cartaService.actualizarCarta(carta);
        return ResponseEntity.ok(cartaActualizada);
    }

    // Eliminar una carta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarta(@PathVariable Integer id) {
        cartaService.eliminarCarta(id);
        return ResponseEntity.noContent().build();
    }
}
