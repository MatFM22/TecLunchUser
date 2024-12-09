package com.tech.lunch.repository;

import com.tech.lunch.entity.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoItemRepository extends JpaRepository<CarritoItem, Integer>{
}
