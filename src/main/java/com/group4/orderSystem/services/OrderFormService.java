package com.group4.orderSystem.services;

import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.repository.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrderFormService {
    @Autowired
    OrderFormRepository repo;

//    Find all orders from database
    public List<OrderForm> listAllOrders() { return repo.findAll(); };

//    Get order by id
    public OrderForm getOrderById(Long id) { return repo.findById(id).get();}

//    Post a new order to database
    public OrderForm save(OrderForm order) {
        repo.save(order);
        return order;
    }

}
