package com.tech.lunch.service;

import com.tech.lunch.entity.Retroalimentacion;
import com.tech.lunch.repository.RetroalimentacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetroalimentacionService {

    @Autowired
    private RetroalimentacionRepository retroalimentacionRepository;

    // Método para crear una nueva retroalimentación
    public Retroalimentacion agregarRetroalimentacion(Retroalimentacion retroalimentacion) {
        return retroalimentacionRepository.save(retroalimentacion);
    }

    // Método para obtener todas las retroalimentaciones
    public List<Retroalimentacion> obtenerTodasLasRetroalimentaciones() {
        return retroalimentacionRepository.findAll();
    }

    // Método para obtener retroalimentación por ID
    public Retroalimentacion obtenerRetroalimentacionPorId(Integer id) {
        return retroalimentacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retroalimentación no encontrada"));
    }

    // Método para eliminar retroalimentación
    public void eliminarRetroalimentacion(Integer id) {
        retroalimentacionRepository.deleteById(id);
    }
}
