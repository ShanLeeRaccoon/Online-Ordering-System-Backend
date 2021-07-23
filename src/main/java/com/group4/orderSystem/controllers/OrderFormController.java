package com.group4.orderSystem.controllers;

import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.services.OrderFormService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class OrderFormController {
    @Autowired
    private OrderFormService service;

//    Get all orders
    @GetMapping("/orders")
    public List<OrderForm> listOrder() { return service.listAllOrders(); };

//    Get order by id
    @GetMapping("/order/{id}")
    public ResponseEntity< OrderForm > getOrder(@PathVariable Long id){
        try{
            OrderForm order = service.getOrderById(id);
            return new ResponseEntity<OrderForm>(order, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<OrderForm>(HttpStatus.NOT_FOUND);
        }
    }

//    Post new order
    @PostMapping("/orders")
    public void addOrder(@RequestBody OrderForm order) { service.save(order); };



}
