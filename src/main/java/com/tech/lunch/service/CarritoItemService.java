package com.tech.lunch.service;

import com.tech.lunch.entity.CarritoItem;
import com.tech.lunch.repository.CarritoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoItemService {

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    // Crear un nuevo CarritoItem
    public CarritoItem agregarCarritoItem(CarritoItem carritoItem) {
        return carritoItemRepository.save(carritoItem);
    }

    // Obtener un CarritoItem por su ID
    public CarritoItem obtenerCarritoItemPorId(Integer id) {
        return carritoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarritoItem no encontrado"));
    }

    // Obtener todos los CarritoItems
    public List<CarritoItem> obtenerTodosLosCarritoItems() {
        return carritoItemRepository.findAll();
    }

    // Eliminar un CarritoItem
    public void eliminarCarritoItem(Integer id) {
        carritoItemRepository.deleteById(id);
    }
}
