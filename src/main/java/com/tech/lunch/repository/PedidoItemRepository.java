package com.tech.lunch.repository;

import com.tech.lunch.entity.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
}
