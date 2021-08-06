package com.group4.orderSystem.repository;

import com.group4.orderSystem.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
        List<Item> findItemByTitleContaining(String title);
        List<Item> findItemByPriceContaining(float price);
        List<Item> findItemByGenre(String genre);
}
