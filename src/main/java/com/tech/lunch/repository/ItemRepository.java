package com.tech.lunch.repository;

import com.tech.lunch.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
}
