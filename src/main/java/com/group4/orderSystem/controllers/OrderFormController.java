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
@RequestMapping(path = "orderForms")
public class OrderFormController {


    private final OrderFormService service;

    public OrderFormController(OrderFormService service) { this.service = service; }
    @GetMapping
    public List<OrderForm> listAllOrders() { return service.listAllOrders();};
}
