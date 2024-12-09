package com.tech.lunch.service;

import com.tech.lunch.entity.EstadoPedido;
import com.tech.lunch.entity.Pedido;
import com.tech.lunch.repository.PedidoItemRepository;
import com.tech.lunch.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setFechaPedido(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.Reservado);  // El estado inicial es 'Reservado'
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido actualizarEstadoPedido(Integer id, EstadoPedido estado) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(estado);
        return pedidoRepository.save(pedido);
    }

    public void cancelarPedido(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(EstadoPedido.Cancelado);
        pedidoRepository.save(pedido);
    }
}
