package com.group4.orderSystem.controllers;

import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.services.OrderFormService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class OrderFormController {
    @Autowired
    private OrderFormService service;

    @GetMapping("/orders")
    public List<OrderForm> listOrder() { return service.listAllOrders(); };


}
