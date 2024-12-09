package com.tech.lunch.repository;

import com.tech.lunch.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Integer>{
}
