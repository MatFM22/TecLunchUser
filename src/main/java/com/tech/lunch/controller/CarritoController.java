package com.tech.lunch.controller;

import com.tech.lunch.entity.Carrito;
import com.tech.lunch.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Crear un nuevo carrito
    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito nuevoCarrito = carritoService.crearCarrito(carrito);
        return ResponseEntity.ok(nuevoCarrito);
    }

    // Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Integer id) {
        Carrito carrito = carritoService.obtenerCarritoPorId(id);
        return ResponseEntity.ok(carrito);
    }

    // Obtener todos los carritos
    @GetMapping
    public List<Carrito> obtenerTodosLosCarritos() {
        return carritoService.obtenerTodosLosCarritos();
    }

    // Eliminar un carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Integer id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
