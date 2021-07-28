package com.group4.orderSystem.services;

import com.group4.orderSystem.models.Item;
import com.group4.orderSystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    // Get Item by title
    public List<Item> getItemsByTitle(String title) {  return repo.findItemByTitleContaining(title); }

    // Get Item by price
    public List<Item> getItemsByPrice(float price) {  return repo.findItemByPriceContaining(price); }

    // Get Item by price
    public List<Item> getItemsByGenre(String genre) {  return repo.findItemByGenre(genre); }

    //Delete Item by id
    public void deleteItemById(long id) { repo.deleteById(id); }

//    public void store(MultipartFile file){
//        String filename = file.getOriginalFilename();
//        Item item = new Item();
//        item.setImg();
//    }

}
