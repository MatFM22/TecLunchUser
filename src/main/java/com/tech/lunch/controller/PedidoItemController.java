package com.tech.lunch.controller;

import com.tech.lunch.entity.PedidoItem;
import com.tech.lunch.service.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido-items")
public class PedidoItemController {

    @Autowired
    private PedidoItemService pedidoItemService;

    // Obtener todos los PedidoItems
    @GetMapping
    public List<PedidoItem> obtenerTodosLosPedidoItems() {
        return pedidoItemService.obtenerTodosLosPedidoItems();
    }

    // Obtener un PedidoItem por ID
    @GetMapping("/{id}")
    public PedidoItem obtenerPedidoItemPorId(@PathVariable Integer id) {
        return pedidoItemService.obtenerPedidoItemPorId(id);
    }

    // Crear un nuevo PedidoItem
    @PostMapping
    public ResponseEntity<PedidoItem> agregarPedidoItem(@RequestBody PedidoItem pedidoItem) {
        PedidoItem nuevoPedidoItem = pedidoItemService.agregarPedidoItem(pedidoItem);
        return ResponseEntity.ok(nuevoPedidoItem);
    }

    // Eliminar un PedidoItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedidoItem(@PathVariable Integer id) {
        pedidoItemService.eliminarPedidoItem(id);
        return ResponseEntity.noContent().build();
    }
}
