package com.tech.lunch.controller;

import com.tech.lunch.entity.CarritoItem;
import com.tech.lunch.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito-items")
public class CarritoItemController {

    @Autowired
    private CarritoItemService carritoItemService;

    // Crear un nuevo CarritoItem
    @PostMapping
    public ResponseEntity<CarritoItem> agregarCarritoItem(@RequestBody CarritoItem carritoItem) {
        CarritoItem nuevoCarritoItem = carritoItemService.agregarCarritoItem(carritoItem);
        return ResponseEntity.ok(nuevoCarritoItem);
    }

    // Obtener un CarritoItem por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarritoItem> obtenerCarritoItemPorId(@PathVariable Integer id) {
        CarritoItem carritoItem = carritoItemService.obtenerCarritoItemPorId(id);
        return ResponseEntity.ok(carritoItem);
    }

    // Obtener todos los CarritoItems
    @GetMapping
    public List<CarritoItem> obtenerTodosLosCarritoItems() {
        return carritoItemService.obtenerTodosLosCarritoItems();
    }

    // Eliminar un CarritoItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarritoItem(@PathVariable Integer id) {
        carritoItemService.eliminarCarritoItem(id);
        return ResponseEntity.noContent().build();
    }

}
