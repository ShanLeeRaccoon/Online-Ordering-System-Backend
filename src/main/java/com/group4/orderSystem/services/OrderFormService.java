package com.group4.orderSystem.services;

import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.repository.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class OrderFormService {

    private final OrderFormRepository repo;

    @Autowired
    public OrderFormService(OrderFormRepository repo) {this.repo = repo;}

    public List<OrderForm> listAllOrders() { return repo.findAll(); };


}
