package com.tech.lunch.repository;

import com.tech.lunch.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer>{
}
