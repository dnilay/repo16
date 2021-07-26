package com.example.itemservice.controller;

import com.example.itemservice.dao.ItemRepository;
import com.example.itemservice.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("item-service is up!");
    }

    @GetMapping("/items")
    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }
    @GetMapping("/items/{itemName}")
    public Item getItemByName(@PathVariable String itemName) throws Exception {
        Item item=itemRepository.findByItemName(itemName);
        if(item==null)
        {
            throw new Exception("item not found");
        }
        return item;
    }

}
