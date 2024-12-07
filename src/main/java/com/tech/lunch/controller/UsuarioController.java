package com.tech.lunch.controller;

import com.tech.lunch.entity.Usuario;
import com.tech.lunch.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener un usuario por id
    @GetMapping("/{idInstitucional}")
    public Usuario getUsuario(@PathVariable String idInstitucional) {
        return usuarioService.getUsuarioById(idInstitucional);
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
        // Si hay errores de validación, devuelve los errores
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Errores de validación: ");
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(" ");
            }
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }

        // Validar el correo antes de continuar
        try {
            usuario.validarCorreo(); // Llamamos al método de validación en la entidad Usuario
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // En caso de error, enviamos el mensaje
        }

        // Si pasa la validación, creamos el usuario
        Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Actualizar un usuario
    @PutMapping("/{idInstitucional}")
    public Usuario updateUsuario(@PathVariable String idInstitucional, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(idInstitucional, usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{idInstitucional}")
    public void deleteUsuario(@PathVariable String idInstitucional) {
        usuarioService.deleteUsuario(idInstitucional);
    }
}

