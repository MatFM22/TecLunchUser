package com.tech.lunch.service;

import com.tech.lunch.entity.Transaccion;
import com.tech.lunch.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    // Obtener todas las transacciones
    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionRepository.findAll();
    }

    // Obtener una transacción por ID
    public Optional<Transaccion> obtenerTransaccionPorId(Integer id) {
        return transaccionRepository.findById(id);
    }

    // Crear una nueva transacción
    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    // Eliminar una transacción por ID
    public void eliminarTransaccion(Integer id) {
        transaccionRepository.deleteById(id);
    }
}
