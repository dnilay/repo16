package com.example.itemservice;

import com.example.itemservice.dao.ItemRepository;
import com.example.itemservice.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemServiceApplication implements CommandLineRunner {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceApplication(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        itemRepository.save(new Item("Item-A",10.0,true));
        itemRepository.save(new Item("Item-B",11.0,true));
        itemRepository.save(new Item("Item-C",12.0,false));
        itemRepository.save(new Item("Item-D",13.0,false));
        itemRepository.save(new Item("Item-E",14.0,true));

    }
}
