package com.group4.orderSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.services.ItemService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class ItemController {

    @Autowired
    private ItemService service;

    //Get all items
    @GetMapping("/items")
    public List<Item> listItem() { return service.listAllItems(); };

    // Get item by id
    @GetMapping("/items/{id}")
    public ResponseEntity< Item > getItem(@PathVariable Long id) {
        try {
            Item item= service.findItemById(id);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    //Post new Item
    @PostMapping("/items")
    public void addItem(@RequestBody Item item) { service.save(item); };
}
