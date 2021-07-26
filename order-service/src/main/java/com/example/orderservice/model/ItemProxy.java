package com.example.orderservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.List;

@FeignClient(name = "item-service")
public interface ItemProxy {
    @GetMapping("/items")
    public List<Item> getAllItems();
    @GetMapping("/items/{itemName}")
    public Item getItemByName(@PathVariable("itemName") String itemName);
}
