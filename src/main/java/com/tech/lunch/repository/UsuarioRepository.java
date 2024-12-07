package com.tech.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.lunch.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    // Aquí puedes agregar métodos personalizados si es necesario
    Usuario findByCorreo(String correo);
}
