package com.group4.orderSystem.controllers;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.models.OrderForm;
import com.group4.orderSystem.services.OrderFormService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping
public class OrderFormController {
    @Autowired
    private OrderFormService service;

//    Get all orders
    @GetMapping("/orders")
    public List<OrderForm> listOrder() { return service.listAllOrders(); }

//    Get order by id
    @GetMapping("/order/{id}")
    public ResponseEntity< OrderForm > getOrder(@PathVariable Long id){
        try{
            OrderForm order = service.getOrderById(id);
            return new ResponseEntity<OrderForm>(order, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    Get order by user id
    @GetMapping("/orders/user={id}")
    public List<OrderForm> getOrdersByUser(@PathVariable Long id) { return service.getOrderByUser(id); }

    //    Get order by item id
    @GetMapping("/orders/item={id}")
    public List<OrderForm> getOrdersByItem(@PathVariable Long id) { return service.getOrderByItem(id); }

//    Post new order
    @PostMapping("/orders")
    public void addOrder(@RequestBody OrderForm order) { service.save(order); }

// Delete an order
    @DeleteMapping("/order/{id}")
    public ResponseEntity< OrderForm > deleteOrder(@PathVariable("id")Long id){
        try{
            OrderForm order = service.getOrderById(id);
            service.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("order/{id}")
    public ResponseEntity<OrderForm>updateOrder(@PathVariable Long id, @RequestBody OrderForm order){
        try{
            OrderForm existOrder = service.getOrderById(id);

            existOrder.setStatus(order.getStatus());
            existOrder.setQuantity(order.getQuantity());

            OrderForm updatedOrder = service.save(existOrder);
            return ResponseEntity.ok(updatedOrder);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
