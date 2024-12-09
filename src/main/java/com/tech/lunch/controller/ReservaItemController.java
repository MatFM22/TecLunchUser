package com.tech.lunch.controller;

import com.tech.lunch.entity.ReservaItem;
import com.tech.lunch.service.ReservaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserva-items")
public class ReservaItemController {

    @Autowired
    private ReservaItemService reservaItemService;

    // Crear un nuevo ReservaItem
    @PostMapping
    public ResponseEntity<ReservaItem> crearReservaItem(@RequestBody ReservaItem reservaItem) {
        ReservaItem nuevoReservaItem = reservaItemService.crearReservaItem(reservaItem);
        return new ResponseEntity<>(nuevoReservaItem, HttpStatus.CREATED);
    }

    // Listar todos los ReservaItems
    @GetMapping
    public ResponseEntity<Iterable<ReservaItem>> obtenerTodosLosReservaItems() {
        Iterable<ReservaItem> reservaItems = reservaItemService.obtenerTodosLosReservaItems();
        return new ResponseEntity<>(reservaItems, HttpStatus.OK);
    }

    // Eliminar un ReservaItem por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReservaItem(@PathVariable Integer id) {
        reservaItemService.eliminarReservaItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
