package com.tech.lunch.repository;

import com.tech.lunch.entity.CartaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaItemRepository extends JpaRepository<CartaItem, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}