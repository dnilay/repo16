package com.example.orderservice.controller;

import com.example.orderservice.dao.OrderDao;
import com.example.orderservice.model.Item;
import com.example.orderservice.model.ItemProxy;
import com.example.orderservice.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private OrderDao orderDao;
    private ItemProxy itemProxy;

    @Autowired
    public OrderController(OrderDao orderDao,ItemProxy itemProxy) throws Exception {
        this.orderDao = orderDao;
        this.itemProxy=itemProxy;
    }
    @GetMapping
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("order-service is up.");
    }

    @PostMapping("/orders")
    //@HystrixCommand(fallbackMethod = "m2")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws Exception{
        Item item=itemProxy.getItemByName(order.getItemName());
        if(item.isAvailable()==false)
        {
            log.info("item name found but item not available");
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDao.save(order));

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
    /*public ResponseEntity<Order> m2(@RequestBody Order order) throws Exception {
        log.info("within m2 fallback");
        return ResponseEntity.ok(null);
    }*/

}
