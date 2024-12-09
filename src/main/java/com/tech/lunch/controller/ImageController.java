package com.tech.lunch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    // Ruta donde se almacenarán las imágenes
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    // Endpoint para subir una imagen
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        // Verifica si se ha recibido un archivo
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha seleccionado ninguna imagen.");
        }

        try {
            // Crea un directorio para almacenar las imágenes, si no existe
            Path path = Paths.get(UPLOAD_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            // Guardar la imagen con un nombre único basado en la fecha y el nombre original
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Guardar el archivo en el sistema
            file.transferTo(filePath.toFile());

            // Retornar la URL de la imagen
            String imageUrl = "http://localhost:8080/images/" + fileName;

            return ResponseEntity.status(HttpStatus.OK).body("Imagen subida correctamente. URL: " + imageUrl);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}
