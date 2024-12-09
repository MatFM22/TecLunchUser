package com.tech.lunch.controller;

import com.tech.lunch.entity.EstadoPedido;
import com.tech.lunch.entity.Pedido;
import com.tech.lunch.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido pedidoCreado = pedidoService.crearPedido(pedido);
        return new ResponseEntity<>(pedidoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.obtenerPedidoPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarEstado(@PathVariable Integer id, @RequestParam EstadoPedido estado) {
        Pedido pedidoActualizado = pedidoService.actualizarEstadoPedido(id, estado);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Integer id) {
        pedidoService.cancelarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
