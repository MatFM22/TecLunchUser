package com.tech.lunch.controller;

import com.tech.lunch.entity.Retroalimentacion;
import com.tech.lunch.service.RetroalimentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retroalimentaciones")
public class RetroalimentacionController {

    @Autowired
    private RetroalimentacionService retroalimentacionService;

    // Obtener todas las retroalimentaciones
    @GetMapping
    public List<Retroalimentacion> obtenerTodasLasRetroalimentaciones() {
        return retroalimentacionService.obtenerTodasLasRetroalimentaciones();
    }

    // Obtener una retroalimentación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Retroalimentacion> obtenerRetroalimentacionPorId(@PathVariable Integer id) {
        Retroalimentacion retroalimentacion = retroalimentacionService.obtenerRetroalimentacionPorId(id);
        return ResponseEntity.ok(retroalimentacion);
    }

    // Crear una nueva retroalimentación
    @PostMapping
    public ResponseEntity<Retroalimentacion> crearRetroalimentacion(@RequestBody Retroalimentacion retroalimentacion) {
        Retroalimentacion nuevaRetroalimentacion = retroalimentacionService.agregarRetroalimentacion(retroalimentacion);
        return ResponseEntity.ok(nuevaRetroalimentacion);
    }

    // Eliminar una retroalimentación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRetroalimentacion(@PathVariable Integer id) {
        retroalimentacionService.eliminarRetroalimentacion(id);
        return ResponseEntity.noContent().build();
    }
}
