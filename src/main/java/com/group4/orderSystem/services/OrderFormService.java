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

    public List<OrderForm> listAllOrders() { return repo.findAll(); };

}
