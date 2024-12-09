package com.tech.lunch.service;

import com.tech.lunch.entity.PedidoItem;
import com.tech.lunch.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoItemService {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    // Método para obtener todos los PedidoItems
    public List<PedidoItem> obtenerTodosLosPedidoItems() {
        return pedidoItemRepository.findAll();
    }

    // Obtener un PedidoItem por ID
    public PedidoItem obtenerPedidoItemPorId(Integer id) {
        Optional<PedidoItem> pedidoItem = pedidoItemRepository.findById(id);
        // Devuelve el valor si está presente, o null si no lo está
        return pedidoItem.orElse(null);
    }

    // Método para agregar un PedidoItem
    public PedidoItem agregarPedidoItem(PedidoItem pedidoItem) {
        return pedidoItemRepository.save(pedidoItem);
    }

    // Método para eliminar un PedidoItem
    public void eliminarPedidoItem(Integer id) {
        // Verifica si el PedidoItem existe antes de eliminarlo
        PedidoItem pedidoItem = obtenerPedidoItemPorId(id);
        pedidoItemRepository.delete(pedidoItem);
    }
}
