package com.group4.orderSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.services.ItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
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
            Item item= service.getItemById(id);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/title={title}")
    public List<Item> getItemsByTitle(@PathVariable String title) { return service.getItemsByTitle(title); }

//    @GetMapping("/items/price={price}")
//    public List<Item> getItemsByPrice(@PathVariable float price) {
//        return service.getItemsByPrice(price);
//    }

    @GetMapping("/items/genre={genre}")
    public List<Item> getItemsByPrice(@PathVariable String genre) {
        return service.getItemsByGenre(genre);
    }

    //Post new Item
    @PostMapping("/items")
    public void addItem(@RequestBody Item item) { service.save(item); };

    //Put an item by id
    @PutMapping("/items/{id}")
    public ResponseEntity<Item>updateCustomer(@PathVariable Long id,@RequestBody Item item) {
        try {
            Item existItem = service.getItemById(id);

            existItem.setTitle(item.getTitle());
            existItem.setPrice(item.getPrice());
            existItem.setInStock(item.getInStock());
            existItem.setDescription(item.getDescription());
            existItem.setGenre(item.getGenre());
            existItem.setImg(item.getImg());
            existItem.setSoldQty(item.getSoldQty());

            Item updatedItem = service.save(existItem);
            return ResponseEntity.ok(updatedItem);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity <Map< String, Boolean >> deleteItem(@PathVariable Long id)  {
        try{
            Item item = service.getItemById(id);
            service.deleteItemById(id);
            Map< String, Boolean > response = new HashMap< >();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
