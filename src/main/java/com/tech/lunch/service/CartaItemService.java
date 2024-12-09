package com.tech.lunch.service;

import com.tech.lunch.entity.CartaItem;
import com.tech.lunch.repository.CartaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaItemService {

    @Autowired
    private CartaItemRepository cartaItemRepository;

    // Crear un nuevo CartaItem
    public CartaItem agregarCartaItem(CartaItem cartaItem) {
        return cartaItemRepository.save(cartaItem);
    }

    // Obtener todos los CartaItems
    public List<CartaItem> obtenerTodos() {
        return cartaItemRepository.findAll();
    }

    // Eliminar un CartaItem
    public void eliminarCartaItem(Integer id) {
        cartaItemRepository.deleteById(id);
    }
}
