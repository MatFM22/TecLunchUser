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
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No hay usuarios
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK); // Devuelve la lista de usuarios
    }

    // Obtener un usuario por id
    @GetMapping("/{idInstitucional}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable String idInstitucional) {
        Usuario usuario = usuarioService.getUsuarioById(idInstitucional);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK); // Usuario encontrado
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario no encontrado
        }
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
            usuario.validarCorreo();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // En caso de error, enviamos el mensaje
        }

        // Si pasa la validación, creamos el usuario
        Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Actualizar un usuario
    @PutMapping("/{idInstitucional}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String idInstitucional, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.getUsuarioById(idInstitucional);
        if (usuarioExistente != null) {
            usuario.setIdInstitucional(idInstitucional);  // Mantener el mismo id
            Usuario usuarioActualizado = usuarioService.updateUsuario(idInstitucional, usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si no se encuentra el usuario
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{idInstitucional}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String idInstitucional) {
        Usuario usuarioExistente = usuarioService.getUsuarioById(idInstitucional);
        if (usuarioExistente != null) {
            usuarioService.deleteUsuario(idInstitucional);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Usuario eliminado correctamente
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario no encontrado
        }
    }
}
