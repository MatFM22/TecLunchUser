package com.tech.lunch.service;

import com.tech.lunch.entity.Categoria;
import com.tech.lunch.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por ID
    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Crear una nueva categoría
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría
    public Categoria actualizarCategoria(Integer id, Categoria categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    // Eliminar una categoría
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
