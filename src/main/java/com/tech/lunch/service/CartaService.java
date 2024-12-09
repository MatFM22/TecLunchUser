package com.tech.lunch.service;

import com.tech.lunch.entity.Carta;
import com.tech.lunch.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    // Obtener todas las cartas
    public List<Carta> obtenerTodasLasCartas() {
        return cartaRepository.findAll();
    }

    // Obtener una carta por ID
    public Optional<Carta> obtenerCartaPorId(Integer id) {
        return cartaRepository.findById(id);
    }

    // Crear una nueva carta
    public Carta crearCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    // Actualizar una carta
    public Carta actualizarCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    // Eliminar una carta
    public void eliminarCarta(Integer id) {
        cartaRepository.deleteById(id);
    }
}
