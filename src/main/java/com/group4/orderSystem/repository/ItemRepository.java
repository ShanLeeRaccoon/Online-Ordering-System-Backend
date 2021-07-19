package com.group4.orderSystem.repository;

import com.group4.orderSystem.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findItemById(String id);

}
