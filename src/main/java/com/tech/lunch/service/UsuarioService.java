package com.tech.lunch.service;

import com.tech.lunch.entity.Categoria;
import com.tech.lunch.entity.Usuario;
import com.tech.lunch.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todas los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(String idInstitucional) {
        return usuarioRepository.findById(idInstitucional).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(String idInstitucional, Usuario usuario) {
        if (usuarioRepository.existsById(idInstitucional)) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deleteUsuario(String idInstitucional) {
        usuarioRepository.deleteById(idInstitucional);
    }

}
