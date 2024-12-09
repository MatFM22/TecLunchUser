package com.tech.lunch.repository;

import com.tech.lunch.entity.ReservaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReservaItemRepository extends JpaRepository<ReservaItem, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}
