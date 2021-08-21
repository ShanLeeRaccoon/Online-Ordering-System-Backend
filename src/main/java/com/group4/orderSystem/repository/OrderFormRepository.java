package com.group4.orderSystem.repository;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFormRepository extends JpaRepository <OrderForm, Long> {
    List<OrderForm> findOrdersByUserId(Long user_id);
    List<OrderForm> findOrdersByItemId(Long item_id);
}
