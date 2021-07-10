package com.group4.orderSystem.services;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository repo;

    //Find all items from database
    public List<Item> listAllItems() { return repo.findAll(); };

    //Save new item
    public Item save(Item item) {
        repo.save(item);
        return item;
    }

    //get Item by id
    public Item getItemById(Long id) { return repo.findById(id).get(); }

    //Delete Item by id
    public void deleteItemById(long id) { repo.deleteById(id); }

    //Modify Item by Id

}
