package com.group4.orderSystem.repository;

import com.group4.orderSystem.models.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFormRepository extends JpaRepository <OrderForm, Long> {
}
