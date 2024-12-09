package com.tech.lunch.repository;

import com.tech.lunch.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
}
