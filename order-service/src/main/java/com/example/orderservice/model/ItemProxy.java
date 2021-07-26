package com.example.orderservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "item-service")
public interface ItemProxy {
    @GetMapping("/items")
    public List<Item> getAllItems();
}
