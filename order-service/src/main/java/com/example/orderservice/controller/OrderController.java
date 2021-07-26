package com.example.orderservice.controller;

import com.example.orderservice.dao.OrderDao;
import com.example.orderservice.model.Item;
import com.example.orderservice.model.ItemProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private OrderDao orderDao;
    private ItemProxy itemProxy;

    @Autowired
    public OrderController(OrderDao orderDao,ItemProxy itemProxy) {
        this.orderDao = orderDao;
        this.itemProxy=itemProxy;
    }
    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("order-service is up.");
    }
    @GetMapping("/orders/items")
    @HystrixCommand(fallbackMethod = "m1")
    public List<Item> getItemFromItemService()
    {
        return itemProxy.getAllItems();

    }
    public List<Item> m1()
    {
      log.info("within m1 fallback");
      ArrayList<Item> list=new ArrayList<Item>();
      list.add(new Item("null",0.0,false));
        return list;
    }

}
