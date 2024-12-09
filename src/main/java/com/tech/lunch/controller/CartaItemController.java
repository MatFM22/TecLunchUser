package com.tech.lunch.controller;

import com.tech.lunch.entity.CartaItem;
import com.tech.lunch.service.CartaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carta-items")
public class CartaItemController {

    @Autowired
    private CartaItemService cartaItemService;

    // Crear un nuevo CartaItem
    @PostMapping
    public ResponseEntity<CartaItem> agregarCartaItem(@RequestBody CartaItem cartaItem) {
        CartaItem nuevoCartaItem = cartaItemService.agregarCartaItem(cartaItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCartaItem);
    }

    // Obtener todos los CartaItems
    @GetMapping
    public List<CartaItem> obtenerCartaItems() {
        return cartaItemService.obtenerTodos();
    }

    // Eliminar un CartaItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCartaItem(@PathVariable Integer id) {
        cartaItemService.eliminarCartaItem(id);
        return ResponseEntity.noContent().build();
    }
}
