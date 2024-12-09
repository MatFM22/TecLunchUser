package com.tech.lunch.service;

import com.tech.lunch.entity.Carrito;
import com.tech.lunch.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    // Crear un nuevo carrito
    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    // Obtener un carrito por su ID
    public Carrito obtenerCarritoPorId(Integer id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    // Obtener todos los carritos
    public List<Carrito> obtenerTodosLosCarritos() {
        return carritoRepository.findAll();
    }

    // Eliminar un carrito
    public void eliminarCarrito(Integer id) {
        carritoRepository.deleteById(id);
    }
}
